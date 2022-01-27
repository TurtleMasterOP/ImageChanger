//imports
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class SimpleGrow {

    public static void simpleGrow(String filename, int scaleValue) throws IOException{

        //variables
        int scale = scaleValue;

        //getting input
        BufferedImage image = ImageIO.read(new File(filename));
        //allocating a scaled output image
        BufferedImage newImage = new BufferedImage(image.getWidth()*scale, image.getHeight()*scale, BufferedImage.TYPE_INT_RGB);

        //walk through all output pixels
        for (int col = 0; col < newImage.getWidth(); col++){
            for(int row = 0; row < newImage.getHeight(); row++){

                Color color1 = new Color(image.getRGB((int)(col/scale), (int)(row/scale)));
                newImage.setRGB(col, row, color1.getRGB());


            }

        }
        //writes output image
        ImageIO.write(newImage, "jpg", new File("simpleGrow.jpg"));

    }
    
}