package Labs ;
public class ItemToPurchase {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    
    public void ItemToPurchace(){
     itemName = "none";
     itemPrice = 0;
     itemQuantity = 0;
    }
    
    public void setName(String name){
     itemName = name;  
    }
    
    public String getName(){
     return itemName;  
    }
    
    public void setPrice(int price){
       itemPrice = price;
    }
    
    public int getPrice(){
       return itemPrice;
    }
    
    public void setQuantity(int quantity){
       itemQuantity = quantity;
    }
    
    public int getQuantity(){
       return itemQuantity;
    }
    
    
    public void printItemPurchase() {
       System.out.println(itemQuantity + " " + itemName + " $" + itemPrice +  
                          " = $" + (itemPrice * itemQuantity));
    }
 }
 