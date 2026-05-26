package dev.winsomeguy.cascadescoolbiomes;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.minecraft.commands.Commands;
import com.mojang.brigadier.arguments.StringArgumentType;
import me.shedaniel.autoconfig.AutoConfig;

@Mod(Constants.MOD_ID)
public class CascadesCoolBiomes {

    public CascadesCoolBiomes(IEventBus modEventBus) {
        CascadesCoolBiomesCommon.init();
        // Cloth Confog
        ModConfig.register();
        CascadesCoolBiomesCommon.setNotificationsEnabled(ModConfig.get().enableJoinNotifications);
        // Callback
        CascadesCoolBiomesCommon.setOnNotificationsChangedCallback(() -> {
            ModConfig.get().enableJoinNotifications = CascadesCoolBiomesCommon.isNotificationsEnabled();
            AutoConfig.getConfigHolder(ModConfig.class).save();
        });

        NeoForge.EVENT_BUS.addListener(this::onPlayerLogin);
        NeoForge.EVENT_BUS.addListener(this::onRegisterCommands);
    }

    private void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        // Return without op
        if (!CascadesCoolBiomesCommon.isNotificationsEnabled()) return;
        if (!player.hasPermissions(2)) return;

        boolean hasWwoo = ModList.get().isLoaded(Constants.WWOO_MOD_ID);
        boolean hasTnT = ModList.get().isLoaded(Constants.TNT_MOD_ID);

        if (!hasWwoo) {
            player.sendSystemMessage(CascadesCoolBiomesCommon.buildNotificationMessage(
                    "William Wythers' Overhauled Overworld (WWOO) is not installed. Vanilla Biomes may look out of place!",
                    "https://modrinth.com/mod/wwoo"
            ));
        }
        if (!hasTnT) {
            player.sendSystemMessage(CascadesCoolBiomesCommon.buildNotificationMessage(
                    "Towns & Towers is not installed. Some optional cool structures can be added!",
                    "https://modrinth.com/mod/towns-and-towers"
            ));
        }
    }

    // Register Command
    private void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("ccb")
                        .then(Commands.literal("notifications")
                                .then(Commands.argument("state", StringArgumentType.word())
                                        .suggests((ctx, builder) -> {
                                            builder.suggest("on");
                                            builder.suggest("off");
                                            return builder.buildFuture();
                                        })
                                        .executes(ctx -> {
                                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                                            String state = StringArgumentType.getString(ctx, "state");
                                            return CascadesCoolBiomesCommon.handleNotificationsCommand(player, state);
                                        })
                                )
                        )
        );
    }
}