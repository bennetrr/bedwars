package io.github.bennetrr.bedwarsplugin;

import org.bukkit.Location;
import org.bukkit.Material;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.world.block.BlockState;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.regions.Region;

import io.github.bennetrr.bedwarsplugin.utils.Converters;

public class WorldEditStuff {
    public static void clearMap(Location mapPastePoint, org.bukkit.World w) {
        World world = BukkitAdapter.adapt(w);
        // This EditSession will be closed after the setBlocks command is finished
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(world)) {
            // Prepare the locations
            Location firstLoc = mapPastePoint.clone();
            firstLoc.setY(0);
            Location secondLoc = mapPastePoint.clone();
            secondLoc.add(160, 0, 160);
            secondLoc.setY(256);

            // Select the region
            Region selection = new CuboidRegion(world, Converters.location2BlockVector3(firstLoc), Converters.location2BlockVector3(secondLoc));

            // Create a BlockState with air
            BlockState air = BukkitAdapter.adapt(Material.AIR.createBlockData());

            // SetBlocks
            editSession.setBlocks(selection, air);
        }
    }
}
