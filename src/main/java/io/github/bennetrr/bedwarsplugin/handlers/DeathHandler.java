package io.github.bennetrr.bedwarsplugin.handlers;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeam;
import net.kyori.adventure.text.Component;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathHandler implements Listener {
    private final BedwarsPlugin plugin;

    public DeathHandler(BedwarsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (plugin.isGameRunning()) {
            // Get the team of the player
            BPTeam team = plugin.getGame().getTeamForPlayer(player);
            if (team == null) return;

            // Set the respawn point of the player
            event.setRespawnLocation(team.getSpawnLoc());

            // If the teams bed is destroyed, set the player to spectator mode
            if (team.isBedDestroyed()) {
                plugin.resetPlayer(player);
                player.setGameMode(GameMode.SPECTATOR);
            }
        } else {
            event.setRespawnLocation(plugin.getSpawnLoc());
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDeath(PlayerDeathEvent event) {
        event.getDrops().removeIf(itemStack -> !itemStack.getType().equals(Material.IRON_INGOT) || !itemStack.getType().equals(Material.GOLD_INGOT) || !itemStack.getType().equals(Material.DIAMOND) || !itemStack.getType().equals(Material.EMERALD));

        Player player = event.getPlayer();
        if (plugin.isGameRunning()) {
            // Get the team of the player
            BPTeam team = plugin.getGame().getTeamForPlayer(player);
            if (team == null) return;

            // If the teams bed is destroyed, set the player to spectator mode
            if (team.isBedDestroyed()) event.deathMessage(event.deathMessage().append(Component.text(" (Final Kill)")));
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onVoidDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) player.setHealth(0);
    }
}
