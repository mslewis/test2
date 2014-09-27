package com.mslewis.testgameb;

/**
 * Created by mslewis on 9/8/14.
 */
public class Helper {
    public static boolean isBetween(float t, float a, float b)
    {
        if(a>b && t>=b && t<=a)
            return true;
        else if(a<b && t>=a && t<=b)
            return true;
        else
            return false;
    }
}
