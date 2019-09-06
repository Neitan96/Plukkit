package br.com.nathanalmeida.plukkit.gui.core.action;

import org.bukkit.configuration.ConfigurationSection;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 18:59
 */
public class GUIActionArgs implements GUIActionButton{

	private String actionName;
	private String permission;
	private String[] arguments;

	public GUIActionArgs(String actionName, String permission, String[] arguments){
		this.actionName = actionName;
		this.permission = permission;
		this.arguments = arguments;
	}

	@Override
	public String actionName(){
		return actionName;
	}

	@Override
	public String getPermission(){
		return permission;
	}

	@Override
	public String[] getArguments(){
		return arguments;
	}

}
