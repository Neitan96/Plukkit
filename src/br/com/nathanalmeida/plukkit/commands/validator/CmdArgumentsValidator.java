package br.com.nathanalmeida.plukkit.commands.validator;

import br.com.nathanalmeida.plukkit.commands.arguments.ArgumentValidator;
import br.com.nathanalmeida.plukkit.commands.arguments.CommandArguments;
import br.com.nathanalmeida.plukkit.message.message.MessageItem;
import br.com.nathanalmeida.plukkit.message.message.PlukMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/04/2016 00:59
 */
public class CmdArgumentsValidator implements CommandValidator{

    protected final Map<Integer, MessageItem<ArgumentValidator>> validators = new HashMap<>();

    public void setValidator(int index, ArgumentValidator validator, PlukMessage message){
        if(validator == null)
            validators.remove(index);
        else
            validators.put(index, new MessageItem<>(validator, message));
    }

    @Override
    public boolean validCommand(CommandSender sender, Command command, CommandArguments arguments){
        for(int i = 0; i < arguments.length(); i++){
            MessageItem<ArgumentValidator> messageItem = validators.get(i);
            if(messageItem == null ||
                    messageItem.getItem().validArgument(arguments.getString(i)))
                continue;
            messageItem.getMessage().sendErrorTo(sender);
            return false;
        }
        return true;
    }

}
