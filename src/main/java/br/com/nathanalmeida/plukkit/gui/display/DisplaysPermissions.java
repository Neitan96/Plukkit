package br.com.nathanalmeida.plukkit.gui.display;

import br.com.nathanalmeida.plukkit.gui.button.GUIButton;
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
    public ItemStack renderDisplay(Player player, GUIButton button){
        for(DisplayPermission display : displays){
            ItemStack itemStack = display.renderDisplay(player, button);
            if(itemStack != null) return itemStack;
        }
        return null;
    }

}
