import java.util.Scanner;
import java.util.InputMismatchException;

public class Paint1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        boolean passBool = true;
        
        final double squareFeetPerGallons = 350.0;
        
        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's height
        do{
            try{
                System.out.println("Enter wall height (feet): ");
                wallHeight = scnr.nextDouble();
                if (wallHeight <= 0){
                    throw new Exception("Enter a positive double");
                }
                passBool = false;
            }
            catch(InputMismatchException e) {
                System.out.println("Enter a valid double");
                scnr.nextLine();
            }
            catch(Exception nonzero){
                System.out.println(nonzero.getMessage());
            }
        }while(passBool);

        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's width
        passBool = true;
        do{
            try{
                System.out.println("Enter wall width (feet): ");
                wallWidth = scnr.nextDouble();
                if (wallWidth <= 0){
                    throw new Exception("Enter a positive double");
                }
                passBool = false;
            }
            catch(InputMismatchException e) {
                System.out.println("Enter a valid double");
                scnr.nextLine();
            }
            catch(Exception nonzero){
                System.out.println(nonzero.getMessage());
            }
        }while(passBool);
        
        // Calculate and output wall area
        wallArea = wallHeight * wallWidth;
        System.out.println("Wall area: " + wallArea + " square feet");

        // Calculate and output the amount of paint (in gallons) needed to paint the wall
        gallonsPaintNeeded = wallArea/squareFeetPerGallons;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");
        scnr.close();

    }
}
