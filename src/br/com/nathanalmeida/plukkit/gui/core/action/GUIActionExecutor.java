package br.com.nathanalmeida.plukkit.gui.core.action;

import br.com.nathanalmeida.plukkit.gui.core.events.GUIInvButtonClickEvent;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 15:27
 */
public interface GUIActionExecutor{

	String getName();

	void execute(GUIInvButtonClickEvent buttonClick, String[] arguments);

}
