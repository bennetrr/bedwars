package io.github.bennetrr.bedwarsplugin.game_elements;

import io.github.bennetrr.bedwarsplugin.utils.WorldEditStuff;
import org.bukkit.Location;
import org.bukkit.World;

public class BPMap {
    private final BPTeamTemplate[] teams;
    private final Location[] diamondSpawnerLocs;
    private final Location[] emeraldSpawnerLocs;
    private final Location startLoc;
    private final Location endLoc;
    private final World w;

    public BPMap(BPTeamTemplate[] teams, Location[] diamondSpawnerLocs, Location[] emeraldSpawnerLocs, Location startLoc, Location endLoc) {
        this.teams = teams;
        this.diamondSpawnerLocs = diamondSpawnerLocs;
        this.emeraldSpawnerLocs = emeraldSpawnerLocs;
        this.startLoc = startLoc;
        this.endLoc = endLoc;
        w = startLoc.getWorld();
    }

    public BPTeamTemplate[] getTeams() {
        return teams;
    }

    public Location[] getDiamondSpawnerLocs() {
        return diamondSpawnerLocs;
    }

    public Location[] getEmeraldSpawnerLocs() {
        return emeraldSpawnerLocs;
    }

    public Location getStartLoc() {
        return startLoc;
    }

    public Location getEndLoc() {
        return endLoc;
    }

    public void copyMap(Location pasteLoc) {
        WorldEditStuff.copyMap(startLoc, endLoc, pasteLoc);
    }
}
