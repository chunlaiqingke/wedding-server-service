package com.handsome.common.utils;

import net.coobird.thumbnailator.Thumbnails;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageUtils {

    public static void cutImage(String srcImagePath, String toPath, float quality){
        try {
            if(srcImagePath != null && srcImagePath.length() > 0) {
                String[] split = srcImagePath.split("\\\\");
                BufferedImage srcImage = Thumbnails.of(srcImagePath).scale(1f).asBufferedImage();
                int h = srcImage.getHeight();
                int w = srcImage.getWidth();
                if(h > w){
//                    int min = h - w;
					Thumbnails.of(srcImagePath)
                            .size(1000, 1000)
							.keepAspectRatio(true)
                            .outputQuality(quality)
							.toFile(toPath + "/cut_" + split[split.length - 1]);
                } else if (w > h) {
//                    int min = w - h;
					Thumbnails.of(srcImagePath)
                            .size(1000, 1000)
							.keepAspectRatio(true)
                            .outputQuality(quality)
							.toFile(toPath + "/cut_" + split[split.length - 1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cutImage(File srcFile, String toPath, float quality){
        try {
            if(srcFile != null && srcFile.isFile()) {
                if(toPath == null || toPath.length() == 0){
                    toPath = srcFile.getParent() + "\\cut";
                    File file = new File(toPath);
                    file.getPath();
                    if(!file.exists()){
                        file.mkdir();
                    }
                }
                Thumbnails.of(srcFile)
                        .size(1000, 1000)
                        .keepAspectRatio(true)
                        .outputQuality(quality)
                        .toFile(toPath + "/cut_" + srcFile.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void convertImages(File srcFile, File toFile){
        if(!toFile.exists()){
           toFile.mkdir();
        }
        if(srcFile != null && srcFile.isDirectory()){
            File[] files = srcFile.listFiles();
            if(files != null){
                for (File file : files) {
                    cutImage(file, toFile.getPath(), 1f);
                }
            }
        }
    }
}
