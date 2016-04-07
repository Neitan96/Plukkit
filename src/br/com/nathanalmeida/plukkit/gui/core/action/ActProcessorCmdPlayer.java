package br.com.nathanalmeida.plukkit.gui.core.action;

import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.logging.Level;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 20:47
 */
public class ActProcessorCmdPlayer implements GUIActionProcessor{

    @Override
    public void process(GUIManager manager, Player player, String[] arguments){
        if(arguments.length == 0){
            Bukkit.getLogger().log(Level.WARNING, "Command from action 'CommandPlayer' not found!");
            return;
        }

        String argument = manager.getBinder().bindValues(arguments[0], player);
        Bukkit.dispatchCommand(player, argument);
    }

}
