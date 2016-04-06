package br.com.nathanalmeida.plukkit.commands.executor;

import br.com.nathanalmeida.plukkit.commands.arguments.CommandArguments;
import br.com.nathanalmeida.plukkit.commands.validator.CommandValidator;
import br.com.nathanalmeida.plukkit.message.message.MessageItem;
import br.com.nathanalmeida.plukkit.message.message.PlukMessage;
import br.com.nathanalmeida.plukkit.message.message.PlukMessageDefault;
import br.com.nathanalmeida.plukkit.message.tag.TagManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/04/2016 01:41
 */
public abstract class ValidatorCmdExecutor implements CommandExecutor{

    protected final List<MessageItem<CommandValidator>> validators = new ArrayList<>();
    protected final Map<String, Object> commandProperties;


    public ValidatorCmdExecutor(Map<String, Object> commandProperties){
        this.commandProperties = commandProperties;
    }

    public ValidatorCmdExecutor(JavaPlugin plugin, String commmandName){
        this(plugin.getDescription().getCommands().get(commmandName));
    }


    protected void addValidator(CommandValidator validator, PlukMessage message){
        validators.add(new MessageItem<>(validator, message));
    }

    protected void addValidator(CommandValidator validator, String messageKey, TagManager tags){
        Object message = commandProperties.get(messageKey);
        String[] messages = new String[0];

        if(message instanceof List){
            //noinspection unchecked
            messages = ((List<String>) message).toArray(new String[0]);

        }else if(message != null){
            messages = new String[]{message.toString()};
        }

        addValidator(validator, new PlukMessageDefault(messages, tags));
    }

    protected void addValidator(CommandValidator validator, String messageKey, TagManager tags, String... messageDef){
        if(commandProperties.containsKey(messageKey))
           addValidator(validator, messageKey, tags);
        else
            addValidator(validator, new PlukMessageDefault(messageDef, tags));
    }


    protected PlukMessage getErrorValid(CommandSender sender, Command command, CommandArguments arguments){
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
