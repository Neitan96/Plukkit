package br.com.nathanalmeida.plukkit.message.tag;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 11/02/2016 23:50
 */
public final class PlukTag{

    public static TagManager make(String tagToPlayer, String tagToPlayerError,
                                  String tagToConsole, String tagToConsoleError){
        return new TagManagerDefault(tagToPlayer, tagToPlayerError, tagToConsole, tagToConsoleError);
    }

    public static TagManager make(String tagToPlayer, String tagToConsole){
        return new TagManagerDefault(tagToPlayer, tagToConsole);
    }

    public static TagManager make(String tagToAll){
        return new TagManagerDefault(tagToAll);
    }

}
