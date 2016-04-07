package br.com.nathanalmeida.plukkit.gui.builder;

import br.com.nathanalmeida.plukkit.gui.core.action.ActCommandDefault;
import br.com.nathanalmeida.plukkit.gui.core.action.ActCommandList;
import br.com.nathanalmeida.plukkit.gui.core.action.GUIActionCommand;
import br.com.nathanalmeida.plukkit.gui.core.button.ButtonDefault;
import br.com.nathanalmeida.plukkit.gui.core.display.DisplayList;
import br.com.nathanalmeida.plukkit.gui.core.display.GUIDisplay;
import br.com.nathanalmeida.plukkit.gui.core.display.DisplayItem;
import br.com.nathanalmeida.plukkit.gui.core.manager.GUIManager;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/04/2016 23:48
 */
public class ButtonBuilder{

    protected final GUIManager manager;
    protected final ButtonAdder adder;

    protected List<GUIActionCommand> actionsCommand = new ArrayList<>();
    protected List<GUIDisplay> displays = new ArrayList<>();
    protected boolean closeOnClick = false;
    protected String permission = null;


    public ButtonBuilder(GUIManager manager, ButtonAdder adder){
        this.manager = manager;
        this.adder = adder;
    }


    public ButtonBuilder addAction(GUIActionCommand action){
        actionsCommand.add(action);
        return this;
    }

    public ButtonBuilder addAction(String command){
        addAction(new ActCommandDefault(manager, command, null, null));
        return this;
    }

    public ButtonBuilder addAction(String command, String... arguments){
        addAction(new ActCommandDefault(manager, command, arguments, null));
        return this;
    }

    public ButtonBuilder addAction(String permission, String command, String... arguments){
        addAction(new ActCommandDefault(manager, command, arguments, permission));
        return this;
    }

    public ButtonBuilder addAction(String permission, boolean lastIsDef, String command, String... arguments){
        GUIActionCommand lastAction = actionsCommand.remove(actionsCommand.size() - 1);
        addAction(new ActCommandDefault(manager, command, arguments, permission, lastAction));
        return this;
    }


    public ButtonBuilder addDisplay(GUIDisplay display){
        displays.add(display);
        return this;
    }

    public ButtonBuilder addDisplay(ItemStack itemStack, String permission){
        return addDisplay(new DisplayItem(itemStack, manager.getBinder(), permission));
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

    public ButtonBuilder buildButton(){
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

        ButtonDefault button = new ButtonDefault(display, closeOnClick, actionCommand, permission);
        adder.addButton(button);

        return this;
    }

}
