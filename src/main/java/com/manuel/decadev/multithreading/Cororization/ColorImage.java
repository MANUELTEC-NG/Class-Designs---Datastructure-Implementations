package com.manuel.decadev.multithreading.Cororization;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Demonstrating latency in java multithreading
 * Picks an flower image and colorize its parts
 */
public class ColorImage {
    public static final String SOURCE_FILE = "/Users/dec/IdeaProjects/Java|Models|Concepts/src/main/java/com/manuel/decadev/multithreading/Cororization/resources/many-flowers.jpg";
    public static final String DESTINATION_FILE = "./out/new-flowers.jpg";

    public static void main(String[] args) throws IOException {
        // read the image to the buffered image
        BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(),
                originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        final int NUMB_OF_THREADS = 14;

    Long startTime = System.currentTimeMillis();
    /** running the task with a single thread */
        //recolorSingleThreaded(originalImage, resultImage);

        /** running the same task with multi-threads */

        recolorMultiThreaded(originalImage, resultImage, NUMB_OF_THREADS);
    Long endTime = System.currentTimeMillis();

    Long duration = endTime - startTime;
        File output = new File(DESTINATION_FILE);
        ImageIO.write(resultImage, ".jpg", output);

        System.out.println("Single Threaded Solution ran for: "+ String.valueOf(duration) + " millisecond");

    }

    public static void recolorMultiThreaded(BufferedImage originalImage, BufferedImage resultImage, int numbOfThreads){
        List<Thread> threads = new ArrayList<>();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight() / numbOfThreads;

        for (int i = 0; i < numbOfThreads; i += 1){
            final int threadMultiplier = i;

            Thread thread = new Thread(()->{
                int leftCorner = 0;
                int topcorner = height * threadMultiplier;

                recolorImage(originalImage, resultImage, leftCorner, topcorner, width, height);

            });
            threads.add(thread);
        }

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException ie){
                System.out.println("Interrupted Exception thrown");
            }
        }
    }
    public static void recolorSingleThreaded(BufferedImage originalImage, BufferedImage resultImage){
        recolorImage(originalImage, resultImage, 0,0, originalImage.getWidth(), originalImage.getHeight());
    }

    public  static  void recolorImage(BufferedImage originalImage, BufferedImage resultImage,
                                      int leftCorner, int topCorner, int width, int height){
        for(int x = leftCorner; x < (leftCorner + width) && (x < originalImage.getWidth()); x += 1 ){
            for (int y = topCorner; y < topCorner + height && y < originalImage.getHeight(); y += 1){
                recolorPixel(originalImage, resultImage, x, y);
            }
        }
    }

    public static void  recolorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y){
        int rgb = originalImage.getRGB(x, y);

        int red = Recolor.getRed(rgb);
        int green = Recolor.getGreen(rgb);
        int blue = Recolor.getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;
        if (Recolor.isShadeOfGrey(red, green, blue)){
            newRed = Math.min( 255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue -20);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }

        int newRGB = Recolor.createRGBFromColors(newRed, newGreen, newBlue);
        setRGB(resultImage, x, y, newRGB);
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb){
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }
}
