import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageHelper {

    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static void resize(String inputImagePath,
                              String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
    /**
     * Test resizing images
     */
    public static void main(String[] args) {

        File[] folders = new File("src/data").listFiles();

        for(File f: folders){
            File[] files = f.listFiles();
            File newFolder = new File( f.getPath() + "_Resized");
            newFolder.mkdir();
            for(File file : files){
                try {
                  ImageHelper.resize(file.getPath(), newFolder.getPath()+ "\\" + file.getName(), 60, 45);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
