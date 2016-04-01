package br.com.nathanalmeida.plukkit.gui.core.action;

import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 30/03/2016 17:01
 */
public class ActCommandDefault implements GUIActionCommand{

    protected final GUIManager manager;
    protected final String command;
    protected final String[] arguments;
    protected final String permission;

    public ActCommandDefault(GUIManager manager, String command, String[] arguments, String permission){
        this.manager = manager;
        this.command = command;
        this.arguments = arguments;
        this.permission = permission;
    }

    @Override
    public void executeAction(Player player, InventoryClickEvent event){
        if(permission == null || player.hasPermission(permission))
            manager.processAction(player, command, arguments, event);
    }

}
