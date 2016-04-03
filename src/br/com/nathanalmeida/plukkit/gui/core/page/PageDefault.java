package br.com.nathanalmeida.plukkit.gui.core.page;

import br.com.nathanalmeida.plukkit.gui.core.button.ButtonSlot;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.holder.GUIInvHolderDefault;
import br.com.nathanalmeida.plukkit.gui.core.holder.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.title.GUITitle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 00:47
 */
public class PageDefault implements GUIPage{

    protected final String name;
    protected final GUITitle title;
    protected final int size;
    protected final String permission;
    protected final ItemStack displayDefault;

    protected final List<ButtonSlot> buttons = new ArrayList<>();

    public PageDefault(String name, GUITitle title,
                       int size, String permission, ItemStack displayDefault){
        this.name = name;
        this.title = title;
        this.size = size;
        this.permission = permission;
        this.displayDefault = displayDefault;
    }


    @Override
    public String getName(){
        return name;
    }

    @Override
    public void addButton(int slot, GUIButton button){
        buttons.add(new ButtonSlot(slot, button));
    }

    @Override
    public void removeButton(GUIButton button){
        for(int i = buttons.size()-1; i >= 0; i--){
            if(buttons.get(i).getButton() == button)
                buttons.remove(i);
        }
    }

    @Override
    public void removeButton(int slot){
        for(int i = buttons.size() - 1; i >= 0; i--)
            if(buttons.get(i).getSlot() == slot)
                buttons.remove(i);
    }

    @Override
    public Inventory renderInventory(Player player, GUIManager manager){
        if(permission != null && !player.hasPermission(permission)) return null;

        GUIInventoryHolder owner = new GUIInvHolderDefault(player, manager, this);
        Inventory inventory = Bukkit.createInventory(owner, size, title.makeTitle(player));

        for(ButtonSlot buttonSlot : buttons){
            GUIButton button = buttonSlot.getButton();
            ItemStack display = button.makeDisplay(player, manager, this);
            if(display != null){
                inventory.setItem(buttonSlot.getSlot(), display);
                owner.setButton(buttonSlot.getSlot(), button);
            }
        }

        if(displayDefault != null){
            for(int i = 0; i < inventory.getSize(); i++){
                ItemStack item = inventory.getItem(i);
                if(item == null || item.getType() == Material.AIR)
                    inventory.setItem(i, displayDefault);
            }
        }

        return inventory;
    }

    @Override
    public void openToPlayer(Player player, GUIManager manager){
        Inventory inventory = renderInventory(player, manager);
        if(inventory != null){
            player.closeInventory();
            player.openInventory(inventory);
        }
    }

}
