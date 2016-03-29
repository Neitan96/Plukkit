package br.com.nathanalmeida.plukkit.gui.action;

import br.com.nathanalmeida.plukkit.helpers.HelpArray;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 16:23
 */
public class GUIActionDTO{

    protected final String command;
    protected final String argument;
    protected final String permission;
    protected final boolean ignoreOther;

    public GUIActionDTO(String command, String argument, String permission, boolean ignoreOther){
        this.command = command;
        this.argument = argument;
        this.permission = permission;
        this.ignoreOther = ignoreOther;
    }

    public GUIActionDTO(String action, String permission, boolean ignoreOther){
        String[] explode = explode(action);
        this.command = explode[0];
        this.argument = explode[1];
        this.permission = permission;
        this.ignoreOther = ignoreOther;
    }

    private static String[] explode(String action){
        if(action != null && !action.isEmpty()){

            String[] split = action.split(":");
            return new String[]{split[0], HelpArray.joinString(split, 1, ":")};

        }else {
            return new String[]{null, null};
        }
    }

    public String getCommand(){
        return command;
    }

    public String getArgument(){
        return argument;
    }

    public String getPermission(){
        return permission;
    }

    public boolean isIgnoreOther(){
        return ignoreOther;
    }

}
