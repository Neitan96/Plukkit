package br.com.nathanalmeida.plukkit.gui.action;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 30/03/2016 16:55
 */
public interface GUIActionCommand{

    void executeAction(Player player, InventoryClickEvent event);

}
