package br.com.nathanalmeida.plukkit.gui.core.manager;

import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPageRenderer;
import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 09/09/2019 01:01
 */
public class GUIInventoryHolder{

	protected final GUIManager manager;
	protected final GUIPage page;
	protected final GUIPageRenderer pageRenderer;
	protected final Player player;

	public GUIInventoryHolder(GUIManager manager, GUIPage page, GUIPageRenderer pageRenderer, Player player){
		this.manager = manager;
		this.page = page;
		this.pageRenderer = pageRenderer;
		this.player = player;
	}

	public GUIManager getManager(){
		return manager;
	}

	public GUIPage getPage(){
		return page;
	}

	public GUIPageRenderer getPageRenderer(){
		return pageRenderer;
	}

	public Player getPlayer(){
		return player;
	}

}
