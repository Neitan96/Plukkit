package br.com.nathanalmeida.plukkit.gui.action;

import br.com.nathanalmeida.plukkit.gui.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.manager.GUIManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.logging.Level;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 21:47
 */
public class ActionCommandConsole implements GUIActionProcessor{

    @Override
    public void process(Player player, String argument, GUIButton button){
        if(argument == null){
            Bukkit.getLogger().log(Level.WARNING, "Command from action 'CommandConsole' not found!");
            return;
        }

        GUIManager manager = button.getPage().getManager();
        argument = manager.getBinder().bindValues(argument, player, button.getPage(), button);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), argument);
    }
}
