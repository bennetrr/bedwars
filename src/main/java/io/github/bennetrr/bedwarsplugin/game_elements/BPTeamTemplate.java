package io.github.bennetrr.bedwarsplugin.game_elements;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.World;

public class BPTeamTemplate {
    protected final NamedTextColor color;
    protected final String name;
    protected final String fullName;
    protected final Location bedLoc;
    protected final Location itemVillagerLoc;
    protected final Location upgradeVillagerLoc;
    protected final Location spawnerLoc;
    protected final Location spawnLoc;
    protected final Location startLoc;
    protected final Location endLoc;
    protected final World world;

    public BPTeamTemplate(NamedTextColor color, String name, String fullName, Location bedLoc, Location itemVillagerLoc, Location upgradeVillagerLoc, Location spawnerLoc, Location spawnLoc, Location startLoc, Location endLoc) {
        this.color = color;
        this.name = name;
        this.fullName = fullName;
        this.bedLoc = bedLoc;
        this.itemVillagerLoc = itemVillagerLoc;
        this.upgradeVillagerLoc = upgradeVillagerLoc;
        this.spawnerLoc = spawnerLoc;
        this.spawnLoc = spawnLoc;
        world = spawnLoc.getWorld();
        this.startLoc = startLoc;
        this.endLoc = endLoc;
    }

    public NamedTextColor getColor() {
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

    public Location getSpawnLoc() {
        return spawnLoc;
    }

    public Location getStartLoc() {
        return startLoc;
    }

    public Location getEndLoc() {
        return endLoc;
    }
}
