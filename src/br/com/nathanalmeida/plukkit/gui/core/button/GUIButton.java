package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.features.PlukPermissible;
import br.com.nathanalmeida.plukkit.gui.core.action.GUIAction;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 09/09/2019 00:48
 */
public interface GUIButton extends GUIDisplay, PlukPermissible{

	int getSlot();

	boolean closeOnClick();

	List<GUIAction> getActions();

}
