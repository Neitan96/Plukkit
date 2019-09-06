package br.com.nathanalmeida.plukkit.gui.core.action;

import br.com.nathanalmeida.plukkit.gui.core.events.GUIInvButtonClickEvent;
import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;
import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 20:28
 */
public interface GUIActionButton extends PlukConfigLoader{

	String actionName();

	String[] getArguments();

}
