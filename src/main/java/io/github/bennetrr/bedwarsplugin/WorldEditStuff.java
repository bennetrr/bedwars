package io.github.bennetrr.bedwarsplugin;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.BlockArrayClipboard;
import com.sk89q.worldedit.function.operation.ForwardExtentCopy;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.world.block.BlockState;
import org.bukkit.Location;
import org.bukkit.Material;

public class WorldEditStuff {
    public static BlockVector3 location2BlockVector3(Location loc) {
        return BlockVector3.at(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
    }


    public static void clearMap(Location mapPasteLoc) {
        World world = BukkitAdapter.adapt(mapPasteLoc.getWorld());

        // Prepare the locations
        Location firstLoc = mapPasteLoc.clone();
        firstLoc.setY(0);
        Location secondLoc = mapPasteLoc.clone();
        secondLoc.add(160, 0, 160);
        secondLoc.setY(256);

        // Select the region
        Region selection = new CuboidRegion(world, location2BlockVector3(firstLoc), location2BlockVector3(secondLoc));

        // Create a BlockState with air
        BlockState air = BukkitAdapter.adapt(Material.AIR.createBlockData());

        // This EditSession will be closed after the setBlocks command is finished
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(world)) {
            // Set the blocks
            editSession.setBlocks(selection, air);
        }
    }

    public static void copyMap(Location mapStartLoc, Location mapEndLoc, Location mapPasteLoc) {
        World world = BukkitAdapter.adapt(mapStartLoc.getWorld());

        // Select the region to copy
        CuboidRegion copyRegion = new CuboidRegion(world, location2BlockVector3(mapStartLoc), location2BlockVector3(mapEndLoc));
        BlockArrayClipboard clipboard = new BlockArrayClipboard(copyRegion);

        // This EditSession will be closed after the copy and paste command is finished
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(world)) {
            // Copy
            ForwardExtentCopy copyOperation = new ForwardExtentCopy(editSession, copyRegion, clipboard, copyRegion.getMinimumPoint());
            Operations.complete(copyOperation);

            // Paste
            Operation pasteOperation = new ClipboardHolder(clipboard).createPaste(editSession).to(location2BlockVector3(mapPasteLoc)).build();
            Operations.complete(pasteOperation);
        }
    }
}
