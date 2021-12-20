package io.github.bennetrr.bedwarsplugin.game_elements;

import io.github.bennetrr.bedwarsplugin.utils.LocationRelativizer;
import io.github.bennetrr.bedwarsplugin.utils.VillagerUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.scoreboard.Team;

import java.util.List;

public class BPTeam extends BPTeamTemplate {
    private final Player[] players;
    private final Team team;
    private boolean eliminated = false;
    private final Villager itemVillager, upgradeVillager;
    private final LocationRelativizer r;

    public BPTeam(NamedTextColor color, String name, String fullName, Location bedLoc, Location itemVillagerLoc, Location upgradeVillagerLoc, Location spawnerLoc, Location spawnpoint, Player[] players, Location mapStartLoc, Location mapPasteLoc) {
        super(color, name, fullName, bedLoc, itemVillagerLoc, upgradeVillagerLoc, spawnerLoc, spawnpoint);
        this.players = players;

        r = new LocationRelativizer(mapStartLoc, mapPasteLoc);

        // Team for display in game
        team = Bukkit.getScoreboardManager().getNewScoreboard().registerNewTeam(this.name);
        team.color(NamedTextColor.GREEN);
        team.displayName(Component.text(this.fullName));
        team.prefix(Component.text(this.color + "[" + this.fullName + "] "));

        // Making invisible teammates have a transparent body
        team.setCanSeeFriendlyInvisibles(true);

        // Add players to the team
        for (Player player : players) {
            team.addEntry(player.getName());
        }

        // Spawn and prepare the villagers
        itemVillager = world.spawn(r.c(itemVillagerLoc), Villager.class, villager -> {
            villager.customName(Component.text(this.color + "Items"));
            VillagerUtils.setDump(villager);
            VillagerUtils.addTrades(villager, VillagerTrades.getItemTraderTrades());
        });

        upgradeVillager = world.spawn(r.c(upgradeVillagerLoc), Villager.class, villager -> {
            villager.customName(Component.text(this.color + "Upgrades"));
            VillagerUtils.setDump(villager);
            VillagerUtils.addTrades(villager, VillagerTrades.getUpgradeTraderTrades());
        });
    }

    public static BPTeam fromTemplate(BPTeamTemplate t, List<Player> players, Location mapStartLoc, Location mapPasteLoc) {
        Player[] players1 = players.toArray(new Player[0]);
        return new BPTeam(t.getColor(), t.getName(), t.getFullName(), t.getBedLoc(), t.getItemVillagerLoc(), t.getUpgradeVillagerLoc(), t.getSpawnerLoc(), t.getSpawnpoint(), players1, mapStartLoc, mapPasteLoc);
    }

    public void tickActions() {

    }

    public void close() {
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

    public Villager getItemVillager() {
        return itemVillager;
    }

    public Villager getUpgradeVillager() {
        return upgradeVillager;
    }
}
