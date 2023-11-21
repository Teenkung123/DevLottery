package com.teenkung.devlottery;

import org.bukkit.plugin.java.JavaPlugin;

public final class DevLottery extends JavaPlugin {

    private ConfigLoader config;
    private SQLManager sql;

    @Override
    public void onEnable() {
        getLogger().info("Loading config and sql...");

        this.config = new ConfigLoader(this);
        config.loadConfig();

        this.sql = new SQLManager(config);
        sql.connect();

        getLogger().info(colorize("&aConfig and sql loaded."));
    }

    @Override
    public void onDisable() {
        sql.disconnect();
    }

    public String colorize(String s) {
        return s.replaceAll("&", "§");
    }
}
