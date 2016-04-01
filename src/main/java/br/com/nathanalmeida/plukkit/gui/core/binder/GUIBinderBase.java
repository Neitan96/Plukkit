package br.com.nathanalmeida.plukkit.gui.core.binder;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 15:26
 */
public abstract class GUIBinderBase implements GUIBinder{

    @Override
    public String bindValues(String message, Player player){
        return bindValues(message, player, null);
    }

    @Override
    public String bindValues(String message, Player player, GUIPage page){
        return bindValues(message, player, page, null);
    }

    @Override
    public String[] bindValues(String[] message, Player player){
        return bindValues(message, player, null);
    }

    @Override
    public String[] bindValues(String[] message, Player player, GUIPage page){
        return bindValues(message, player, page, null);
    }

    @Override
    public String[] bindValues(String[] message, Player player, GUIPage page, GUIButton button){
        message  =  message.clone();
        for(int i = 0; i < message.length; i++)
            message[i] = bindValues(message[i], player, page, button);
        return message;
    }

    @Override
    public List<String> bindValues(List<String> message, Player player){
        return bindValues(message, player, null);
    }

    @Override
    public List<String> bindValues(List<String> message, Player player, GUIPage page){
        return bindValues(message, player, page, null);
    }

    @Override
    public List<String> bindValues(List<String> message, Player player, GUIPage page, GUIButton button){
        message = new ArrayList<>(message);
        for(int i = 0; i < message.size(); i++)
            message.set(i, bindValues(message.get(i), player, page, button));
        return message;
    }

}
