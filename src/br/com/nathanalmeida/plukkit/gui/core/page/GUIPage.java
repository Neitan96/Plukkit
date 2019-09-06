package br.com.nathanalmeida.plukkit.gui.core.page;

import br.com.nathanalmeida.plukkit.configurations.features.PlukPermission;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 20:26
 */
public interface GUIPage{

	String getName();

	Map<PlukPermission, String> getTitles();

	int getSize();

	void setSize(int size);

	PlukPermission getPermission();

	List<GUIButton> getButtons();

	Inventory renderPage(Player player);

	Inventory openToPlayer(Player player);

}
