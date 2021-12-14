package io.github.bennetrr.bedwarsplugin.game_elements;

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

    public BPTeam(NamedTextColor color, String name, String fullName, Location bedLoc, Location itemVillagerLoc, Location upgradeVillagerLoc, Location spawnerLoc, Location spawnpoint, Player[] players) {
        super(color, name, fullName, bedLoc, itemVillagerLoc, upgradeVillagerLoc, spawnerLoc, spawnpoint);
        this.players = players;

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
        itemVillager = world.spawn(itemVillagerLoc, Villager.class, villager -> {
            villager.customName(Component.text(this.color + "Items"));
            VillagerUtils.setDump(villager);


        });


        upgradeVillager = world.spawn(upgradeVillagerLoc, Villager.class, villager -> {
            villager.customName(Component.text(this.color + "Upgrades"));
            VillagerUtils.setDump(villager);
        });
    }

    public static BPTeam fromTemplate(BPTeamTemplate t, List<Player> players) {
        Player[] players1 = players.toArray(new Player[0]);
        return new BPTeam(t.getColor(), t.getName(), t.getFullName(), t.getBedLoc(), t.getItemVillagerLoc(), t.getUpgradeVillagerLoc(), t.getSpawnerLoc(), t.getSpawnpoint(), players1);
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
}
