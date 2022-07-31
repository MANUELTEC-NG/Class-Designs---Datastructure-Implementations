package com.manuel.decadev.multithreading.Cororization;

public class Recolor {


    public static int createRGBFromColors(int red, int green, int blue){
        // building a compound value of color from red, green and blue
        // doing the opposite of the other three methods

        int rgb = 0;

        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        // setting the alpha value to the highest value to make the pixel opaque
        rgb |= 0xFF000000;
        return rgb;
    }
    public static int getBlue(int rgb){
        // masking out the alpha
        return rgb & 0x000000FF;
    }

    public static int getRed(int rgb){
        // masking  out the alpha and shifting 2 bytes to the right
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb){
        // shift 8bits to the right
        return  rgb & (0x0000FF00) >> 8;
    }

    public static boolean isShadeOfGrey(int red, int green, int blue){
    return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;

    }
}
