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

    default String getTagToPlayer(boolean error){
        return error ? getTagToPlayerError() : getTagToPlayer();
    }


    String getTagToConsole();

    String getTagToConsoleError();

    default String getTagToConsole(boolean error){
        return error ? getTagToConsoleError() : getTagToConsole();
    }


    default String getTag(boolean toConsole, boolean error){
        return toConsole ? getTagToConsole(error) : getTagToPlayer(error);
    }

}
