package br.com.nathanalmeida.plukkit.gui.builder;

import br.com.nathanalmeida.plukkit.gui.core.action.ActCommandDefault;
import br.com.nathanalmeida.plukkit.gui.core.action.ActCommandList;
import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionCommand;
import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.core.button.ButtonDefault;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.display.DisplayItem;
import br.com.nathanalmeida.plukkit.gui.core.display.DisplayList;
import br.com.nathanalmeida.plukkit.gui.core.display.GUIDisplay;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/04/2016 23:48
 */
public class ButtonBuilder{

    protected final GUIBinder binder;

    protected List<GUIActionCommand> actionsCommand = new ArrayList<>();
    protected List<GUIDisplay> displays = new ArrayList<>();
    protected boolean closeOnClick = false;
    protected String permission = null;


    public ButtonBuilder(GUIBinder binder){
        this.binder = binder;
    }


    public ButtonBuilder addAction(GUIActionCommand action){
        actionsCommand.add(action);
        return this;
    }

    public ButtonBuilder addAction(String command){
        addAction(new ActCommandDefault(command, null, null));
        return this;
    }

    public ButtonBuilder addAction(String command, String... arguments){
        addAction(new ActCommandDefault(command, arguments, null));
        return this;
    }

    public ButtonBuilder addAction(String permission, String command, String... arguments){
        addAction(new ActCommandDefault(command, arguments, permission));
        return this;
    }

    public ButtonBuilder addAction(String permission, boolean lastIsDef, String command, String... arguments){
        GUIActionCommand lastAction = actionsCommand.remove(actionsCommand.size() - 1);
        addAction(new ActCommandDefault(command, arguments, permission, lastAction));
        return this;
    }


    public ButtonBuilder addDisplay(GUIDisplay display){
        displays.add(display);
        return this;
    }

    public ButtonBuilder addDisplay(ItemStack itemStack, String permission){
        return addDisplay(new DisplayItem(itemStack, binder, permission));
    }

    public ButtonBuilder addDisplay(ItemStack itemStack){
        return addDisplay(itemStack, null);
    }


    public ButtonBuilder closeOnClick(boolean close){
        this.closeOnClick = close;
        return this;
    }

    public ButtonBuilder closeOnClick(){
        return closeOnClick(true);
    }

    public ButtonBuilder setPermission(String permission){
        this.permission = permission;
        return this;
    }

    public GUIButton getButton(){
        GUIActionCommand actionCommand = null;
        if(actionsCommand.size() == 1){
            actionCommand = actionsCommand.get(0);
        }else if(actionsCommand.size() > 0){
            GUIActionCommand[] actions = actionsCommand.toArray(new GUIActionCommand[actionsCommand.size()]);
            actionCommand = new ActCommandList(actions);
        }

        GUIDisplay display = null;
        if(displays.size() == 1){
            display = displays.get(0);
        }else if(displays.size() > 0){
            GUIDisplay[] displays = this.displays.toArray(new GUIDisplay[this.displays.size()]);
            display = new DisplayList(displays);
        }
        return new ButtonDefault(display, closeOnClick, actionCommand, permission);
    }

}
