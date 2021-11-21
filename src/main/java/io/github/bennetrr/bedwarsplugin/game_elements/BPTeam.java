package io.github.bennetrr.bedwarsplugin.game_elements;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class BPTeam extends BPTeamTemplate {
    private final Player[] players;
    private final Team team;
    private boolean eliminated = false;

    public static BPTeam fromTemplate(BPTeamTemplate t, Player[] players) {
        return new BPTeam(t.getColor(), t.getName(), t.getFullName(), t.getBedLoc(), t.getItemVillagerLoc(), t.getUpgradeVillagerLoc(), t.getSpawnerLoc(), t.getSpawnpoint(), players);
    }

    public static BPTeam fromTemplate(BPTeamTemplate t, List<Player> players) {
        Player[] players1 = players.toArray(new Player[0]);
        return new BPTeam(t.getColor(), t.getName(), t.getFullName(), t.getBedLoc(), t.getItemVillagerLoc(), t.getUpgradeVillagerLoc(), t.getSpawnerLoc(), t.getSpawnpoint(), players1);
    }

    public BPTeam(ChatColor color, String name, String fullName, Location bedLoc, Location itemVillagerLoc, Location upgradeVillagerLoc, Location spawnerLoc, Location spawnpoint, Player[] players) {
        super(color, name, fullName, bedLoc, itemVillagerLoc, upgradeVillagerLoc, spawnerLoc, spawnpoint);
        this.players = players;

        // Team for display in game
        team = Bukkit.getScoreboardManager().getNewScoreboard().registerNewTeam(this.name);
        team.setColor(this.color);
        team.setDisplayName(this.fullName);
        team.setPrefix(this.color + "[" + this.fullName + "] ");

        // Making invisible teammates have a transparent body
        team.setCanSeeFriendlyInvisibles(true);

        // Add players to the team
        for (Player player : players) {
            team.addPlayer(player);
        }
    }

    public void remove() {
        team.unregister();
    }

    public Player[] getPlayers() {
        return players;
    }

    public Team getTeam() {
        return team;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }
}
