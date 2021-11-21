package io.github.bennetrr.bedwarsplugin.game_elements;

import org.bukkit.ChatColor;
import org.bukkit.Location;

public class BPTeamTemplate {
    protected final ChatColor color;
    protected final String name;
    protected final String fullName;
    protected final Location bedLoc;
    protected final Location itemVillagerLoc;
    protected final Location upgradeVillagerLoc;
    protected final Location spawnerLoc;
    protected final Location spawnpoint;

    public BPTeamTemplate(ChatColor color, String name, String fullName, Location bedLoc, Location itemVillagerLoc, Location upgradeVillagerLoc, Location spawnerLoc, Location spawnpoint) {
        this.color = color;
        this.name = name;
        this.fullName = fullName;
        this.bedLoc = bedLoc;
        this.itemVillagerLoc = itemVillagerLoc;
        this.upgradeVillagerLoc = upgradeVillagerLoc;
        this.spawnerLoc = spawnerLoc;
        this.spawnpoint = spawnpoint;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Location getBedLoc() {
        return bedLoc;
    }

    public Location getItemVillagerLoc() {
        return itemVillagerLoc;
    }

    public Location getUpgradeVillagerLoc() {
        return upgradeVillagerLoc;
    }

    public Location getSpawnerLoc() {
        return spawnerLoc;
    }

    public Location getSpawnpoint() {
        return spawnpoint;
    }
}
