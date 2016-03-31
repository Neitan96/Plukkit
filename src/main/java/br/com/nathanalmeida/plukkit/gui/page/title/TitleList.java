package br.com.nathanalmeida.plukkit.gui.page.title;

import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 31/03/2016 01:29
 */
public class TitleList implements GUITitle{

    protected final GUITitle[] titles;

    public TitleList(GUITitle... titles){
        this.titles = titles;
    }

    @Override
    public String makeTitle(Player player){
        for(GUITitle title : titles){
            String titleMaked = title.makeTitle(player);
            if(titleMaked != null) return titleMaked;
        }
        return null;
    }
}
