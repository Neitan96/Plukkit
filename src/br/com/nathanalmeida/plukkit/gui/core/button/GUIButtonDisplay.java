package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 21:05
 */
public interface GUIButtonDisplay extends PlukConfigLoader{

	ItemStack makeButtonDisplay(Player player, GUIPage page, GUIManager manager);

}
