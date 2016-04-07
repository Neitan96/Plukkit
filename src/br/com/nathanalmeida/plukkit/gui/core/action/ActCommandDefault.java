package br.com.nathanalmeida.plukkit.gui.core.action;

import br.com.nathanalmeida.plukkit.gui.core.holder.InventoryButtonClick;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 30/03/2016 17:01
 */
public class ActCommandDefault implements GUIActionCommand{

    protected final String command;
    protected final String[] arguments;
    protected final String permission;
    protected final GUIActionCommand defAction;

    public ActCommandDefault(String command, String[] arguments,
                             String permission, GUIActionCommand defAction){
        this.command = command;
        this.arguments = arguments;
        this.permission = permission;
        this.defAction = defAction;
    }

    public ActCommandDefault(String command, String[] arguments,
                             String permission){
        this(command, arguments, permission, null);
    }

    @Override
    public void executeAction(InventoryButtonClick click){
        if(permission == null || click.getPlayer().hasPermission(permission))
            click.getManager().processAction(click.getPlayer(), command, arguments, click.getEvent());
        else if(defAction !=  null)
            defAction.executeAction(click);
    }

}
