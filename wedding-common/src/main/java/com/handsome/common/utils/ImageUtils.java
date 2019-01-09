package com.handsome.common.utils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageUtils {

    public static String cutImage(String srcImage){
        try {
            BufferedImage read = ImageIO.read(new URL(srcImage));
            int srcHeight = read.getHeight();
            int srcWidth = read.getWidth();

            BufferedImage subimage = read.getSubimage(0, 0, 10, 10);
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    public static String scaleImage(String srcImage, int targetWidth, int targetHeight){
        try {
            BufferedImage read = ImageIO.read(new URL(srcImage));
            Image scaledInstance = read.getScaledInstance(targetWidth, targetHeight, 10);
            Graphics graphics = read.getGraphics();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
