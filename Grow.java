//EQUATIONS
//a+(xplace-x0)(b-a)
//a+(0.5-0)(b-a)
//a+.5b-.5a
//.5a+.5b 
//1/2(a+b)

//deltaCol = ((float)col/(float)scale) - (col/scale)

//imports
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class Grow {

    public static void grow(String filename, int scale) throws IOException{

        //getting input
        BufferedImage image = ImageIO.read(new File(filename));
        //allocating a scaled output image
        BufferedImage newImage = new BufferedImage(image.getWidth()*scale, image.getHeight()*scale, BufferedImage.TYPE_INT_RGB);

        //walk through all output pixels
        for (int col = 0; col < newImage.getWidth(); col ++){

            for(int row = 0; row < newImage.getHeight(); row++){

                float deltaCol = ((float)col/(float)scale) - (col/scale);
                float deltaRow = ((float)row/(float)scale) - (row/scale);
                int ul_row,ul_col;

                ul_row = (int)(row/scale);
                ul_col = (int)(col/scale);

                //clockwise colors
                Color color1 = new Color(image.getRGB(ul_col, ul_row)); //a 
                Color color2 = new Color(image.getRGB(Math.min(Math.max(0, ul_col+1), image.getWidth()-1), ul_row)); //b
                Color color3 = new Color(image.getRGB(Math.min(Math.max(0, ul_col+1), image.getWidth()-1), Math.min(Math.max(0, ul_row+1), image.getHeight()-1))); //c
                Color color4 = new Color(image.getRGB(ul_col, Math.min(Math.max(0, ul_row+1), image.getHeight()-1))); //d

                int r = interpolate(color1.getRed(), color2.getRed(), color3.getRed(), color4.getRed(), deltaCol, deltaRow);
                int g = interpolate(color1.getGreen(), color2.getGreen(), color3.getGreen(), color4.getGreen(), deltaCol, deltaRow);
                int b = interpolate(color1.getBlue(), color2.getBlue(), color3.getBlue(), color4.getBlue(), deltaCol, deltaRow);

                Color color5 = new Color(r, g, b);

                newImage.setRGB(col, row, color5.getRGB());

            }

        }


        //writes output image
        ImageIO.write(newImage, "png", new File("grow.png"));

    }//end of grow
    
    public static int interpolate(int w, int x, int y, int z, float deltaCol, float deltaRow){

        float value1 = w + (z-w)*deltaRow;
        float value2 = x + (y-x)*deltaRow;
        float value3 = value1 + (value2-value1)*deltaCol;

        return (int)value3;

    }

}