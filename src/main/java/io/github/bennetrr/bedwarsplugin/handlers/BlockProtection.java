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
    private final ArrayList<Material> fireballBreakBlocks;

    public BlockProtection() {
        allowedBlocks = new ArrayList<>();
        allowedBlocks.add(Material.ORANGE_WOOL);
        allowedBlocks.add(Material.GREEN_WOOL);
        allowedBlocks.add(Material.RED_WOOL);
        allowedBlocks.add(Material.LIGHT_GRAY_WOOL);
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
        onlyBreakBlocks.add(Material.FIRE);

        onlyPlaceBlocks = new ArrayList<>();

        fireballBreakBlocks = new ArrayList<>();
        fireballBreakBlocks.add(Material.ORANGE_WOOL);
        fireballBreakBlocks.add(Material.GREEN_WOOL);
        fireballBreakBlocks.add(Material.RED_WOOL);
        fireballBreakBlocks.add(Material.GRAY_WOOL);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent event) {
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            if (!allowedBlocks.contains(event.getBlock().getType()) && !onlyBreakBlocks.contains(event.getBlock().getType())) {
                event.getPlayer().sendMessage(Component.text("You're not allowed to break this block!").color(NamedTextColor.RED));
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            if (!allowedBlocks.contains(event.getBlock().getType()) && !onlyPlaceBlocks.contains(event.getBlock().getType())) {
                if (!event.getBlock().getType().equals(Material.TNT) && !event.getBlock().getType().equals(Material.FIRE_CHARGE))
                    event.getPlayer().sendMessage(Component.text("You're not allowed to place this block!").color(NamedTextColor.RED));
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onTNTExplosion(EntityExplodeEvent event) {
        if (event.getEntity().getType().equals(EntityType.PRIMED_TNT)) if (event.blockList().size() > 0) {
            event.blockList().removeIf(b -> (!allowedBlocks.contains(b.getType()) && !onlyBreakBlocks.contains(b.getType())));
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onFireballExplosion(EntityExplodeEvent event) {
        if (event.getEntity().getType().equals(EntityType.FIREBALL)) if (event.blockList().size() > 0) {
            event.blockList().removeIf(b -> (!fireballBreakBlocks.contains(b.getType())));
        }
    }
}
