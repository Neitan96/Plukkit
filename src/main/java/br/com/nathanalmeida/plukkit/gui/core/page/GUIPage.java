package br.com.nathanalmeida.plukkit.gui.core.page;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 15:22
 */
public interface GUIPage{

    String getName();


    void addButton(int slot, GUIButton button);

    void removeButton(GUIButton button);

    void removeButton(int slot);


    Inventory renderInventory(Player player, GUIManager manager);

    void openToPlayer(Player player, GUIManager manager);

}
