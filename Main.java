import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{

        System.out.println("Loading...");

        int value1 = 0;
        int value2 = 0;
        int value3 = 0;
        int index = 0;

        while (index < args.length){

            if (args[index].compareTo("shrink") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                Shrink.shrink("input.jpg", value1);
            }
            else if (args[index].compareTo("greyscale") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                value2 = Integer.parseInt(args[index + 2]);
                value3 = Integer.parseInt(args[index + 3]);
                GreyScale.greyScale("input.jpg", value1, value2, value3);
            }
            else if (args[index].compareTo("grow") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                Grow.grow("input.jpg", value1);
            }
            else if (args[index].compareTo("simplegrow") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                SimpleGrow.simpleGrow("input.jpg", value1);
            }
            else if (args[index].compareTo("pallette") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                value2 = Integer.parseInt(args[index + 2]);
                Pallette.pallette("input.jpg", value1, value2);
            }
            else if (args[index].compareTo("pixelfinder") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                value2 = Integer.parseInt(args[index + 2]);
                value3 = Integer.parseInt(args[index + 3]);
                PixelFinder.pixelFinder("input.jpg", value1, value2, value3);
            }
            else{
                break;
            }

        }

    }

  }