package io.github.bennetrr.bedwarsplugin.utils;

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
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class WorldEditStuff {
    public static BlockVector3 location2BlockVector3(Location loc) {
        return BukkitAdapter.adapt(loc).toVector().toBlockPoint();
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

    public static void copyMap(Location startLoc, Location endLoc, Location pasteLoc) {
        Bukkit.getLogger().info("[Bedwars / WorldEditStuff] StartLoc: " + startLoc + "    EndLoc: " + endLoc + "    PasteLoc: " + pasteLoc);
        World world = BukkitAdapter.adapt(startLoc.getWorld());

        Bukkit.getLogger().info("[Bedwars / WorldEditStuff] StartLoc: " + location2BlockVector3(startLoc) + "    EndLoc: " + location2BlockVector3(endLoc) + "    PasteLoc: " + location2BlockVector3(pasteLoc));

        // Select the region to copy
        CuboidRegion copyRegion = new CuboidRegion(world, location2BlockVector3(startLoc), location2BlockVector3(endLoc));
        BlockArrayClipboard clipboard = new BlockArrayClipboard(copyRegion);


        // This EditSessions will be closed after the copy and paste command is finished
        // Copy
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(world)) {
            ForwardExtentCopy copyOperation = new ForwardExtentCopy(editSession, copyRegion, clipboard, copyRegion.getMinimumPoint());
            Operations.complete(copyOperation);
        }

        // Paste
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(world)) {
            Operation pasteOperation = new ClipboardHolder(clipboard).createPaste(editSession).to(location2BlockVector3(pasteLoc)).build();
            Bukkit.getLogger().info(("[Bedwars / WorldEditStuff] " + ((ForwardExtentCopy) pasteOperation).toString()));
            Operations.complete(pasteOperation);
        }
    }
}
