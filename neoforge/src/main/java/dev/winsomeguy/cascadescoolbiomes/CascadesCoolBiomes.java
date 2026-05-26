package dev.winsomeguy.cascadescoolbiomes;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@Mod(Constants.MOD_ID)
public class CascadesCoolBiomes {

    public CascadesCoolBiomes(IEventBus modEventBus) {
        CascadesCoolBiomesCommon.init();
        // Cloth Confog
        ModConfig.register();
        CascadesCoolBiomesCommon.setNotificationsEnabled(ModConfig.get().enableJoinNotifications);

        NeoForge.EVENT_BUS.addListener(this::onPlayerLogin);
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
}