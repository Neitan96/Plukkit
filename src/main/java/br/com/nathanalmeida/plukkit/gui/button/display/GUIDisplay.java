package br.com.nathanalmeida.plukkit.gui.button.display;

import br.com.nathanalmeida.plukkit.gui.button.GUIButton;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 20:12
 */
public interface GUIDisplay{

    ItemStack renderDisplay(Player player, GUIButton button);

}
