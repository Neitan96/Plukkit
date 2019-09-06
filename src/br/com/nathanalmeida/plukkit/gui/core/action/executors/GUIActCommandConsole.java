package br.com.nathanalmeida.plukkit.gui.core.action.executors;

import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionExecutor;
import br.com.nathanalmeida.plukkit.gui.core.events.GUIInvButtonClickEvent;
import org.bukkit.Bukkit;

import java.util.logging.Level;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 18:48
 */
public class GUIActCommandConsole implements GUIActionExecutor{

	@Override
	public String getName(){
		return "CommandConsole";
	}

	@Override
	public void execute(GUIInvButtonClickEvent buttonClick, String[] arguments){
		if(arguments.length == 0){
			Bukkit.getLogger().log(Level.WARNING, "Command from action 'CommandConsole' not found!");
			return;
		}

		String argument = buttonClick.getManager().bindValues(arguments[0], buttonClick.getHolder());
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), argument);
	}

}
