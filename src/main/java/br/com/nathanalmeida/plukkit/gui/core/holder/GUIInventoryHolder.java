package br.com.nathanalmeida.plukkit.gui.core.holder;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 17:05
 */
public interface GUIInventoryHolder extends InventoryHolder{

    Player getPlayer();

    GUIPage getPage();

    void setButton(int slot, GUIButton button);

    GUIButton getButton(int slot);

}