package br.com.nathanalmeida.plukkit.gui.action;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 30/03/2016 17:07
 */
public class ActionCommandList implements GUIActionCommand{

    protected final GUIActionCommand[] actions;

    public ActionCommandList(GUIActionCommand[] actions){
        this.actions = actions;
    }

    @Override
    public void executeAction(Player player, InventoryClickEvent event){
        for(GUIActionCommand action : actions){
            action.executeAction(player, event);
        }
    }

}
