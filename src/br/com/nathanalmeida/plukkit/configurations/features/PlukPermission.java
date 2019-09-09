package br.com.nathanalmeida.plukkit.configurations.features;

import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;
import br.com.nathanalmeida.plukkit.loaders.PlukObjectLoader;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 05/09/2019 21:07
 */
public class PlukPermission implements PlukObjectLoader{

	protected String[] permissions;

	public PlukPermission(String[] permissions){
		this.permissions = permissions;
	}

	public PlukPermission(String permission){
		this(new String[]{permission});
	}

	public PlukPermission(Object object){
		loadFromObject(object);
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

	@Override
	public void loadFromObject(Object object){
		if(object instanceof String)
			permissions = new String[]{((String) object)};
		else if(object instanceof Collection)
			permissions = (String[]) ((Collection) object).toArray(new String[0]);
		else if(object instanceof String[])
			permissions = (String[]) object;
	}
}
