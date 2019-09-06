package br.com.nathanalmeida.plukkit.configurations.features;

import org.bukkit.entity.Player;

import java.util.Arrays;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 05/09/2019 21:07
 */
public class PlukPermission{

	protected String[] permissions;

	public PlukPermission(String[] permissions){
		this.permissions = permissions;
	}

	public PlukPermission(String permission){
		this(new String[]{permission});
	}


	public void addPermission(String permission){
		int index = permissions.length;
		permissions = Arrays.copyOf(permissions, index + 1);
		permissions[index] = permission;
	}

	public boolean removePermission(String permission){
		boolean find = false;
		for(int index = 0; index < permissions.length; index++){
			if(!find && permissions[index].equalsIgnoreCase(permission)) find = true;
			if(find) permissions[index] = permissions[index + 1];
		}
		if(find) permissions = Arrays.copyOf(permissions, permissions.length - 1);
		return find;
	}

	public String[] getPermissionsList(){
		return permissions.clone();
	}

	public  boolean hasPermission(Player player){
		for(String permission : permissions){
			if(player.hasPermission(permission)) return true;
		}
		return false;
	}

}
