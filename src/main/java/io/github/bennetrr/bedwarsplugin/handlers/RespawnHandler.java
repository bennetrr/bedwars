package io.github.bennetrr.bedwarsplugin.handlers;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeam;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.jetbrains.annotations.Nullable;

public class RespawnHandler implements Listener {
    private final BedwarsPlugin plugin;

    public RespawnHandler(BedwarsPlugin plugin) {
        this.plugin = plugin;
    }

    private @Nullable BPTeam getPlayersTeam(Player player) {
        return plugin.getGame().getTeams().stream().filter(team -> team.getPlayers().contains(player)).findFirst().orElse(null);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onRespawn(PlayerRespawnEvent event) {
        if (plugin.isGameRunning()) {
            Player player = event.getPlayer();

            // Get the team of the player
            BPTeam team = getPlayersTeam(player);
            if (team == null) return;

            // Set the respawn point of the player
            event.setRespawnLocation(team.getSpawnpoint());

            // If the team is eliminated, set the player to spectator mode
            if (team.isEliminated()) {
                player.setGameMode(GameMode.SPECTATOR);
            }
        }
    }
}
