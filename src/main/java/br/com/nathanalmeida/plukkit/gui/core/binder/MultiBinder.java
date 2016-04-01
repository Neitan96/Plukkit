package br.com.nathanalmeida.plukkit.gui.core.binder;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 11:52
 */
public class MultiBinder extends GUIBinderBase{

    protected final List<GUIBinder> binders = new ArrayList<>();


    public boolean add(GUIBinder binder){
        return binders.add(binder);
    }

    public boolean remove(GUIBinder o){
        return binders.remove(o);
    }


    @Override
    public String bindValues(String message, Player player, GUIPage page, GUIButton button){
        for(GUIBinder binder : binders){
            String newMessage = binder.bindValues(message, player, page, button);
            if(newMessage != null)  message = newMessage;
        }
        return message;
    }
}
