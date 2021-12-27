package io.github.bennetrr.bedwarsplugin.handlers;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class FireballShooter implements Listener {
    // TODO: Test
    @EventHandler(priority= EventPriority.HIGH)
    public void onFireballShoot(PlayerInteractEvent event){
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack itemStack = inventory.getItemInMainHand();

        if(itemStack.getType() == Material.FIRE_CHARGE){
            player.launchProjectile(Fireball.class);
            if(itemStack.getAmount() <= 0) inventory.setItemInMainHand(null);
            else {
                itemStack.setAmount(itemStack.getAmount() - 1);
                inventory.setItemInMainHand(itemStack);
            }

        }
    }
}
