package br.com.nathanalmeida.plukkit.gui.action;

import br.com.nathanalmeida.plukkit.gui.button.GUIButton;
import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 15:14
 */
public interface GUIActionProcessor{

    void process(Player player, String argument, GUIButton button);

}
