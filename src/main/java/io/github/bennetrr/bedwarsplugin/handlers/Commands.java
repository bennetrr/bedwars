package io.github.bennetrr.bedwarsplugin.handlers;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import io.github.bennetrr.bedwarsplugin.exceptions.NotEnoughPlayersException;
import io.github.bennetrr.bedwarsplugin.exceptions.WrongCommandArgumentsException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        try {
            plugin.startGame(1, 1);
        } catch (WrongCommandArgumentsException | NotEnoughPlayersException e) {
            e.printStackTrace();
        }
    }
}
