package br.com.nathanalmeida.plukkit.gui.core.action.executors;

import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionExecutor;
import br.com.nathanalmeida.plukkit.gui.core.events.GUIInvButtonClickEvent;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.Bukkit;

import java.util.logging.Level;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 18:54
 */
public class GUIActionToPage implements GUIActionExecutor{

	@Override
	public String getName(){
		return "ToPage";
	}

	@Override
	public void execute(GUIInvButtonClickEvent buttonClick, String[] arguments){
		if(arguments.length == 0){
			Bukkit.getLogger().log(Level.WARNING, "Command from action 'ToPage' not found!");
			return;
		}

		GUIPage page = buttonClick.getManager().getPage(arguments[0]);
		if(page == null){
			Bukkit.getLogger().log(Level.WARNING, "Page name from action 'ToPage' not found!");
			return;
		}

		page.openToPlayer(buttonClick.getPlayer());

	}

}
