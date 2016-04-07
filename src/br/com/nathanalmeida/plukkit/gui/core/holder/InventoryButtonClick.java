package br.com.nathanalmeida.plukkit.gui.core.holder;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 07/04/2016 03:26
 */
public class InventoryButtonClick{

    protected final int slot;
    protected final GUIButton button;
    protected final InventoryClickEvent event;
    protected final GUIInventoryHolder holder;

    public InventoryButtonClick(GUIInventoryHolder holder, InventoryClickEvent event){
        this.slot = event.getSlot();
        this.button = holder.getButton(slot);
        this.event = event;
        this.holder = holder;
    }

    public int getSlotClicked(){
        return slot;
    }

    public GUIButton getButtonClicked(){
        return button;
    }

    public InventoryClickEvent getEvent(){
        return event;
    }

    public Player getPlayer(){
        return holder.getPlayer();
    }

    public GUIButton getButton(int slot){
        return holder.getButton(slot);
    }

    public Inventory getInventory(){
        return holder.getInventory();
    }

    public GUIPage getPage(){
        return holder.getPage();
    }

    public GUIManager getManager(){
        return holder.getManager();
    }

}
