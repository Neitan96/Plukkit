package br.com.nathanalmeida.plukkit.message.message;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 11/02/2016 13:52
 */
public interface PlukMessage extends Comparable<PlukMessage>{

    String[] getMessages();

    default String[] getMessagesPrepared(CommandSender target, boolean error){
        return getMessagesPrepared(!(target instanceof Player), error);
    }

    String[] getMessagesPrepared(boolean toConsole, boolean error);

    PlukMessage bind(String... binds);


    default void sendTo(CommandSender target){
        for(String line : getMessagesPrepared(target, false)){
            target.sendMessage(line);
        }
    }

    default void sendTo(CommandSender[] targets){
        for(CommandSender target : targets){
            for(String line : getMessagesPrepared(target, false)){
                target.sendMessage(line);
            }
        }
    }

    default void sendTo(Collection<CommandSender> targets){
        for(CommandSender target : targets){
            for(String line : getMessagesPrepared(target, false)){
                target.sendMessage(line);
            }
        }
    }

    default void sendErrorTo(CommandSender target){
        for(String line : getMessagesPrepared(target, true)){
            target.sendMessage(line);
        }
    }

    default void sendErrorTo(CommandSender[] targets){
        for(CommandSender target : targets){
            for(String line : getMessagesPrepared(target, true)){
                target.sendMessage(line);
            }
        }
    }

    default void sendErrorTo(Collection<CommandSender> targets){
        for(CommandSender target : targets){
            for(String line : getMessagesPrepared(target, true)){
                target.sendMessage(line);
            }
        }
    }


    default void sendToConsole(){
        for(String line : getMessagesPrepared(true, false)){
            Bukkit.getConsoleSender().sendMessage(line);
        }
    }

    default void sendErrorToConsole(){
        for(String line : getMessagesPrepared(true, true)){
            Bukkit.getConsoleSender().sendMessage(line);
        }
    }


    default void sendToPlayers(Player... targets){
        for(CommandSender target : targets){
            for(String line : getMessagesPrepared(false, false)){
                target.sendMessage(line);
            }
        }
    }

    default void sendToPlayers(Collection<Player> targets){
        for(CommandSender target : targets){
            for(String line : getMessagesPrepared(false, false)){
                target.sendMessage(line);
            }
        }
    }

    default void sendErrorToPlayers(Player[] targets){
        for(CommandSender target : targets){
            for(String line : getMessagesPrepared(false, true)){
                target.sendMessage(line);
            }
        }
    }

    default void sendErrorToPlayers(Collection<Player> targets){
        for(CommandSender target : targets){
            for(String line : getMessagesPrepared(false, true)){
                target.sendMessage(line);
            }
        }
    }


    default void sendBroadcast(){
        for(String line : getMessagesPrepared(false, false)){
            Bukkit.broadcastMessage(line);
        }
    }

    default void sendBroadcast(String permission){
        for(String line : getMessagesPrepared(false, false)){
            Bukkit.broadcast(line, permission);
        }
    }

    default void sendErrorBroadcast(String permission){
        for(String line : getMessagesPrepared(false, true)){
            Bukkit.broadcast(line, permission);
        }
    }

    default void sendErrorBroadcast(){
        for(String line : getMessagesPrepared(false, true)){
            Bukkit.broadcastMessage(line);
        }
    }

    PlukMessage cloneMessage();

}
