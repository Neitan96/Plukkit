package br.com.nathanalmeida.plukkit.gui.core.events;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIInventoryHolder;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 04/09/2019 20:40
 */
public class GUIInvButtonClickEvent extends Event implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;

	protected final InventoryClickEvent event;
	protected final GUIInventoryHolder holder;
	protected final GUIButton button;

	public GUIInvButtonClickEvent(InventoryClickEvent event){
		this.event = event;
		this.holder = (GUIInventoryHolder) event.getInventory();
		this.button = holder.getPageRenderer().getButton(event.getSlot());
		if(this.button == null) throw new RuntimeException("Botão do slot clicado está vazio");
	}

	public InventoryClickEvent getEvent(){
		return event;
	}

	public int getSlotClicked(){
		return getEvent().getSlot();
	}

	public GUIInventoryHolder getHolder(){
		return holder;
	}

	public Player getPlayer(){
		return getHolder().getPlayer();
	}

	public GUIPage getPage(){
		return holder.getPage();
	}

	public GUIManager getManager(){
		return holder.getManager();
	}

	public GUIButton getButtonClicked(){
		return button;
	}


	@Override
	public HandlerList getHandlers(){
		return handlers;
	}

	@Override
	public boolean isCancelled(){
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancel){
		cancelled = cancel;
	}

}
