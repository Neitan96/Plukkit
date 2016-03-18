package br.com.nathanalmeida.plukkit.message.tag;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 11/02/2016 18:26
 */
public interface TagManager{

    String getTagDefault();


    String getTagToPlayer();

    String getTagToPlayerError();

    String getTagToPlayer(boolean error);


    String getTagToConsole();

    String getTagToConsoleError();

    String getTagToConsole(boolean error);


    String getTag(boolean toConsole, boolean error);

}
