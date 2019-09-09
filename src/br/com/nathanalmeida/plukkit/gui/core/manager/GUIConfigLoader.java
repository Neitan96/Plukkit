package br.com.nathanalmeida.plukkit.gui.core.manager;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButtonDisplay;
import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 08/09/2019 21:29
 */
public interface GUIConfigLoader extends PlukConfigLoader{

	boolean loadFromConfig(ConfigurationSection section, Map<String, GUIButtonDisplay> displayGlobal, List<GUIButton> buttonsGlobal);

	@Override
	default void loadFromConfig(ConfigurationSection section){
		loadFromConfig(section, null, null);
	}

}
