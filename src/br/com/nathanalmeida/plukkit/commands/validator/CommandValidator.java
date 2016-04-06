package br.com.nathanalmeida.plukkit.commands.validator;

import br.com.nathanalmeida.plukkit.commands.arguments.CommandArguments;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 05/04/2016 19:50
 */
public interface CommandValidator{

    boolean validCommand(CommandSender sender, Command command, CommandArguments arguments);

}
