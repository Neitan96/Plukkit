package br.com.nathanalmeida.plukkit.gui.core.display;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 30/03/2016 15:32
 */
public class DisplaysPermissions implements GUIDisplay{

    protected final DisplayPermission[] displays;

    public DisplaysPermissions(DisplayPermission... displays){
        this.displays = displays;
    }

    @Override
    public ItemStack renderDisplay(Player player, GUIManager manager, GUIPage page, GUIButton button){
        for(DisplayPermission display : displays){
            ItemStack itemStack = display.renderDisplay(player, manager, page, button);
            if(itemStack != null) return itemStack;
        }
        return null;
    }

}
