import java.util.Scanner;

public class ParseStrings {
   public static void main(String[] args) {
      String userInput = "empty";
      String wordOne;
      String wordTwo;
      Scanner scnr = new Scanner(System.in);
      while (userInput != "q"){
      System.out.println("Enter input string: ");
      userInput = scnr.nextLine();
      userInput = userInput.trim();
      if (userInput.equals("q")){
       break;
      }
      else if (userInput.contains(",")){
         wordOne = userInput.substring(0, userInput.indexOf(','));
         wordTwo = userInput.substring((userInput.indexOf(',') + 1), userInput.length());
         System.out.println("First word: " + wordOne);
         System.out.println("Second word: " + wordTwo);
      }
      else{
         System.out.println("Error: No comma in string: " + userInput);
      }
      }
      System.out.println("Goodbye");
      return;
   }
}