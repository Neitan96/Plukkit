package br.com.nathanalmeida.plukkit.gui.holder;

import br.com.nathanalmeida.plukkit.gui.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 17:05
 */
public interface GUIInventoryHolder extends InventoryHolder{

    Player getPlayer();

    GUIPage getPage();

}
