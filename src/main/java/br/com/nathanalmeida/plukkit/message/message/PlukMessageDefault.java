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
    public PlukMessage bind(String... binds){
        if(binder == null)
            binder = new MessageBinderDefault();
        String[] newMessage = binder.bindValues(message.clone(), binds);
        return new PlukMessageDefault(newMessage, binder, tags);
    }


    @Override
    public void sendTo(CommandSender target){
        String tag = tags.getTag(false, false);
        for(String line : message){
            target.sendMessage(tag.concat(line));
        }
    }

    @Override
    public void sendTo(CommandSender[] targets){
        String tag = tags.getTag(false, false);
        for(String line : message){
            for(CommandSender target : targets){
                target.sendMessage(tag.concat(line));
            }
        }
    }

    @Override
    public void sendTo(Collection<CommandSender> targets){
        String tag = tags.getTag(false, false);
        for(String line : message){
            for(CommandSender target : targets){
                target.sendMessage(tag.concat(line));
            }
        }
    }

    @Override
    public void sendErrorTo(CommandSender target){
        String tag = tags.getTag(false, true);
        for(String line : message){
            target.sendMessage(tag.concat(line));
        }
    }

    @Override
    public void sendErrorTo(CommandSender[] targets){
        String tag = tags.getTag(false, true);
        for(String line : message){
            for(CommandSender target : targets){
                target.sendMessage(tag.concat(line));
            }
        }
    }

    @Override
    public void sendErrorTo(Collection<CommandSender> targets){
        String tag = tags.getTag(false, true);
        for(String line : message){
            for(CommandSender target : targets){
                target.sendMessage(tag.concat(line));
            }
        }
    }


    @Override
    public void sendToConsole(){
        String tag = tags.getTag(true, false);
        ConsoleCommandSender target = Bukkit.getConsoleSender();
        for(String line : message){
            target.sendMessage(tag.concat(line));
        }
    }

    @Override
    public void sendErrorToConsole(){
        String tag = tags.getTag(true, true);
        ConsoleCommandSender target = Bukkit.getConsoleSender();
        for(String line : message){
            target.sendMessage(tag.concat(line));
        }
    }


    @Override
    public void sendToPlayers(Player[] targets){
        String tag = tags.getTag(false, false);
        for(String line : message){
            for(CommandSender target : targets){
                target.sendMessage(tag.concat(line));
            }
        }
    }

    @Override
    public void sendToPlayers(Collection<Player> targets){
        String tag = tags.getTag(false, false);
        for(String line : message){
            for(CommandSender target : targets){
                target.sendMessage(tag.concat(line));
            }
        }
    }

    @Override
    public void sendErrorToPlayers(Player[] targets){
        String tag = tags.getTag(false, true);
        for(String line : message){
            for(CommandSender target : targets){
                target.sendMessage(tag.concat(line));
            }
        }
    }

    @Override
    public void sendErrorToPlayers(Collection<Player> targets){
        String tag = tags.getTag(false, true);
        for(String line : message){
            for(CommandSender target : targets){
                target.sendMessage(tag.concat(line));
            }
        }
    }


    @Override
    public void sendBroadcast(String permission){
        String tag = tags.getTag(false, false);
        for(String line : message){
            Bukkit.broadcast(tag.concat(line), permission);
        }
    }

    @Override
    public void sendBroadcast(){
        String tag = tags.getTag(false, false);
        for(String line : message){
            Bukkit.broadcastMessage(tag.concat(line));
        }
    }

    @Override
    public void sendErrorBroadcast(String permission){
        String tag = tags.getTag(false, true);
        for(String line : message){
            Bukkit.broadcast(tag.concat(line), permission);
        }
    }

    @Override
    public void sendErrorBroadcast(){
        String tag = tags.getTag(false, true);
        for(String line : message){
            Bukkit.broadcastMessage(tag.concat(line));
        }
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
