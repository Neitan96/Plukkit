package br.com.nathanalmeida.plukkit.gui.core.display;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/04/2016 23:59
 */
public class DisplayList implements GUIDisplay{

    protected final GUIDisplay[] displays;

    public DisplayList(GUIDisplay... displays){
        this.displays = displays;
    }

    @Override
    public ItemStack renderDisplay(Player player, GUIManager manager, GUIPage page, GUIButton button){
        for(GUIDisplay display : displays){
            ItemStack itemStack = display.renderDisplay(player, manager, page, button);
            if(itemStack != null)
                return itemStack;
        }
        return null;
    }

}
