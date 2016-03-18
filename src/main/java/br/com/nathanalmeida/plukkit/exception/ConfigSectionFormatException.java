package br.com.nathanalmeida.plukkit.exception;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 17/03/2016 23:23
 */
public class ConfigSectionFormatException extends RuntimeException{

    public ConfigSectionFormatException(){
        super();
    }

    public ConfigSectionFormatException(String message){
        super(message);
    }

    public ConfigSectionFormatException(String message, Throwable cause){
        super(message, cause);
    }

    public ConfigSectionFormatException(Throwable cause){
        super(cause);
    }

    public ConfigSectionFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
