import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class PixelFinder {

    public static void pixelFinder(String filename, int value1, int value2, int value3) throws IOException{

        Color targetColor = new Color(value1, value2, value3);

        BufferedImage image = ImageIO.read(new File(filename));
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);

        for (int width = 0; width < image.getWidth(); width++){
            for(int height = 0; height < image.getHeight(); height++){

                Color color1 = new Color(image.getRGB(width, height), true);

                if(color1.getRGB() == targetColor.getRGB()){

                    newImage.setRGB(width, height, white.getRGB());

                }
                else{
                    newImage.setRGB(width, height, black.getRGB());
                }

            }

        }
        ImageIO.write(newImage, "jpg", new File("pixelfinder.jpg"));

    }
    
}