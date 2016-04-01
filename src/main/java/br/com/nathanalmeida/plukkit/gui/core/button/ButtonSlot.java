package br.com.nathanalmeida.plukkit.gui.core.button;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 01/04/2016 14:02
 */
public class ButtonSlot{

    protected final int slot;
    protected final GUIButton button;

    public ButtonSlot(int slot, GUIButton button){
        this.slot = slot;
        this.button = button;
    }

    public int getSlot(){
        return slot;
    }

    public GUIButton getButton(){
        return button;
    }

}
