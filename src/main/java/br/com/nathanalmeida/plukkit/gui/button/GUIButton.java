package br.com.nathanalmeida.plukkit.gui.button;

import br.com.nathanalmeida.plukkit.gui.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 15:22
 */
public interface GUIButton{

    GUIPage getPage();

    int getSlot();

    ItemStack makeDisplay(Player player);

    void onClick(Player player, InventoryClickEvent event);

}
