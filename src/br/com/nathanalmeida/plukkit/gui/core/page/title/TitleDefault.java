package br.com.nathanalmeida.plukkit.gui.core.page.title;

import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 01:25
 */
public class TitleDefault implements GUITitle{

    protected final String title;
    protected final GUIBinder binder;
    protected final String permission;

    public TitleDefault(String title, GUIBinder binder, String permission){
        this.title = title;
        this.binder = binder;
        this.permission = permission;
    }

    public TitleDefault(String title, GUIBinder binder){
        this(title, null, null);
    }

    public TitleDefault(String title){
        this(title, null);
    }

    @Override
    public String makeTitle(Player player){
        if(permission == null || player.hasPermission(permission)){
            if(binder != null)
                return binder.bindValues(title, player);
            return title;
        }
        return null;
    }

}
