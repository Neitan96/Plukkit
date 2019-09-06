package br.com.nathanalmeida.plukkit.gui.core.binder;

import br.com.nathanalmeida.plukkit.gui.core.page.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.message.binder.PlukBinder;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 18:04
 */
public class GUIBinderPlayerInfos implements GUIBinder{

	@Override
	public String binderText(String text, GUIInventoryHolder holder){
		return PlukBinder.bindValues(text,
				"PlayerName", holder.getPlayer().getName(),
				"PlayerDisplay", holder.getPlayer().getDisplayName(),
				"PlayerExp", String.valueOf(holder.getPlayer().getExp()),
				"PlayerFlySpeed", String.valueOf(holder.getPlayer().getFlySpeed()),
				"PlayerWorldName", holder.getPlayer().getWorld().getName(),
				"PlayerLocX", String.valueOf(holder.getPlayer().getLocation().getX()),
				"PlayerLocY", String.valueOf(holder.getPlayer().getLocation().getY()),
				"PlayerLocZ", String.valueOf(holder.getPlayer().getLocation().getZ()),
				"PlayerLocYaw", String.valueOf(holder.getPlayer().getLocation().getYaw()),
				"PlayerLocPitch", String.valueOf(holder.getPlayer().getLocation().getPitch()),
				"PlayerHealth", String.valueOf(holder.getPlayer().getHealth())
		);
	}

}
