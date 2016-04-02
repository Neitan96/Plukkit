package br.com.nathanalmeida.plukkit.gui.core.page.title;

import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 01:25
 */
public class TitleString implements GUITitle{

    protected final String title;
    protected final GUIBinder binder;

    public TitleString(String title, GUIBinder binder){
        this.title = title;
        this.binder = binder;
    }

    public TitleString(String title){
        this(title, null);
    }

    @Override
    public String makeTitle(Player player){
        if(binder != null)
            return binder.bindValues(title, player);
        return title;
    }

}
