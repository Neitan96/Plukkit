package br.com.nathanalmeida.plukkit.gui.core.button;

import br.com.nathanalmeida.plukkit.configurations.features.PlukPermission;
import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionButton;
import br.com.nathanalmeida.plukkit.gui.core.events.GUIInvButtonClickEvent;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIConfigLoader;
import br.com.nathanalmeida.plukkit.loaders.PlukConfigLoader;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 08/09/2019 17:20
 */
public class GUISimpleButton implements GUIButton, GUIConfigLoader{

	protected String name;
	protected GUIButtonDisplay display;
	protected int slot;
	protected boolean closeOnClick;
	protected String title;
	protected String[] lore;
	protected PlukPermission permission;
	protected List<GUIActionButton> actions;

	public GUISimpleButton(String name, GUIButtonDisplay display, int slot, boolean closeOnClick, String title, String[] lore, PlukPermission permission, List<GUIActionButton> actions){
		this.name = name;
		this.display = display;
		this.slot = slot;
		this.closeOnClick = closeOnClick;
		this.title = title;
		this.lore = lore;
		this.permission = permission;
		this.actions = actions;
	}

	public GUISimpleButton(String name, GUIButtonDisplay display, int slot, boolean closeOnClick, PlukPermission permission, List<GUIActionButton> actions){
		this(name, display, slot, closeOnClick, null, null, permission, actions);
	}

	public GUISimpleButton(String name, GUIButtonDisplay display, int slot){
		this(name, display, slot, false, null, new ArrayList<>());
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public GUIButtonDisplay getDisplay(){
		return display;
	}

	@Override
	public void setDisplay(GUIButtonDisplay display){
		this.display = display;
	}

	@Override
	public int getSlot(){
		return slot;
	}

	@Override
	public void setSlot(int slot){
		this.slot = slot;
	}

	@Override
	public boolean closeOnClick(){
		return closeOnClick;
	}

	@Override
	public void setCloseOnClick(boolean closeOnClick){
		this.closeOnClick = closeOnClick;
	}

	@Override
	public PlukPermission getPermission(){
		return permission;
	}

	@Override
	public List<GUIActionButton> getActions(){
		return actions;
	}

	@Override
	public void onClick(GUIInvButtonClickEvent event){
		if(!getPermission().hasPermission(event.getPlayer())) return;
		if(closeOnClick) event.getPlayer().closeInventory();

		event.getManager().executeCommands(event, getActions());
	}

	public  void copyFrom(GUIButton button){
		this.name = button.getName();
		this.display = button.getDisplay();
		this.slot = button.getSlot();
		this.closeOnClick = button.closeOnClick();
		this.permission = button.getPermission();
		this.actions = button.getActions();

		if(button instanceof GUISimpleButton){
			this.title = ((GUISimpleButton) button).title;
			this.lore = ((GUISimpleButton) button).lore;
		}
	}

	@Override
	public boolean loadFromConfig(ConfigurationSection section, Map<String, GUIButtonDisplay> displayGlobal, List<GUIButton> buttonsGlobal){

		if(section.contains("Model")){
			if(buttonsGlobal == null) return false;

			for(GUIButton button : buttonsGlobal){
				if(button.getName().equalsIgnoreCase(section.getString("Model"))){
					copyFrom(button);
					this.slot = section.getInt("Slot", this.slot);
					return true;
				}
			}
		}else{
			if(section.contains("Display")){
				if(section.isString("Display")){
					if(!displayGlobal.containsKey(section.getString("Display"))) return false;
					this.display = displayGlobal.get(section.getString("Display"));
				}else if(section.isConfigurationSection("Display")){
					this	.display = new GUISimpleDisplay(section.getConfigurationSection("Display"));
				}
				return false;
			}else{
				this.display = new GUISimpleDisplay(Material.STONE);
			}

			this.closeOnClick = section.getBoolean("CloseOnClick", false);
			this.title = section.getString("Title");

			if(section.contains("Lore")){
				if(section.isString("Lore")){
					this.lore = new String[]{section.getString("Lore")};
				}else if(section.isList("Lore")){
					this.lore = section.getList("Lore").toArray(new String[0]);
				}
			}else{
				this.lore = null;
			}

			if(section.contains("Permission")){
				this.permission = new PlukPermission(section.get("Permission"));
			}else{
				this.permission = null;
			}

			if(section.isConfigurationSection("Actions")){
				//TODO load actions from button
			}

		}
		return false;
	}
}
