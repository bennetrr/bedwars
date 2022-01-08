package io.github.bennetrr.bedwarsplugin.handlers;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Explosives implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onFireballShoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack itemStack = inventory.getItemInMainHand();

        if (itemStack.getType() == Material.FIRE_CHARGE) {
            player.launchProjectile(Fireball.class);
            if (itemStack.getAmount() <= 0) inventory.setItemInMainHand(null);
            else {
                itemStack.setAmount(itemStack.getAmount() - 1);
                inventory.setItemInMainHand(itemStack);
            }

        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onTNTPlaced(BlockPlaceEvent event) {
        if (event.getBlock().getType().equals(Material.TNT)) {
            Player player = event.getPlayer();
            player.getWorld().spawnEntity(event.getBlock().getLocation().add(0.5, 0, 0.5), EntityType.PRIMED_TNT);

            PlayerInventory inventory = player.getInventory();
            ItemStack itemStack = inventory.getItemInMainHand();

            if (itemStack.getType() == Material.TNT) {
                if (itemStack.getAmount() <= 0) inventory.setItemInMainHand(null);
                else {
                    itemStack.setAmount(itemStack.getAmount() - 1);
                    inventory.setItemInMainHand(itemStack);
                }
            }
            event.setCancelled(true);
        }
    }
}
