package br.com.nathanalmeida.plukkit.commands.validator;

import br.com.nathanalmeida.plukkit.commands.arguments.CommandArguments;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 05/04/2016 20:11
 */
public final class CmdValidators{

    public static CommandValidator argsMin(final int min){
        return new CommandValidator(){
            @Override
            public boolean validCommand(CommandSender sender, Command command, CommandArguments arguments){
                return arguments.length() >= min;
            }
        };
    }

    public static CommandValidator argsMax(final int max){
        return new CommandValidator(){
            @Override
            public boolean validCommand(CommandSender sender, Command command, CommandArguments arguments){
                return arguments.length() <= max;
            }
        };
    }

    public static CommandValidator argsRange(final int min, final int max){
        return new CommandValidator(){
            @Override
            public boolean validCommand(CommandSender sender, Command command, CommandArguments arguments){
                return arguments.length() >= min && arguments.length() <= max;
            }
        };
    }

    public static CommandValidator senderType(final Class typeSender){
        return new CommandValidator(){
            @Override
            public boolean validCommand(CommandSender sender, Command command, CommandArguments arguments){
                return sender.getClass().isAssignableFrom(typeSender);
            }
        };
    }

    public static CommandValidator senderIsPlayer(){
        return senderType(Player.class);
    }

    public static CommandValidator senderIsConsole(){
        return senderType(ConsoleCommandSender.class);
    }

    public static CommandValidator senderIsOP(){
        return new CommandValidator(){
            @Override
            public boolean validCommand(CommandSender sender, Command command, CommandArguments arguments){
                return sender.isOp();
            }
        };
    }

    public static CommandValidator senderNotOP(){
        return new CommandValidator(){
            @Override
            public boolean validCommand(CommandSender sender, Command command, CommandArguments arguments){
                return !sender.isOp();
            }
        };
    }

    public static CommandValidator permission(final String permission){
        return new CommandValidator(){
            @Override
            public boolean validCommand(CommandSender sender, Command command, CommandArguments arguments){
                return sender.hasPermission(permission);
            }
        };
    }

}
