package io.github.bennetrr.bedwarsplugin.handlers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;

public class BlockProtection implements Listener {
    private final ArrayList<Material> allowedBlocks;
    private final ArrayList<Material> onlyBreakBlocks;
    private final ArrayList<Material> onlyPlaceBlocks;

    public BlockProtection() {
        allowedBlocks = new ArrayList<>();
        allowedBlocks.add(Material.CYAN_WOOL);
        allowedBlocks.add(Material.ORANGE_WOOL);
        allowedBlocks.add(Material.GREEN_WOOL);
        allowedBlocks.add(Material.RED_WOOL);
        allowedBlocks.add(Material.GRAY_WOOL);
        allowedBlocks.add(Material.END_STONE);
        allowedBlocks.add(Material.OAK_PLANKS);
        allowedBlocks.add(Material.CYAN_STAINED_GLASS);
        allowedBlocks.add(Material.CRYING_OBSIDIAN);
        allowedBlocks.add(Material.LADDER);
        allowedBlocks.add(Material.WATER);
        allowedBlocks.add(Material.LAVA);

        onlyBreakBlocks = new ArrayList<>();
        onlyBreakBlocks.addAll(Tag.BEDS.getValues());
        onlyBreakBlocks.add(Material.TALL_GRASS);

        onlyPlaceBlocks = new ArrayList<>();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent event) {
        // Disallowed Blocks
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            if (!allowedBlocks.contains(event.getBlock().getType()) && !onlyBreakBlocks.contains(event.getBlock().getType())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(Component.text("You're not allowed to break this block!").color(NamedTextColor.RED));
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        // TNT
        if (event.getBlock().getType().equals(Material.TNT)) {
            event.getPlayer().getWorld().spawnEntity(event.getBlock().getLocation().add(0.5, 0, 0.5), EntityType.PRIMED_TNT);
            event.setCancelled(true);
            return;
        }

        // Disallowed blocks
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            if (!allowedBlocks.contains(event.getBlock().getType()) && !onlyPlaceBlocks.contains(event.getBlock().getType())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(Component.text("You're not allowed to place this block!").color(NamedTextColor.RED));
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onTNTExplosion(EntityExplodeEvent event) {
        if (event.getEntity().getType().equals(EntityType.PRIMED_TNT))
            if (event.blockList().size() > 0) {
                event.blockList().removeIf(b -> (!allowedBlocks.contains(b.getType()) && !onlyBreakBlocks.contains(b.getType())));
            }
    }
}
