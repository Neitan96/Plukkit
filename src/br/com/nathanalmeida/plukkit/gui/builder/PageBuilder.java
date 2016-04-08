package br.com.nathanalmeida.plukkit.gui.builder;

import br.com.nathanalmeida.plukkit.gui.core.binder.GUIBinder;
import br.com.nathanalmeida.plukkit.gui.core.button.ButtonSlot;
import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import br.com.nathanalmeida.plukkit.gui.core.page.PageDefault;
import br.com.nathanalmeida.plukkit.gui.core.page.title.GUITitle;
import br.com.nathanalmeida.plukkit.gui.core.page.title.TitleDefault;
import br.com.nathanalmeida.plukkit.gui.core.page.title.TitleList;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 07/04/2016 00:43
 */
public class PageBuilder{

    protected final GUIBinder binder;
    protected final String name;

    protected List<GUITitle> titles = new ArrayList<>();
    protected List<ButtonSlot> buttons = new ArrayList<>();
    protected int size = -1;
    protected String permission;
    protected ItemStack itemDefault;


    public PageBuilder(GUIBinder binder, String name){
        this.binder = binder;
        this.name = name;
    }


    public PageBuilder addTitle(GUITitle title){
        titles.add(title);
        return this;
    }

    public PageBuilder addTitle(String title, String permission){
        return addTitle(new TitleDefault(title, binder, permission));
    }

    public PageBuilder addTitle(String title){
        return addTitle(title, null);
    }


    public PageBuilder setSize(int size){
        this.size = size;
        return this;
    }


    public PageBuilder setPermission(String permission){
        this.permission = permission;
        return this;
    }


    public PageBuilder setItemDefault(ItemStack itemDefault){
        this.itemDefault = itemDefault;
        return this;
    }


    public void addButton(int slot, GUIButton button){
        this.buttons.add(new ButtonSlot(slot, button));
    }


    public GUIPage buildPage(){
        GUITitle title = null;
        if(titles.size() == 1){
            title = titles.get(0);

        }else if(titles.size() > 0){
            GUITitle[] titles = this.titles.toArray(new GUITitle[this.titles.size()]);
            title = new TitleList(titles);
        }

        return new PageDefault(name, title, size, permission, itemDefault);
    }
}
