package br.com.nathanalmeida.plukkit.gui.core.display;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 20:12
 */
public interface GUIDisplay{

    ItemStack renderDisplay(Player player, GUIManager manager, GUIPage page, GUIButton button);

}
