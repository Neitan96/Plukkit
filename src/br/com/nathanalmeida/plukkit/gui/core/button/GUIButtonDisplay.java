package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.gui.core.page.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 21:05
 */
public interface GUIButtonDisplay{

	ItemStack makeButtonDisplay(Player player, GUIInventoryHolder holder);

}
