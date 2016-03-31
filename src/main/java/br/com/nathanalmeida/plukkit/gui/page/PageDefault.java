package br.com.nathanalmeida.plukkit.gui.page;

import br.com.nathanalmeida.plukkit.gui.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.holder.GUIInvHolderDefault;
import br.com.nathanalmeida.plukkit.gui.holder.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.gui.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.page.title.GUITitle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 00:47
 */
public class PageDefault implements GUIPage{

    protected final GUIManager manager;
    protected final String name;
    protected final GUITitle title;
    protected final int size;
    protected final String permission;
    protected final ItemStack displayDefault;

    protected final List<GUIButton> buttons = new ArrayList<>();

    public PageDefault(GUIManager manager, String name, GUITitle title,
                       int size, String permission, ItemStack displayDefault){
        this.manager = manager;
        this.name = name;
        this.title = title;
        this.size = size;
        this.permission = permission;
        this.displayDefault = displayDefault;
    }

    public PageDefault(GUIManager manager, String name, GUITitle title,
                       int size, String permission, ItemStack displayDefault, GUIButton... buttons){
        this(manager, name, title, size, permission, displayDefault);
        Collections.addAll(this.buttons, buttons);
    }

    @Override
    public GUIManager getManager(){
        return manager;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void addButton(GUIButton button){
        buttons.add(button);
    }

    @Override
    public void removeButton(GUIButton button){
        buttons.remove(button);
    }

    @Override
    public void removeButton(int slot){
        for(int i = buttons.size() - 1; i >= 0; i--)
            if(buttons.get(i).getSlot() == slot)
                buttons.remove(i);
    }

    @Override
    public Inventory renderInventory(Player player){
        if(!player.hasPermission(permission)) return null;

        GUIInventoryHolder owner = new GUIInvHolderDefault(player, this);
        Inventory inventory = Bukkit.createInventory(owner, size, title.makeTitle(player));

        for(GUIButton button : buttons){
            ItemStack display = button.makeDisplay(player);
            if(display != null){
                inventory.setItem(button.getSlot(), display);
                owner.setButton(button.getSlot(), button);
            }
        }

        if(displayDefault != null){
            for(int i = 0; i < inventory.getMaxStackSize(); i++){
                ItemStack item = inventory.getItem(i);
                if(item == null || item.getType() == Material.AIR)
                    inventory.setItem(i, displayDefault);
            }
        }

        return inventory;
    }

    @Override
    public void openToPlayer(Player player){
        Inventory inventory = renderInventory(player);
        if(inventory != null){
            player.closeInventory();
            player.openInventory(inventory);
        }
    }

}
