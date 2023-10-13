package fr.unchat.catapi.bossbar;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Boss {
    private Map<Player, BossBar> bossBars = new HashMap<>();

    public void setBar(Player player, BossBar bar) {
        bar.addPlayer(player);
    }
}
