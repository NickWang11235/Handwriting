import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageHelper {

    public static final int IMAGE_WIDTH = 60;
    public static final int IMAGE_HEIGHT = 45;
    
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

    public static void toText(File file){

        try {
            BufferedImage image = ImageIO.read(file);
            PrintWriter out = new PrintWriter(file.getPath().substring(0,file.getPath().indexOf('.')) + ".txt");
            System.out.println(image);
            int[][] map = new int[IMAGE_HEIGHT][IMAGE_WIDTH];
            for (int i = 0; i < IMAGE_HEIGHT; i++) {
                String line = "";
                for (int j = 0; j < IMAGE_WIDTH; j++) {
                    System.out.println(image);
                    System.out.println(i + " ," + j);
                    System.out.println(file.getPath());
                    int clr=  image.getRGB(j,i);
                    int  red   = (clr & 0x00ff0000) >> 16;
                    int  green = (clr & 0x0000ff00) >> 8;
                    int  blue  =  clr & 0x000000ff;

                    if(red + green + blue < 255) {
                        map[i][j] = 1;
                        line += " 1";
                    }else{
                        line += " 0";
                    }

                }
                line += "\n";
                out.write(line);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test resizing images
     */
    public static void main(String[] args) {


    }
}
