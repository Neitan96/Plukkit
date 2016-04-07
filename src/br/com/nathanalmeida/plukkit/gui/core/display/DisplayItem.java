package br.com.nathanalmeida.plukkit.gui.core.display;

import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 22:07
 */
public class DisplayItem implements GUIDisplay{

    protected final ItemStack itemStack;
    protected final GUIBinder binder;
    protected final String permission;


    public DisplayItem(ItemStack itemStack, GUIBinder binder, String permission){
        this.itemStack = itemStack;
        this.binder = binder;
        this.permission = permission;
    }

    public DisplayItem(ItemStack itemStack, GUIBinder binder){
        this(itemStack, binder, null);
    }

    public DisplayItem(ItemStack itemStack, String permission){
        this(itemStack, null, permission);
    }

    public DisplayItem(ItemStack itemStack){
        this(itemStack, null, null);
    }


    @Override
    public ItemStack renderDisplay(Player player, GUIManager manager, GUIPage page, GUIButton button){
        ItemStack itemStack = this.itemStack.clone();
        ItemMeta itemMeta = itemStack.getItemMeta();

        if(binder != null && itemMeta != null){

            String displayName = itemMeta.getDisplayName();
            if(displayName != null){
                displayName = binder.bindValues(displayName, player, page, button);
                itemMeta.setDisplayName(displayName);
            }

            List<String> lore = itemMeta.getLore();
            if(lore != null){
                lore = binder.bindValues(lore, player, page, button);
                itemMeta.setLore(lore);
            }

            itemStack.setItemMeta(itemMeta);

        }

        return itemStack;
    }
}
