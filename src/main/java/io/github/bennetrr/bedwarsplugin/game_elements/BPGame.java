package io.github.bennetrr.bedwarsplugin.game_elements;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Server;

import java.util.List;

public class BPGame {
    private final BPMap map;
    private final List<BPTeam> teams;
    private int runtimeTimer;

    public BPGame(BPMap map, List<BPTeam> teams) {
        this.map = map;
        this.teams = teams;

        runtimeTimer = 0;
    }

    public void tickActions(Server server) {
        map.tickActions();
        teams.forEach(BPTeam::tickActions);

        // Timer
        runtimeTimer++;
        int seconds = runtimeTimer / 20;
        int minutes = seconds / 60;
        int realSeconds = seconds - (minutes * 60);

        server.getOnlinePlayers().forEach(player -> player.sendActionBar(Component.text(minutes + "min " + realSeconds + "s").color(NamedTextColor.GOLD)));

        // Emerald and diamond rate incremental
        switch (runtimeTimer) {
            case 6000 -> {
                map.setDiamondTimerMax(333);
                server.broadcast(Component.text("The Diamond Spawners are now on level I"));
            }
            case 12000 -> {
                map.setEmeraldTimerMax(533);
                server.broadcast(Component.text("The Emerald Spawners are now on level I"));
            }
            case 18000 -> {
                map.setDiamondTimerMax(250);
                server.broadcast(Component.text("The Diamond Spawners are now on level II"));
            }
            case 24000 -> {
                map.setEmeraldTimerMax(400);
                server.broadcast(Component.text("The Emerald Spawners are now on level II"));
            }
            case 30000 -> {
                map.setDiamondTimerMax(167);
                server.broadcast(Component.text("The Diamond Spawners are now on level III"));
            }
            case 36000 -> {
                map.setEmeraldTimerMax(267);
                server.broadcast(Component.text("The Emerald Spawners are now on level III"));
            }
        }
    }

    public BPMap getMap() {
        return map;
    }

    public List<BPTeam> getTeams() {
        return teams;
    }
}
