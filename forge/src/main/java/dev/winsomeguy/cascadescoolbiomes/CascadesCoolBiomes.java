package dev.winsomeguy.cascadescoolbiomes;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class CascadesCoolBiomes {

    public CascadesCoolBiomes() {
        CascadesCoolBiomesCommon.init();

        MinecraftForge.EVENT_BUS.addListener(this::onPlayerLogin);
    }

    private void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        boolean hasWwoo = ModList.get().isLoaded(Constants.WWOO_MOD_ID);
        boolean hasTnT = ModList.get().isLoaded(Constants.TNT_MOD_ID);

        if (!hasWwoo) {
            player.sendSystemMessage(Component.literal(
                    "§e[Cascades Cool Biomes] §fWilliam Wythers' Overhauled Overworld (WWOO) is not installed. " +
                            "Biome visuals may not look their best! Get it at: §bhttps://modrinth.com/mod/wwoo"
            ));
        }

        if (!hasTnT) {
            player.sendSystemMessage(Component.literal(
                    "§e[Cascades Cool Biomes] §fTowns & Towers is not installed. " +
                            "Some Optional cool structures can be added! Get it at: §bhttps://modrinth.com/mod/towns-and-towers"
            ));
        }
    }
}