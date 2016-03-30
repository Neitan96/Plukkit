package br.com.nathanalmeida.plukkit.gui.manager;

import br.com.nathanalmeida.plukkit.gui.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 15:21
 */
public interface GUIManager{

    JavaPlugin getPlugin();

    GUIBinder getBinder();

    GUIPage getPage(String name);

    void openToPlayer(Player player);

    void processAction(Player player, String command, String argument, InventoryClickEvent event);

}
