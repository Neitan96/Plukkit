package br.com.nathanalmeida.plukkit.gui.button;

import br.com.nathanalmeida.plukkit.gui.action.GUIActionCommand;
import br.com.nathanalmeida.plukkit.gui.button.display.GUIDisplay;
import br.com.nathanalmeida.plukkit.gui.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 00:22
 */
public class ButtonDefault implements GUIButton{

    protected final GUIPage page;
    protected final int slot;
    protected final GUIDisplay display;
    protected final boolean closeOnClick;
    protected final GUIActionCommand actionCommand;
    protected final String permission;


    public ButtonDefault(GUIPage page, int slot, GUIDisplay display, boolean closeOnClick,
                         GUIActionCommand actionCommand, String permission){
        this.page = page;
        this.slot = slot;
        this.display = display;
        this.closeOnClick = closeOnClick;
        this.actionCommand = actionCommand;
        this.permission = permission;
    }


    @Override
    public GUIPage getPage(){
        return page;
    }

    @Override
    public int getSlot(){
        return slot;
    }

    @Override
    public ItemStack makeDisplay(Player player){
        return display.renderDisplay(player, this);
    }

    @Override
    public void onClick(Player player, InventoryClickEvent event){
        if(player.hasPermission(permission)){
            if(closeOnClick) player.closeInventory();
            actionCommand.executeAction(player, event);
        }
    }

}