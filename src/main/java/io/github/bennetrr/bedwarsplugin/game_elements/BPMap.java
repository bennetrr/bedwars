package io.github.bennetrr.bedwarsplugin.game_elements;

import io.github.bennetrr.bedwarsplugin.utils.LocationRelativizer;
import io.github.bennetrr.bedwarsplugin.utils.WorldEditStuff;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class BPMap {
    private final List<BPTeamTemplate> teams;
    private final List<Location> diamondSpawnerLocs;
    private final List<Location> emeraldSpawnerLocs;
    private final Location startLoc;
    private final Location endLoc;
    private final Location pasteLoc;
    private final World world;

    private int diamondTimer;
    private int diamondTimerMax;
    private int emeraldTimer;
    private int emeraldTimerMax;

    public BPMap(List<BPTeamTemplate> teams, List<Location> diamondSpawnerLocs, List<Location> emeraldSpawnerLocs, Location startLoc, Location endLoc, Location pasteLoc) {
        this.teams = teams;
        this.diamondSpawnerLocs = diamondSpawnerLocs;
        this.emeraldSpawnerLocs = emeraldSpawnerLocs;
        this.startLoc = startLoc;
        this.endLoc = endLoc;
        this.pasteLoc = pasteLoc;
        world = this.startLoc.getWorld();

        diamondTimer = 500;
        diamondTimerMax = 500;
        emeraldTimer = 800;
        emeraldTimerMax = 800;
    }

    public void tickActions() {
        LocationRelativizer r = new LocationRelativizer(startLoc, pasteLoc);

        // Diamonds
        diamondTimer++;
        if (diamondTimer >= diamondTimerMax) {
            diamondTimer = 0;
            diamondSpawnerLocs.forEach(loc -> world.spawn(r.c(loc), Item.class, item -> item.setItemStack(new ItemStack(Material.DIAMOND, 1))));
        }

        // Emeralds
        emeraldTimer++;
        if (emeraldTimer >= emeraldTimerMax) {
            emeraldTimer = 0;
            emeraldSpawnerLocs.forEach(loc -> world.spawn(r.c(loc), Item.class, item -> item.setItemStack(new ItemStack(Material.EMERALD, 1))));
        }
    }

    public void copyMap() {
        WorldEditStuff.copyMap(startLoc, endLoc, pasteLoc);
    }

    public List<BPTeamTemplate> getTeams() {
        return teams;
    }

    public List<Location> getDiamondSpawnerLocs() {
        return diamondSpawnerLocs;
    }

    public List<Location> getEmeraldSpawnerLocs() {
        return emeraldSpawnerLocs;
    }

    public Location getStartLoc() {
        return startLoc;
    }

    public Location getEndLoc() {
        return endLoc;
    }

    public int getDiamondTimerMax() {
        return diamondTimerMax;
    }

    public void setDiamondTimerMax(int diamondTimerMax) {
        this.diamondTimerMax = diamondTimerMax;
    }

    public int getEmeraldTimerMax() {
        return emeraldTimerMax;
    }

    public void setEmeraldTimerMax(int emeraldTimerMax) {
        this.emeraldTimerMax = emeraldTimerMax;
    }
}
