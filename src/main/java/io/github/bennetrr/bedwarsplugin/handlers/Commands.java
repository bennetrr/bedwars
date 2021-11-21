package io.github.bennetrr.bedwarsplugin.handlers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;

public class Commands implements CommandExecutor {
    private final BedwarsPlugin plugin;

    public Commands(BedwarsPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        switch (cmd.getName().toLowerCase()) {
            case "start":
                startCommand();
                return true;

            default:
                return false;
        }
    }

    private void startCommand() {
        // TODO: Use values from the command arguments
        plugin.startGame(1, 1);
    }
}
