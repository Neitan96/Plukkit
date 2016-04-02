package br.com.nathanalmeida.plukkit.message.tag;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 11/02/2016 18:28
 */
public class TagManagerDefault implements TagManager{

    protected final String tagToPlayer;
    protected final String tagToPlayerError;
    protected final String tagToConsole;
    protected final String tagToConsoleError;

    public TagManagerDefault(String tagToPlayer, String tagToPlayerError,
                             String tagToConsole, String tagToConsoleError){
        this.tagToPlayer = tagToPlayer;
        this.tagToPlayerError = tagToPlayerError;
        this.tagToConsole = tagToConsole;
        this.tagToConsoleError = tagToConsoleError;
    }

    public TagManagerDefault(String tagToPlayer, String tagToConsole){
        this(tagToPlayer, tagToPlayer, tagToConsole, tagToConsole);
    }

    public TagManagerDefault(String tagToAll){
        this(tagToAll, tagToAll, tagToAll, tagToAll);
    }

    @Override
    public String getTagDefault(){
        return tagToPlayer;
    }

    @Override
    public String getTagToPlayer(){
        return tagToPlayer;
    }

    @Override
    public String getTagToPlayerError(){
        return tagToPlayerError == null ? getTagToPlayer() : tagToPlayerError;
    }

    @Override
    public String getTagToPlayer(boolean error){
        return error ? getTagToPlayerError() : getTagToPlayer();
    }

    @Override
    public String getTagToConsole(){
        return tagToConsole == null ? getTagToPlayer() : tagToConsole;
    }

    @Override
    public String getTagToConsoleError(){
        return tagToConsoleError == null ?
                (tagToConsole == null ? getTagToPlayerError() : tagToConsole) :
                tagToConsoleError;
    }

    @Override
    public String getTagToConsole(boolean error){
        return error ? getTagToConsoleError() : getTagToConsole();
    }

    @Override
    public String getTag(boolean toConsole, boolean error){
        return toConsole ? getTagToConsole(error) : getTagToPlayer(error);
    }

}
