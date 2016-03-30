package br.com.nathanalmeida.plukkit.gui.action;

import br.com.nathanalmeida.plukkit.gui.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.page.GUIPage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.logging.Level;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 29/03/2016 20:45
 */
public class ActionToPage implements GUIActionProcessor{

    @Override
    public void process(Player player, String argument, GUIButton button){
        if(argument == null){
            Bukkit.getLogger().log(Level.WARNING, "Command from action 'ToPage' not found!");
            return;
        }

        GUIPage page = button.getPage().getManager().getPage(argument);
        if(page == null){
            Bukkit.getLogger().log(Level.WARNING, "Page name from action 'ToPage' not found!");

        }else{
            player.closeInventory();
            page.openToPlayer(player);
        }
    }

}
