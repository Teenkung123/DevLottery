package com.teenkung.devlottery;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {

    private final DevLottery plugin;
    private Map<String, Object> configs;


    public ConfigLoader(DevLottery plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveDefaultConfig();

        ConfigurationSection section = plugin.getConfig().getConfigurationSection("");
        if (section != null) {
            configs = section.getValues(true);
        } else {
            configs = new HashMap<>();
        }
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        loadConfig();
    }

    public Object get(String key) {
        return configs.get(key);
    }

    public String getString(String key) {
        return (String) configs.get(key);
    }

    public int getInt(String key) {
        return (int) configs.get(key);
    }

    public boolean getBoolean(String key) {
        return (boolean) configs.get(key);
    }

    public double getDouble(String key) {
        return (double) configs.get(key);
    }

    public long getLong(String key) {
        return (long) configs.get(key);
    }

    public float getFloat(String key) {
        return (float) configs.get(key);
    }

}
