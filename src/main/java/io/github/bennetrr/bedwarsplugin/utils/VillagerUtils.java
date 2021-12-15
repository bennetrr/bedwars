package io.github.bennetrr.bedwarsplugin.utils;

import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class VillagerUtils {
    public static void setDump(Villager villager) {
        villager.setAI(false);
        villager.setGravity(false);
        villager.setInvulnerable(true);
    }

    public static void clearTrades(Villager villager) {
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
    }

    public static void addTrade(Villager villager, ItemStack buyItem1, @Nullable ItemStack buyItem2, ItemStack sellItem) {
        List<MerchantRecipe> oldRecipes = villager.getRecipes();

        MerchantRecipe newRecipe = new MerchantRecipe(sellItem, 999999999);
        newRecipe.addIngredient(buyItem1);
        if(buyItem2 != null) newRecipe.addIngredient(buyItem2);

        List<MerchantRecipe> newRecipes = new ArrayList<>(oldRecipes);
        newRecipes.add(newRecipe);
        villager.setRecipes(newRecipes);
    }

    public static void addTrade(Villager villager, ItemStack buyItem1, ItemStack sellItem) {
        addTrade(villager, buyItem1, null, sellItem);
    }

    public static void addTrades(Villager villager, List<ItemStack[]> itemList) {
        List<MerchantRecipe> oldRecipes = villager.getRecipes();
        List<MerchantRecipe> newRecipes = new ArrayList<>(oldRecipes);

        for (ItemStack[] itemStacks : itemList) {
            ItemStack buyItem1, buyItem2, sellItem;
            if(itemStacks.length == 2) {
                buyItem1 = itemStacks[0];
                buyItem2 = null;
                sellItem = itemStacks[1];
            } else if(itemStacks.length == 3) {
                buyItem1 = itemStacks[0];
                buyItem2 = itemStacks[1];
                sellItem = itemStacks[2];
            } else throw new IllegalArgumentException("The list needs to have 2 or 3 elements");

            MerchantRecipe newRecipe = new MerchantRecipe(sellItem, 999999999);
            newRecipe.addIngredient(buyItem1);
            if(buyItem2 != null) newRecipe.addIngredient(buyItem2);
            newRecipes.add(newRecipe);
        }
        villager.setRecipes(newRecipes);
    }
}