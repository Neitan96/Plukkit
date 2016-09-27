package br.com.nathanalmeida.plukkit.message.message;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/04/2016 00:06
 */
public class MessageItem<E>{

    protected final E item;
    protected final PlukMessage message;

    public MessageItem(E item, PlukMessage message){
        this.item = item;
        this.message = message;
    }

    public E getItem(){
        return item;
    }

    public PlukMessage getMessage(){
        return message;
    }

}
