package br.com.nathanalmeida.plukkit.gui.core.binder;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 15:23
 */
public interface GUIBinder{

    String bindValues(String message, Player player);

    String bindValues(String message, Player player, GUIPage page);

    String bindValues(String message, Player player, GUIPage page, GUIButton button);


    String[] bindValues(String[] message, Player player);

    String[] bindValues(String[] message, Player player, GUIPage page);

    String[] bindValues(String[] message, Player player, GUIPage page, GUIButton button);


    List<String> bindValues(List<String> message, Player player);

    List<String> bindValues(List<String> message, Player player, GUIPage page);

    List<String> bindValues(List<String> message, Player player, GUIPage page, GUIButton button);

}
