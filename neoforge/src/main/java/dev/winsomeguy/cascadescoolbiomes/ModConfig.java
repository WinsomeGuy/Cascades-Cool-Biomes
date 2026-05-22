package dev.winsomeguy.cascadescoolbiomes;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.TomlConfigSerializer;

@Config(name = Constants.MOD_ID)
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean enableJoinNotifications = true;

    public static ModConfig get() {
        return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    public static void register() {
        AutoConfig.register(ModConfig.class, TomlConfigSerializer::new);
    }
}