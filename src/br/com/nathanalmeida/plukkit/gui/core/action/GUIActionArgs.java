package br.com.nathanalmeida.plukkit.gui.core.action;

import br.com.nathanalmeida.plukkit.configurations.features.PlukPermission;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 18:59
 */
public class GUIActionArgs implements GUIActionButton{

	private String actionName;
	private PlukPermission permission;
	private String[] arguments;

	public GUIActionArgs(String actionName, PlukPermission permission, String[] arguments){
		this.actionName = actionName;
		this.permission = permission;
		this.arguments = arguments;
	}

	@Override
	public String actionName(){
		return actionName;
	}

	@Override
	public PlukPermission getPermission(){
		return permission;
	}

	@Override
	public String[] getArguments(){
		return arguments;
	}

}
