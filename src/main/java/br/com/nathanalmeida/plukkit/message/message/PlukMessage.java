package br.com.nathanalmeida.plukkit.message.message;

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

    PlukMessage bind(String... binds);


    void sendTo(CommandSender target);

    void sendTo(CommandSender[] targets);

    void sendTo(Collection<CommandSender> targets);

    void sendErrorTo(CommandSender target);

    void sendErrorTo(CommandSender[] targets);

    void sendErrorTo(Collection<CommandSender> targets);


    void sendToConsole();

    void sendErrorToConsole();


    void sendToPlayers(Player[] targets);

    void sendToPlayers(Collection<Player> targets);

    void sendErrorToPlayers(Player[] targets);

    void sendErrorToPlayers(Collection<Player> targets);


    void sendBroadcast(String permission);

    void sendBroadcast();

    void sendErrorBroadcast(String permission);

    void sendErrorBroadcast();

    PlukMessage cloneMessage();

}
