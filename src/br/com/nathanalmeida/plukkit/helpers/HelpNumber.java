package br.com.nathanalmeida.plukkit.helpers;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 17/03/2016 23:16
 */
public final class HelpNumber{

    public static int getMax(int value1, int value2){
        return value1 > value2 ? value1 : value2;
    }

    public static int getMin(int value1, int value2){
        return value1 < value2 ? value1 : value2;
    }


    public static double getMax(double value1, double value2){
        return value1 > value2 ? value1 : value2;
    }

    public static double getMin(double value1, double value2){
        return value1 < value2 ? value1 : value2;
    }


    public static float getMax(float value1, float value2){
        return value1 > value2 ? value1 : value2;
    }

    public static float getMin(float value1, float value2){
        return value1 < value2 ? value1 : value2;
    }

}
