package br.com.nathanalmeida.plukkit.gui.core.page;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Map;
import java.util.Set;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 21:22
 */
public interface GUIPageRenderer{

	String getTitle();

	void setTitle(String title);

	Set<Integer> getSlots();

	GUIButton getButton(int slot);

	void setButton(int slot);

	void updateGUI();

}
