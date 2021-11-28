package io.github.bennetrr.bedwarsplugin.utils;

import com.sk89q.worldedit.math.BlockVector3;
import org.bukkit.Location;

public class Converters {
    public static BlockVector3 location2BlockVector3(Location loc) {
        return BlockVector3.at(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
    }
}
