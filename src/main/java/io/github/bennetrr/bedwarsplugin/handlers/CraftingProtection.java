package io.github.bennetrr.bedwarsplugin.handlers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingProtection implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onCrafting(PrepareItemCraftEvent event) {
        if (event.getInventory().getResult() != null) {
            event.getInventory().setResult(new ItemStack(Material.AIR));
            event.getViewers().forEach(player -> player.sendMessage(Component.text("You're not allowed to craft any items!").color(NamedTextColor.RED)));
        }
    }
}
