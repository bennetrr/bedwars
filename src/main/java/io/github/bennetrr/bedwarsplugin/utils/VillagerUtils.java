package io.github.bennetrr.bedwarsplugin.utils;

import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VillagerUtils {
    public static void setDump(Villager villager) {
        villager.setAI(false);
        villager.setGravity(false);
        villager.setInvulnerable(true);
    }

    public static void setTrade(Villager villager, ItemStack buyItem1, @Nullable ItemStack buyItem2, ItemStack sellItem, int id) {
        MerchantRecipe recipe = new MerchantRecipe(sellItem, 999999999);
        recipe.addIngredient(buyItem1);
        if(buyItem2 != null) recipe.addIngredient(buyItem2);
        villager.setRecipe(id, recipe);
    }

    public static void setTrade(Villager villager, ItemStack buyItem1, ItemStack sellItem, int id) {
        setTrade(villager, buyItem1, null, sellItem, id);
    }

    public static void addTrade(Villager villager, ItemStack buyItem1, ItemStack buyItem2, ItemStack sellItem)
    {
        int tradeCount = villager.getRecipeCount();
        setTrade(villager, buyItem1, buyItem2, sellItem, tradeCount);
    }

    public static void addTrade(Villager villager, ItemStack buyItem1, ItemStack sellItem)
    {
        int tradeCount = villager.getRecipeCount();
        setTrade(villager, buyItem1, sellItem, tradeCount);
    }

    public static void addTradesFromList(Villager villager, List<ItemStack[]> itemList) {
        for (ItemStack[] itemStacks : itemList) {
            addTrade(villager, itemStacks[0], itemStacks[1], itemStacks[2]);
        }
    }
}