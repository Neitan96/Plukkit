package br.com.nathanalmeida.plukkit.gui.core.action;

import br.com.nathanalmeida.plukkit.gui.core.holder.InventoryButtonClick;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 30/03/2016 17:07
 */
public class ActCommandList implements GUIActionCommand{

    protected final GUIActionCommand[] actions;

    public ActCommandList(GUIActionCommand... actions){
        this.actions = actions;
    }

    @Override
    public void executeAction(InventoryButtonClick click){
        for(GUIActionCommand action : actions){
            action.executeAction(click);
        }
    }

}
