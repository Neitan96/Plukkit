package br.com.nathanalmeida.plukkit.gui.core.display;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 30/03/2016 13:54
 */
public class DisplayPermission implements GUIDisplay{

    protected final GUIDisplay display;
    protected final String[] permissions;

    public DisplayPermission(GUIDisplay display, String... permissions){
        this.display = display;
        this.permissions = permissions;
    }

    public boolean hasPermission(Player player){
        if(permissions == null || permissions.length == 0)
            return true;

        for(String permission : permissions){
            if(player.hasPermission(permission))
                return true;
        }

        return false;
    }

    @Override
    public ItemStack renderDisplay(Player player, GUIButton button){
        if(hasPermission(player))
            return display.renderDisplay(player, button);
        return null;
    }
}
