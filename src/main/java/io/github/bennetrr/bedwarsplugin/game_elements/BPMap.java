package io.github.bennetrr.bedwarsplugin.game_elements;

import org.bukkit.Location;

import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;

import io.github.bennetrr.bedwarsplugin.utils.Converters;

public class BPMap {
    private final BPTeamTemplate[] teams;
    private final Location[] diamondSpawnerLocs;
    private final Location[] emeraldSpawnerLocs;
    private final Location startLoc;
    private final Location endLoc;

    public BPMap(BPTeamTemplate[] teams, Location[] diamondSpawnerLocs, Location[] emeraldSpawnerLocs, Location startLoc, Location endLoc) {
        this.teams = teams;
        this.diamondSpawnerLocs = diamondSpawnerLocs;
        this.emeraldSpawnerLocs = emeraldSpawnerLocs;
        this.startLoc = startLoc;
        this.endLoc = endLoc;
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

    public void copyMap() {
        // TODO: Finish
        CuboidRegion copyRegion = new CuboidRegion((World) startLoc.getWorld(), Converters.location2BlockVector3(startLoc), Converters.location2BlockVector3(endLoc));

    }
}
