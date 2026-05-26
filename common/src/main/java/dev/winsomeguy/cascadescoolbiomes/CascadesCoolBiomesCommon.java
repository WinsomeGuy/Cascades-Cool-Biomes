package dev.winsomeguy.cascadescoolbiomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;

public class CascadesCoolBiomesCommon {
    public static final Logger LOG = LoggerFactory.getLogger(Constants.MOD_NAME);
    private static boolean notificationsEnabled = true;

    public static void init() {
        LOG.info("{} common init complete.", Constants.MOD_NAME);
    }
    public static void setNotificationsEnabled(boolean enabled) {
        notificationsEnabled = enabled;
    }
    public static Component buildNotificationMessage(String messageText, String url) {
        MutableComponent prefix = Component.literal("[Cascades Cool Biomes] ")
                .withStyle(ChatFormatting.YELLOW);

        MutableComponent body = Component.literal(messageText + " ")
                .withStyle(ChatFormatting.WHITE);

        MutableComponent urlButton = Component.literal("[Get it here]")
                .withStyle(style -> style
                        .withColor(ChatFormatting.AQUA)
                        .withUnderlined(true)
                        .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url))
                );

        MutableComponent disableButton = Component.literal("  [Don't show again]")
                .withStyle(style -> style
                        .withColor(ChatFormatting.GRAY)
                        .withItalic(true)
                        .withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ccb notifications off"))
                );

        return prefix.append(body).append(urlButton).append(disableButton);
    }
    public static boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    // Commmon Command Handel :D
    public static int handleNotificationsCommand(ServerPlayer player, String state) {
        switch (state.toLowerCase()) {
            case "off" -> {
                setNotificationsEnabled(false);
                player.sendSystemMessage(Component.literal(
                        "§e[Cascades Cool Biomes] §fJoin notifications disabled. Use §7/ccb notifications on §fto re-enable."
                ));
            }
            case "on" -> {
                setNotificationsEnabled(true);
                player.sendSystemMessage(Component.literal(
                        "§e[Cascades Cool Biomes] §fJoin notifications re-enabled."
                ));
            }
            default -> {
                player.sendSystemMessage(Component.literal(
                        "§e[Cascades Cool Biomes] §cUnknown state. Use §7on §cor §7off§c."
                ));
            }
        }
        return 1;
    }
}
