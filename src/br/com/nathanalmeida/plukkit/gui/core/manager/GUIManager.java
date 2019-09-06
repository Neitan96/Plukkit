package br.com.nathanalmeida.plukkit.gui.core.manager;

import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 20:25
 */
public interface GUIManager extends Listener{

	JavaPlugin getPlugin();

	List<GUIPage> getPages();

	List<GUIBinder> getBinders();

	boolean setHome(GUIPage page);

	GUIPage getPage(String name);

	GUIPage getHomePage();

	default Inventory openToPlayer(Player player){
		GUIPage homePage = getHomePage();
		if(homePage != null) return homePage.openToPlayer(player);
		return null;
	}

	void onClickEvent(InventoryClickEvent event);

}
