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
    protected final GUIDisplay displayDefault;

    public DisplaysPermissions(GUIDisplay displayDefault, DisplayPermission... displays){
        this.displayDefault = displayDefault;
        this.displays = displays;
    }

    public DisplaysPermissions(DisplayPermission... displays){
        this(null, displays);
    }

    @Override
    public ItemStack renderDisplay(Player player, GUIManager manager, GUIPage page, GUIButton button){
        for(DisplayPermission display : displays){
            ItemStack itemStack = display.renderDisplay(player, manager, page, button);
            if(itemStack != null) return itemStack;
        }

        if(displayDefault != null)
            return displayDefault.renderDisplay(player, manager, page, button);
        else
            return null;
    }

}
