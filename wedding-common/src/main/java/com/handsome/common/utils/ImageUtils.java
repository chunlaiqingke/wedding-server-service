package com.handsome.common.utils;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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

    public static void scaleImage(String srcImagePath, String toPath, float scale, float quality){
        try {
            if(srcImagePath != null && srcImagePath.length() > 0){
                String[] split = srcImagePath.split("\\\\");
                Thumbnails.of(srcImagePath).scale(scale).outputQuality(quality).toFile(toPath + "/thumbnail_" + split[split.length - 1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
