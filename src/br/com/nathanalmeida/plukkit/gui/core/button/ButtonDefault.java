package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionCommand;
import br.com.nathanalmeida.plukkit.gui.core.display.GUIDisplay;
import br.com.nathanalmeida.plukkit.gui.core.holder.InventoryButtonClick;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 00:22
 */
public class ButtonDefault implements GUIButton{

    protected final GUIDisplay display;
    protected final boolean closeOnClick;
    protected final GUIActionCommand actionCommand;
    protected final String permission;


    public ButtonDefault(GUIDisplay display, boolean closeOnClick,
                         GUIActionCommand actionCommand, String permission){
        this.display = display;
        this.closeOnClick = closeOnClick;
        this.actionCommand = actionCommand;
        this.permission = permission;
    }


    @Override
    public ItemStack makeDisplay(Player player, GUIManager manager, GUIPage page){
        if(permission == null || player.hasPermission(permission))
            return display.renderDisplay(player, manager, page, this);

        return null;
    }

    @Override
    public void onClick(InventoryButtonClick click){
        if(permission == null || click.getPlayer().hasPermission(permission)){
            if(closeOnClick) click.getPlayer().closeInventory();
            if(actionCommand != null) actionCommand.executeAction(click);
        }
    }

}
