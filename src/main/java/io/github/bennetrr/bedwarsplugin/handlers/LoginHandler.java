package io.github.bennetrr.bedwarsplugin.handlers;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginHandler implements Listener {
    private final BedwarsPlugin plugin;

    public LoginHandler(BedwarsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(Component.text("Bedwars v1.0.0 by bennetr and B3Crazy").color(NamedTextColor.DARK_GREEN));
        plugin.resetPlayer(player);

        if (!plugin.isGameRunning()) {
            // If no game is running
            // Teleport the player to the spawn
            player.teleport(plugin.getSpawnLoc());
            // Set their game mode
            player.setGameMode(GameMode.ADVENTURE);
        } else {
            // If a game is running, them to the spectating team
            plugin.getGame().getSpectatingTeam().addPlayer(player);
        }
    }
}
