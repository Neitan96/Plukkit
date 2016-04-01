package br.com.nathanalmeida.plukkit.gui.core.display;

import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 22:07
 */
public class ItemStackDisplay implements GUIDisplay{

    protected final ItemStack itemStack;
    protected final GUIBinder binder;


    public ItemStackDisplay(ItemStack itemStack){
        this(itemStack, null);
    }

    public ItemStackDisplay(ItemStack itemStack, GUIBinder binder){
        this.itemStack = itemStack;
        this.binder = binder;
    }


    @Override
    public ItemStack renderDisplay(Player player, GUIButton button){
        ItemStack itemStack = this.itemStack.clone();
        ItemMeta itemMeta = itemStack.getItemMeta();

        if(binder != null && itemMeta != null){

            String displayName = itemMeta.getDisplayName();
            if(displayName != null){
                displayName = binder.bindValues(displayName, player, button.getPage(), button);
                itemMeta.setDisplayName(displayName);
            }

            List<String> lore = itemMeta.getLore();
            if(lore != null){
                lore = binder.bindValues(lore, player, button.getPage(), button);
                itemMeta.setLore(lore);
            }

            itemStack.setItemMeta(itemMeta);

        }

        return itemStack;
    }
}
