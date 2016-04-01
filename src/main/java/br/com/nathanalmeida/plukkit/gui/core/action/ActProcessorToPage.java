package br.com.nathanalmeida.plukkit.gui.core.action;

import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.logging.Level;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 20:45
 */
public class ActProcessorToPage implements GUIActionProcessor{

    @Override
    public void process(Player player, String[] arguments, GUIManager manager){
        if(arguments.length == 0){
            Bukkit.getLogger().log(Level.WARNING, "Command from action 'ToPage' not found!");
            return;
        }

        GUIPage page = manager.getPage(arguments[0]);
        if(page == null){
            Bukkit.getLogger().log(Level.WARNING, "Page name from action 'ToPage' not found!");

        }else{
            player.closeInventory();
            page.openToPlayer(player);
        }
    }

}
