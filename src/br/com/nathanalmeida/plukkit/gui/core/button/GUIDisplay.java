package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.gui.core.manager.GUIInventoryHolder;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 09/09/2019 01:15
 */
public interface GUIDisplay{

	ItemStack makeDisplay(GUIInventoryHolder holder);

}
