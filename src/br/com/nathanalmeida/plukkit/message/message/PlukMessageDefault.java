package br.com.nathanalmeida.plukkit.message.message;

import br.com.nathanalmeida.plukkit.message.binder.MessageBinder;
import br.com.nathanalmeida.plukkit.message.binder.MessageBinderDefault;
import br.com.nathanalmeida.plukkit.message.tag.TagManager;
import br.com.nathanalmeida.plukkit.message.tag.TagManagerDefault;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 11/02/2016 15:08
 */
public class PlukMessageDefault implements PlukMessage{

    protected final String[] message;
    protected final TagManager tags;
    protected MessageBinder binder;


    public PlukMessageDefault(String[] message, MessageBinder binder, TagManager tags){
        this.tags = tags == null ? new TagManagerDefault(null) : tags;
        this.message = message == null ? new String[0] : message.clone();
        this.binder = binder;
    }

    public PlukMessageDefault(String[] message, TagManager tags){
        this(message, new MessageBinderDefault(), tags);
    }

    public PlukMessageDefault(String[] message){
        this(message, null);
    }


    @Override
    public String[] getMessages(){
        return message.clone();
    }

    @Override
    public String[] getMessagesPrepared(boolean toConsole, boolean error){
        String[] message = this.message.clone();
        String tag = tags.getTag(toConsole, error);
        for(int i = 0; i < message.length; i++){
            if(binder == null)
                message[i] = tag.concat(message[i]);
            else
                message[i] = tag.concat(binder.bindDefaults(message[i]));
        }
        return message;
    }

    @Override
    public PlukMessage bind(String... binds){
        if(binder == null)
            binder = new MessageBinderDefault();
        String[] newMessage = binder.bindValues(message.clone(), binds);
        return new PlukMessageDefault(newMessage, binder, tags);
    }

    @Override
    public PlukMessage cloneMessage(){
        return new PlukMessageDefault(message.clone(), binder, tags);
    }

    @Override
    public int compareTo(PlukMessage o){
        String myMessage = message[0];
        String yourMessage = o != null ? o.getMessages()[0] : null;

        if(myMessage != null && !myMessage.isEmpty()){
            if(yourMessage != null && !yourMessage.isEmpty()){
                return myMessage.compareTo(yourMessage);
            }else{
                return -1;
            }
        }

        return 1;
    }

}
