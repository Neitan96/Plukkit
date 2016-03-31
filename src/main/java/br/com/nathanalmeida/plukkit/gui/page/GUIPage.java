package br.com.nathanalmeida.plukkit.gui.page;

import br.com.nathanalmeida.plukkit.gui.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.manager.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 15:22
 */
public interface GUIPage{

    GUIManager getManager();

    String getName();


    void addButton(GUIButton button);

    void removeButton(GUIButton button);

    void removeButton(int slot);


    Inventory renderInventory(Player player);

    void openToPlayer(Player player);

}
