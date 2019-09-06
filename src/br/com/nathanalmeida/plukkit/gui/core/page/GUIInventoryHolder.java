package br.com.nathanalmeida.plukkit.gui.core.page;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Set;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 20:33
 */
public interface GUIInventoryHolder{

	GUIManager getManager();

	GUIPage getPage();

	GUIPageRenderer getPageRenderer();

	Player getPlayer();

}
