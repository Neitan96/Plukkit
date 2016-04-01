package br.com.nathanalmeida.plukkit.gui.manager;

import br.com.nathanalmeida.plukkit.gui.action.GUIActionProcessor;
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


    void addBinder(GUIBinder binder);

    GUIBinder getBinder();


    void setHome(String name);

    void addPage(GUIPage page, boolean setPageHome);

    void addPage(GUIPage page);

    void removePage(String name);

    GUIPage getPage(String name);

    void openToPlayer(Player player);


    void addActionProcessor(String command, GUIActionProcessor processor);

    void removeActionProcessor(String command, GUIActionProcessor processor);

    void processAction(Player player, String command, String[] arguments, InventoryClickEvent event);

}
