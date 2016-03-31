package br.com.nathanalmeida.plukkit.gui.action;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 30/03/2016 17:07
 */
public class ActCommandList implements GUIActionCommand{

    protected final GUIActionCommand[] actions;

    public ActCommandList(GUIActionCommand... actions){
        this.actions = actions;
    }

    @Override
    public void executeAction(Player player, InventoryClickEvent event){
        for(GUIActionCommand action : actions){
            action.executeAction(player, event);
        }
    }

}
