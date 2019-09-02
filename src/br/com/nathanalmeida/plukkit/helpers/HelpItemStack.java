package br.com.nathanalmeida.plukkit.helpers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/04/2016 21:42
 */
public final class HelpItemStack{

    public static ItemStack make(Material material){
        return new ItemStack(material);
    }

    public static ItemStack make(Material material, int amount){
        return new ItemStack(material, amount);
    }

    public static ItemStack make(Material material, int amount, String title){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null){
            itemMeta.setDisplayName(title);
            itemStack.setItemMeta(itemMeta);
        }

        return itemStack;
    }

    public static ItemStack make(Material material, int amount, String title, String... lore){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null){
            itemMeta.setDisplayName(title);
            itemMeta.setLore(Arrays.asList(lore));
            itemStack.setItemMeta(itemMeta);
        }

        return itemStack;
    }

}
