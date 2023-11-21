package com.teenkung.devlottery;

import org.bukkit.plugin.java.JavaPlugin;

public final class DevLottery extends JavaPlugin {

    private ConfigLoader config;
    private SQLManager sql;

    @Override
    public void onEnable() {
        this.config = new ConfigLoader(this);
        this.sql = new SQLManager(this, config);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
