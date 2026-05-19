package dev.winsomeguy.cascadescoolbiomes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.MinecraftServer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class CascadesCoolBiomes implements ModInitializer {

    @Override
    public void onInitialize() {
        CascadesCoolBiomesCommon.init();

        // Opptional mod check
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayer player = handler.player;

            boolean hasWwoo = FabricLoader.getInstance().isModLoaded(Constants.WWOO_MOD_ID);
            boolean hasTnT = FabricLoader.getInstance().isModLoaded(Constants.TNT_MOD_ID);

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
        });
    }
}