package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.configurations.features.PlukPermission;
import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionButton;
import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 20:27
 */
public interface GUIButton{

	String getName();

	GUIButtonDisplay getDisplay();

	void setDisplay(GUIButtonDisplay display);

	int getSlot();

	void setSlot(int slot);

	boolean closeOnClick();

	void setCloseOnClick(boolean closeOnClick);

	PlukPermission getPermission();

	List<GUIActionButton> getActions();

}
