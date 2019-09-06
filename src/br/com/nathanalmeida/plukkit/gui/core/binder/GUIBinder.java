package br.com.nathanalmeida.plukkit.gui.core.binder;

import br.com.nathanalmeida.plukkit.gui.core.page.GUIInventoryHolder;
import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 17:08
 */
public interface GUIBinder{

	String binderText(String text, GUIInventoryHolder holder);

	default String[] binderText(String[] text, GUIInventoryHolder holder){
		for(int line = 0; line < text.length; line++){
			text[line] = binderText(text[line], holder);
		}
		return text;
	}

}
