package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.gui.core.holder.InventoryButtonClick;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 15:22
 */
public interface GUIButton{

    ItemStack makeDisplay(Player player, GUIManager manager, GUIPage page);

    void onClick(InventoryButtonClick click);

}
