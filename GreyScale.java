import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class GreyScale {

    public static double getDistance(Color color1, Color targetColor){

        int r = Math.abs(targetColor.getRed()-color1.getRed());
        int g = Math.abs(targetColor.getGreen()-color1.getGreen());
        int b = Math.abs(targetColor.getBlue()-color1.getBlue());
        double distance = Math.sqrt((Math.pow(r, 2) + Math.pow(g, 2) + Math.pow(b, 2))) / Math.sqrt(3);

        return distance;

    }

    public static void greyScale(String filename, int value1, int value2, int value3) throws IOException{

        Color targetColor = new Color(value1, value2, value3);

        BufferedImage image = ImageIO.read(new File(filename));
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int width = 0; width < image.getWidth(); width++){
            for(int height = 0; height < image.getHeight(); height++){

                Color color1 = new Color(image.getRGB(width, height), true);

                int distance = (int) getDistance(color1, targetColor);
                    newImage.setRGB(width, height, new Color(distance,distance,distance).getRGB());
            }

        }
        ImageIO.write(newImage, "jpg", new File("greyed.jpg"));

    }
    
}
