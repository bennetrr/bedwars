package io.github.bennetrr.bedwarsplugin.game_elements;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.List;

public class BPGame {
    private final BPMap map;
    private final List<BPTeam> teams;
    private final BPSpectatingTeam spectatingTeam;
    private int runtimeTimer;
    private final BedwarsPlugin plugin;

    public BPGame(BPMap map, List<BPTeam> teams, BPSpectatingTeam spectatingTeam, BedwarsPlugin plugin) {
        this.map = map;
        this.teams = teams;
        this.spectatingTeam = spectatingTeam;
        this.plugin = plugin;

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

        // Winner detection
        List<BPTeam> leftTeams = teams.stream().filter(BPTeam::isEliminated).toList();
        if (leftTeams.size() == 1) {
            plugin.getServer().broadcast(Component.text(leftTeams.get(0).getFullName() + " won this game!").color(leftTeams.get(0).getColor()));
            plugin.stopGame();
        }
    }

    @Nullable
    public BPTeam getTeamForPlayer(Player player) {
        return teams.stream().filter(team -> team.getPlayers().contains(player)).findFirst().orElse(null);
    }

    public BPMap getMap() {
        return map;
    }

    public List<BPTeam> getTeams() {
        return teams;
    }

    public BPSpectatingTeam getSpectatingTeam() {
        return spectatingTeam;
    }

    public int getRuntimeTimer() {
        return runtimeTimer;
    }
}
