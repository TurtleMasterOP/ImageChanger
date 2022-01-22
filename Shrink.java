//imports
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class Shrink {

    public static void shrink(String filename, int scaleValue) throws IOException{

        //variables
        int scale = scaleValue;
        int r;
        int g;
        int b;
        int a;

        //getting input
        BufferedImage image = ImageIO.read(new File(filename));
        //allocating a scaled output image
        BufferedImage newImage = new BufferedImage(image.getWidth()/scale, image.getHeight()/scale, BufferedImage.TYPE_INT_RGB);

        //walk through all output pixels
        for (int col = 0; col < newImage.getWidth(); col++){
            for(int row = 0; row < newImage.getHeight(); row++){

                //storing rgba data for col2 and row2 loops
                r = 0;
                g = 0;
                b = 0;
                a = 0;

                //walk through input image and store rgba data
                for(int col2 = 0; col2 < scale; col2++){
                    for(int row2 = 0; row2 < scale; row2++){

                        Color color1 = new Color(image.getRGB(col*scale + col2, row*scale + row2), true);

                        r += color1.getRed();
                        g += color1.getGreen();
                        b += color1.getBlue();
                        a += color1.getAlpha();
                    }
                }

                //gets averages for colors and stores
                Color newColor = new Color(r/(scale*scale), g/(scale*scale), b/(scale*scale), a/(scale*scale));

                //sets new image to new average color
                newImage.setRGB(col, row, newColor.getRGB());

            }

        }
        //writes output image
        ImageIO.write(newImage, "jpg", new File("shrunk.jpg"));

    }
    
}
