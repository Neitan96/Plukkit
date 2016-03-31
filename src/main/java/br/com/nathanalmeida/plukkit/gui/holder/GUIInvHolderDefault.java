package br.com.nathanalmeida.plukkit.gui.holder;

import br.com.nathanalmeida.plukkit.gui.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 20:05
 */
public class GUIInvHolderDefault implements GUIInventoryHolder{

    protected final Player player;
    protected final GUIPage page;
    protected Inventory inventory = null;

    protected final HashMap<Integer, GUIButton> buttons = new HashMap<>();


    public GUIInvHolderDefault(Player player, GUIPage page){
        this.player = player;
        this.page = page;
    }


    @Override
    public Player getPlayer(){
        return player;
    }

    @Override
    public GUIPage getPage(){
        return page;
    }

    @Override
    public void setButton(int slot, GUIButton button){
        buttons.put(slot, button);
    }

    @Override
    public GUIButton getButton(int slot){
        return buttons.get(slot);
    }

    @Override
    public Inventory getInventory(){
        return inventory;
    }

    public void setInventory(Inventory inventory){
        if(this.inventory == null)
            this.inventory = inventory;
    }

}
