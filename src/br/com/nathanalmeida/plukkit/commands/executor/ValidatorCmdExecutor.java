package br.com.nathanalmeida.plukkit.commands.executor;

import br.com.nathanalmeida.plukkit.commands.arguments.CommandArguments;
import br.com.nathanalmeida.plukkit.commands.validator.CommandValidator;
import br.com.nathanalmeida.plukkit.message.message.MessageItem;
import br.com.nathanalmeida.plukkit.message.message.PlukMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/04/2016 01:41
 */
public abstract class ValidatorCmdExecutor implements CommandExecutor{

    protected final List<MessageItem<CommandValidator>> validators = new ArrayList<>();


    protected final void addValidator(CommandValidator validator, PlukMessage message){
        validators.add(new MessageItem<>(validator, message));
    }

    protected final PlukMessage getErrorValid(CommandSender sender, Command command, CommandArguments arguments){
        for(MessageItem<CommandValidator> validator : validators){
            if(!validator.getItem().validCommand(sender, command, arguments))
                return validator.getMessage();
        }
        return null;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args){
        CommandArguments arguments = new CommandArguments(args);
        PlukMessage error = getErrorValid(commandSender, command, arguments);

        if(error == null)
            return onCmd(commandSender, command, arguments);
        else
            error.sendErrorTo(commandSender);

        return true;
    }

    public abstract boolean onCmd(CommandSender sender, Command command, CommandArguments arguments);

}
