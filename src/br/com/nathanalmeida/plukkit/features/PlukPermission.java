package br.com.nathanalmeida.plukkit.features;

import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 09/09/2019 02:25
 */
public class PlukPermission implements PlukPermissible{

	protected String[] permissions;

	public PlukPermission(String... permissions){
		this.permissions = permissions;
	}

	public PlukPermission(Collection<String> permissions){
		this.permissions = permissions.toArray(new String[0]);
	}

	public PlukPermission(Object permissions){
		if(permissions instanceof Collection)
			this.permissions = (String[]) ((Collection) permissions).toArray(new String[0]);
		else if(permissions instanceof String[])
			this.permissions = (String[]) permissions;
		else if(permissions instanceof String)
			this.permissions = new String[]{(String) permissions};
		else
			throw new IllegalArgumentException("Object type for permission is not valid");
	}

	@Override
	public boolean hasPermission(Player player){
		for(String permission : permissions){
			if(player.hasPermission(permission)) return true;
		}
		return false;
	}

}
