package SpareClasses;

public class Dog {
	
	//Class variable declaration
	private int dogSpaceNumber;
	private int dogWeight;
	private boolean grooming;
	
	//default constructor
	public Dog() {
		dogSpaceNumber = -1;
		dogWeight = 999;
		grooming = false;
	}
	
	//overload constructor
	public Dog(int space, int weight, boolean groom) {
		dogSpaceNumber = space;
		dogWeight = weight;
		grooming = groom;
		
	}
	
	
	//methods below for get/set space number, weight and grooming
	public int getDogSpaceNumber () {
		return dogSpaceNumber;
		
	}
	
	
	public void setDogSpaceNumber(int newNumber) {
		dogSpaceNumber = newNumber;
		
	}
	
	public int getDogWeight() {
		return dogWeight;
		
	}
	
	public void setDogWeight(int newWeight) {
		dogWeight = newWeight;
		
	}
	
	public boolean getGrooming() {
		return grooming;
		
	}
	
	public void setGrooming(boolean groom) {
		grooming = groom;
		
	}
	
	public static void main(String[] args) {
		Dog fido = new Dog();
		System.out.println(fido.getDogSpaceNumber());
	}
	
}
