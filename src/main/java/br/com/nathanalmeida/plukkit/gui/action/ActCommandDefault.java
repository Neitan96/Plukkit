package br.com.nathanalmeida.plukkit.gui.action;

import br.com.nathanalmeida.plukkit.gui.manager.GUIManager;
import br.com.nathanalmeida.plukkit.helpers.HelpArray;
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
    protected final String argument;
    protected final String permission;

    public ActCommandDefault(GUIManager manager, String command, String argument, String permission){
        this.manager = manager;
        this.command = command;
        this.argument = argument;
        this.permission = permission;
    }

    public ActCommandDefault(GUIManager manager, String action, String permission){
        String[] explode = explode(action);
        this.command = explode[0];
        this.argument = explode[1];
        this.manager = manager;
        this.permission = permission;
    }


    private static String[] explode(String action){
        if(action != null && !action.isEmpty()){

            String[] split = action.split(":");
            return new String[]{split[0], HelpArray.joinString(split, 1, ":")};

        }else{
            return new String[]{null, null};
        }
    }

    @Override
    public void executeAction(Player player, InventoryClickEvent event){
        if(player.hasPermission(permission))
            manager.processAction(player, command, argument, event);
    }
}
