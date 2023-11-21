package com.teenkung.devlottery.Manager;

import com.teenkung.devlottery.ConfigLoader;
import com.teenkung.devlottery.SQLManager;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerManager {

    private Player player;
    private ConfigLoader config;
    private SQLManager sql;

    public PlayerManager(Player player, ConfigLoader config, SQLManager sql) {
        this.player = player;
        this.config = config;
        this.sql = sql;

        try {
            PreparedStatement statement = sql.getConnection().prepareStatement("SELECT * FROM lottery_players WHERE uuid = ?");
            statement.setString(1, player.getUniqueId().toString());
            statement.executeQuery();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
