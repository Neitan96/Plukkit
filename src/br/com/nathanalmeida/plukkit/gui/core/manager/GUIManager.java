package br.com.nathanalmeida.plukkit.gui.core.manager;

import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 09/09/2019 00:47
 */
public interface GUIManager{

	JavaPlugin getPluginOwner();

	List<GUIPage> getPages();

	GUIInventoryHolder openToPlayer(Player player);

}
