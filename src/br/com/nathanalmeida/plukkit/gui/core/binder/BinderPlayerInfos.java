package br.com.nathanalmeida.plukkit.gui.core.binder;

import br.com.nathanalmeida.plukkit.gui.core.button.GUIButton;
import br.com.nathanalmeida.plukkit.gui.core.page.GUIPage;
import br.com.nathanalmeida.plukkit.message.binder.MessageBinderDefault;
import org.bukkit.entity.Player;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 28/03/2016 16:15
 */
public class BinderPlayerInfos extends GUIBinderBase{

    @Override
    public String bindValues(String message, Player player, GUIPage page, GUIButton button){

        return MessageBinderDefault.BINDER_DEFAULT.bindValues(message,
                "PlayerName", player.getName(),
                //"PlayerDisplay", player.getDisplayName(),
                //"PlayerExp", String.valueOf(player.getExp()),
                //"PlayerFlySpeed", String.valueOf(player.getFlySpeed()),
                "PlayerWorldName", player.getWorld().getName()
                //"PlayerLocX", String.valueOf(player.getLocation().getX()),
                //"PlayerLocY", String.valueOf(player.getLocation().getY()),
                //"PlayerLocZ", String.valueOf(player.getLocation().getZ()),
                //"PlayerLocYaw", String.valueOf(player.getLocation().getYaw()),
                //"PlayerLocPitch", String.valueOf(player.getLocation().getPitch()),
                //"PlayerHealth", String.valueOf(player.getHealth())
        );
    }
}
