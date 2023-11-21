package com.teenkung.devlottery.Manager;

import com.teenkung.devlottery.ConfigLoader;
import com.teenkung.devlottery.SQLManager;
import org.bukkit.entity.Player;

import java.util.Map;

public class PlayerDataManager {

    private ConfigLoader config;
    private SQLManager sql;
    private Map<Player, PlayerManager> managers;

    public PlayerDataManager(ConfigLoader config, SQLManager sql) {
        this.config = config;
        this.sql = sql;
    }

    public void loadPlayer(Player player) {
        managers.put(player, new PlayerManager(player, config, sql));
    }

    public void unloadPlayer(Player player) {
        managers.remove(player);
    }

    public PlayerManager getPlayerManager(Player player) {
        return managers.get(player);
    }

}
