package io.github.bennetrr.bedwarsplugin.handlers;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import io.github.bennetrr.bedwarsplugin.exceptions.NotEnoughPlayersException;
import io.github.bennetrr.bedwarsplugin.exceptions.WrongCommandArgumentsException;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeam;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    private final BedwarsPlugin plugin;

    public Commands(BedwarsPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String commandLabel, String[] args) {
        switch (cmd.getName().toLowerCase()) {
            case "start":
                startCommand();
                return true;
            case "teaminfo":
                teamInfoCommand(sender);
                return true;
            case "bedwars":
                return true;
            default:
                return false;
        }
    }

    private void startCommand() {
        try {
            plugin.startGame(1, 3);
        } catch (WrongCommandArgumentsException | NotEnoughPlayersException e) {
            e.printStackTrace();
        }
    }

    private void teamInfoCommand(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("You have to run this command as a player!").color(NamedTextColor.RED));
            return;
        }

        if (plugin.isGameRunning()) {
            sender.sendMessage(Component.text("You cannot run this command when no game is running!").color(NamedTextColor.RED));
            return;
        }

        BPTeam team = plugin.getGame().getTeamForPlayer(player);
        if (team == null) {
            sender.sendMessage(Component.text("You have to be in a team to run this command!").color(NamedTextColor.RED));
            return;
        }

        player.sendMessage(Component.text("=== Team Information ==="));
        player.sendMessage(Component.text("Strength Upgrade: Level " + team.getStrengthUpgrade()));
        player.sendMessage(Component.text("Regeneration Upgrade: Level " + (team.hasRegenUpgrade() ? "1" : "0")));
        player.sendMessage(Component.text("Strength Upgrade: Level " + team.getStrengthUpgrade()));
    }
}
