package io.github.bennetrr.bedwarsplugin.game_elements;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class BPSpectatingTeam {
    private final Location spawnpoint;
    private final List<Player> players;

    public BPSpectatingTeam(Location spawnpoint, List<Player> players) {
        this.spawnpoint = spawnpoint;
        this.players = players;

        players.forEach(this::addPlayer);
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.teleport(spawnpoint);
        player.setGameMode(GameMode.SPECTATOR);
    }

    public Location getSpawnpoint() {
        return spawnpoint;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
