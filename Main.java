import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{

        System.out.println("Loading...");

        int value1 = 0;
        int value2 = 0;
        int value3 = 0;
        String input = " ";
        int index = 0;

        while (index < args.length){

            if (args[index].compareTo("shrink") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                input = args[index + 2];
                Shrink.shrink(input, value1);
                break;

            }
            else if (args[index].compareTo("greyscale") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                value2 = Integer.parseInt(args[index + 2]);
                value3 = Integer.parseInt(args[index + 3]);
                input = args[index + 4];
                GreyScale.greyScale(input, value1, value2, value3);
                break;

            }
            else if (args[index].compareTo("grow") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                input = args[index + 2];
                Grow.grow(input, value1);
                break;

            }
            else if (args[index].compareTo("simplegrow") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                input = args[index + 2];
                SimpleGrow.simpleGrow(input, value1);
                break;
            }
            else if (args[index].compareTo("pallette") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                value2 = Integer.parseInt(args[index + 2]);
                input = args[index + 3];
                Pallette.pallette(input, value1, value2);
                break;

            }
            else if (args[index].compareTo("pixelfinder") == 0){

                value1 = Integer.parseInt(args[index + 1]);
                value2 = Integer.parseInt(args[index + 2]);
                value3 = Integer.parseInt(args[index + 3]);
                input = args[index + 4];
                PixelFinder.pixelFinder(input, value1, value2, value3);
                break;
            }
            else{
                break;
            }

        }

    }

  }