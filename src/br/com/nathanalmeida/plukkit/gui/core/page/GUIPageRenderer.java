package br.com.nathanalmeida.plukkit.gui.core.page;

import br.com.nathanalmeida.plukkit.gui.core.manager.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 09/09/2019 01:04
 */
public interface GUIPageRenderer{

	String getTitle();

	List<GUIButton> getButtons();

	GUIInventoryHolder getHolder();


	default GUIButton getButton(int slot){
		for(GUIButton button : getButtons())
			if(button.getSlot() == slot) return button;
		return null;
	}

	default Player getPlayer(){
		return getHolder().getPlayer();
	}

}
