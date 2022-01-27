import java.awt.image.*;
import java.awt.*;
import java.io.*;

import javax.imageio.*;

//Take image, return image that has the certain color highlighted and all else removed.
// Done!
//New challenge: make legos: changable brick size + fill bricks with closest average to 8 colors

public class Pallette{
//                                          RED                  ORANGE               YELLOW                GREEN               BLUE                 PURPLE         WHITE
private static Color[] colors = {new Color(255,255,255),new Color(255,0,0), new Color(255,165,0), new Color(255,255,0), new Color(0,255,0), new Color(0,0,255), new Color(127,0,255)};

public static double getDistanceOfColors(Color color1, Color targetColor){

    int red = Math.abs(targetColor.getRed()-color1.getRed());
    int green = Math.abs(targetColor.getGreen()-color1.getGreen());
    int blue = Math.abs(targetColor.getBlue()-color1.getBlue());
    double distance = Math.sqrt((Math.pow(red, 2) + Math.pow(green, 2) + Math.pow(blue, 2))) / Math.sqrt(3);

    return distance;
}

public static Color getClosestColor(Color c){
    Color closestColor = new Color(0,0,0);
    double closestDistance = 2550;

    for(Color color : colors){
        double distance = getDistanceOfColors(c, color);
        if(distance < closestDistance){
            closestColor = color;
            closestDistance = distance;
        }
    }

    return closestColor;
    

}




public static void pallette(String filename, int brickWidth, int brickHeight) throws IOException{

    BufferedImage image = ImageIO.read(new File(filename));
    BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

   

    //For Every Brick
    for(int x = 0; x < newImage.getWidth(); x+= brickWidth){
        for(int y = 0; y < newImage.getHeight(); y+= brickHeight){

     
            //Get the Average Color
            int red = 0;
            int green = 0;
            int blue = 0;
            for(int x2 = x; x2 < x + brickWidth && x+x2 < newImage.getWidth(); x2++){
               for(int y2 = y; y2 < y + brickHeight && y+y2 < newImage.getHeight(); y2++){
            
                Color pixel = new Color(image.getRGB(x+x2, y+y2));
                red += pixel.getRed();
                green += pixel.getGreen();
                blue += pixel.getBlue(); 

            }}
            red /= (brickHeight*brickWidth);
            green /= (brickHeight*brickWidth);
            blue /= (brickHeight*brickWidth);
            Color brickColor = new Color(red, green, blue);

            Color lowResColor = getClosestColor(brickColor);

            //Fill every pixel in the brick with the color.
            for(int x2 = x; x2 < 2*(x + brickWidth) && x+x2 < newImage.getWidth(); x2++){
                for(int y2 = y; y2 < 2*(y + brickHeight) && y+y2 < newImage.getHeight(); y2++){

                  newImage.setRGB(x+x2, y+y2, lowResColor.getRGB());
              }
            
            }

            }
    
        }

        ImageIO.write(newImage, "jpg", new File("palletted.jpg"));



    }

}