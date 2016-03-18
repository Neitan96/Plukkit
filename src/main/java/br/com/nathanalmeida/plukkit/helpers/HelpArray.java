package br.com.nathanalmeida.plukkit.helpers;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 12/03/2016 20:37
 */
public final class HelpArray{

    public static String joinString(String[] array, int start, String glue){
        StringBuilder builder = new StringBuilder();
        for(int i = start; i < array.length; i++){
            if(start != i)
                builder.append(glue);
            builder.append(array[i]);
        }
        return builder.toString();
    }

    public static String joinString(String[] array, String glue){
        return joinString(array, 0, glue);
    }

    public static String joinString(String[] array, int start){
        return joinString(array, start, ", ");
    }

    public static String joinString(String[] array){
        return joinString(array, ", ");
    }

}
