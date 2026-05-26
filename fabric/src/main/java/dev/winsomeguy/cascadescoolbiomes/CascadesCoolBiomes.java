package dev.winsomeguy.cascadescoolbiomes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.level.ServerPlayer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.resources.ResourceLocation;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import com.mojang.brigadier.arguments.StringArgumentType;

public class CascadesCoolBiomes implements ModInitializer {

    @Override
    public void onInitialize() {
        CascadesCoolBiomesCommon.init();
        //Cloth Config
        ModConfig.register();
        CascadesCoolBiomesCommon.setNotificationsEnabled(ModConfig.get().enableJoinNotifications);
        // Making mod load on top : D
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, Constants.MOD_ID),
                    container,
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
        });
        // Command register
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
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
        });

        // Opptional mod check, Updated ( Check OP )
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayer player = handler.player;

            if (!CascadesCoolBiomesCommon.isNotificationsEnabled()) return;
            if (!player.hasPermissions(2)) return;

            boolean hasWwoo = FabricLoader.getInstance().isModLoaded(Constants.WWOO_MOD_ID);
            boolean hasTnT = FabricLoader.getInstance().isModLoaded(Constants.TNT_MOD_ID);

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
        });
    }
}