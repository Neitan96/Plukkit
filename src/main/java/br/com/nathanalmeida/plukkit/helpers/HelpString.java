package br.com.nathanalmeida.plukkit.helpers;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 17/03/2016 23:06
 */
public final class HelpString{

    public static int toInt(String string, int defaultValue){
        try{
            return Integer.parseInt(string);
        }catch(Exception e){
            return defaultValue;
        }
    }

    public static double toDouble(String string, double defaultValue){
        try{
            return Double.parseDouble(string);
        }catch(Exception e){
            return defaultValue;
        }
    }

    public static float toFloat(String string, float defaultValue){
        try{
            return Float.parseFloat(string);
        }catch(Exception e){
            return defaultValue;
        }
    }

}
