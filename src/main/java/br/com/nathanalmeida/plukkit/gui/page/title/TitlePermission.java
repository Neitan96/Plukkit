package br.com.nathanalmeida.plukkit.gui.page.title;

import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 01:27
 */
public class TitlePermission implements GUITitle{

    protected final String permission;
    protected final GUITitle title;

    public TitlePermission(String permission, GUITitle title){
        this.permission = permission;
        this.title = title;
    }

    @Override
    public String makeTitle(Player player){
        if(player.hasPermission(permission))
            return title.makeTitle(player);
        return null;
    }

}
