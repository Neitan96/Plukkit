package br.com.nathanalmeida.plukkit.gui.core.page;

import br.com.nathanalmeida.plukkit.features.PlukPermissible;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 09/09/2019 00:47
 */
public interface GUIPage extends PlukPermissible{

	String getName();

	String makeTitle(Player player);

	int getSize();

	List<GUIButton> getButtons();

	GUIInventoryHolder renderPage(Player player);

	GUIInventoryHolder openToPlayer(Player player);

}
