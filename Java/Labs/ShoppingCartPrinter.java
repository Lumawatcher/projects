package Labs;
import java.util.Scanner;

public class ShoppingCartPrinter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String productName;
      int productPrice = 0;
      int productQuantity = 0;
      int cartTotal = 0;
  
      ItemToPurchase item1 = new ItemToPurchase();
      ItemToPurchase item2 = new ItemToPurchase();

      // Get item 1 details from user, create itemToPurchase object
      System.out.println("Item 1");
      System.out.println("Enter the item name:");
      productName = scnr.nextLine();
      item1.setName(productName);
      System.out.println("Enter the item price:");
      productPrice = scnr.nextInt();
      item1.setPrice(productPrice);
      System.out.println("Enter the item quantity:");
      productQuantity = scnr.nextInt();
      item1.setQuantity(productQuantity);


      // Get item 2 details from user, create itemToPurchase object
      System.out.println("Item 2");
      System.out.println("Enter the item name:");
      productName = scnr.nextLine();
      item2.setName(productName);
      System.out.println("Enter the item price:");
      productPrice = scnr.nextInt();
      item2.setPrice(productPrice);
      System.out.println("Enter the item quantity:");
      productQuantity = scnr.nextInt();
      item2.setQuantity(productQuantity);
      
      System.out.println("TOTAL COST");
      System.out.println(item1.getName() + " " + item1.getQuantity() + " @ $" + item1.getPrice() + " = $" + item1.getQuantity() * item1.getPrice());
      System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $" + item2.getPrice() + " = $" + item2.getQuantity() * item2.getPrice());
      cartTotal = (item1.getQuantity() * item1.getPrice()) + (item2.getQuantity() * item2.getPrice());
      System.out.println("Total: $" + cartTotal);
      scnr.close();
      return;
   }
}
