import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    //instance variables
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static ArrayList<String> validSpecies = new ArrayList<String>();
    private static String name;
    private static String age;
    private static String gender;
    private static String weight;
    private static String acquisitionDate;
    private static String country;
    private static String breed;
    private static String defaultTrainingStatus = "untrained";
    private static boolean defaultReserved = false;
    private static String defaultServiceCountry = "nowhere";
    private static String monkeyTailLength;
    private static String monkeyHeight;
    private static String monkeyBodyLength;
    private static String monkeySpecies;
    private static boolean validSpeciesSelection;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        char menuInput = '0';
        String currentInput;

        initializeDogList();
        initializeMonkeyList();
        //Main menu while loop, q closes the program.
        while (menuInput != 'q'){
            displayMenu();
            currentInput = scnr.nextLine();
            menuInput = currentInput.charAt(0);
            
            if ((menuInput == '1')){
                intakeNewDog(scnr);
            }
            else if ((menuInput == '2')){
                intakeNewMonkey(scnr);
            }
            else if ((menuInput == '3')){
                reserveAnimal(scnr);;
            }
            else if ((menuInput == '4')){
                printAnimals(menuInput - 48, scnr);
            }
            else if ((menuInput == '5')){
                printAnimals(menuInput - 48, scnr);
            }
            else if ((menuInput == '6')){
                printAnimals(menuInput - 48, scnr);
            }
            else if ((menuInput == 'q')){
                break;
            }
            else{
                System.out.println("Input not recognized");
                System.out.println("\nPlease press enter to return to the main menu");
                scnr.nextLine();
            }
            }
            scnr.close();
        }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    //creates the valid species arraylist and adds monkeys to the list for testing.
    public static void initializeMonkeyList() {
        validSpecies.add("capuchin");
        validSpecies.add("guenon");
        validSpecies.add("macaque");
        validSpecies.add("marmoset");
        validSpecies.add("squirrel monkey");
        validSpecies.add("tamarin");
        Monkey monkey1 = new Monkey("Heather", "guenon", "female", "4", "11.6", "05-30-2022", "United Sates", "untrained", false, "United States", "12.5", "135", "150");
        Monkey monkey2 = new Monkey("Joey", "capuchin", "male", "4", "11.6", "05-30-2022", "Ecuador", "untrained", false, "Ecuador", "12.5", "135", "150");
        Monkey monkey3 = new Monkey("Denise", "marmoset", "female", "4", "11.6", "05-30-2022", "Canada", "untrained", false, "Canada", "12.5", "135", "150");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);       

    }


    //Intakes new dogs and adds them to dogList array
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                System.out.println("Please press enter to return to the main menu");
                scanner.nextLine();
                return;
            }
        }
        System.out.println("Please enter dog gender");
        gender = scanner.nextLine();
        System.out.println("Please enter dog breed");
        breed = scanner.nextLine();
        System.out.println("Please enter dog age");
        age = scanner.nextLine();
        System.out.println("Please enter dog weight");
        weight = scanner.nextLine();
        System.out.println("Please enter Today's date");
        acquisitionDate = scanner.nextLine();
        System.out.println("Please enter your country");
        country = scanner.nextLine();
        dogList.add(new Dog(name, breed, gender, age, weight, acquisitionDate, country, defaultTrainingStatus, defaultReserved, defaultServiceCountry));
        System.out.println(name + " has been added to our registry.\nPlease press enter to return to the main menu.");
        scanner.nextLine();
    }


        //Intakes new monkey with validation for existing monkeys and monkey type. Adds new monkey to monkeyList array.
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("Please enter monkey name");
            name = scanner.nextLine();
            //for loop checks for existing monkey names
            for (Monkey monkey: monkeyList){
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    System.out.println("Please press enter to return to the main menu");
                    scanner.nextLine();
                    return;
                }
            }
            System.out.println("Please enter monkey species");
            monkeySpecies = scanner.nextLine();
            //for loop checks for non case sensitive monkey species in the valid species array list
            validSpeciesSelection = false;
            for (String species: validSpecies){
                if (monkeySpecies.equalsIgnoreCase(species)){
                    validSpeciesSelection = true;
                    break;
                }
                else{
                    ;
                }
            }

            if (validSpeciesSelection){
                ;
            }
            else {
                System.out.println("\n\nMonkey species is not eligible for training.");
                System.out.println("\nPlease press enter to return to the main menu");
                scanner.nextLine();
                return;
            }

            System.out.println("Please enter monkey gender");
            gender = scanner.nextLine();
            System.out.println("Please enter monkey age");
            age = scanner.nextLine();
            System.out.println("Please enter monkey weight");
            weight = scanner.nextLine();
            System.out.println("Please enter Today's date");
            acquisitionDate = scanner.nextLine();
            System.out.println("Please enter your country");
            country = scanner.nextLine();
            System.out.println("Please enter monkey tail length");
            monkeyTailLength = scanner.nextLine();
            System.out.println("Please enter monkey height");
            monkeyHeight = scanner.nextLine();
            System.out.println("Please enter monkey body length");
            monkeyBodyLength = scanner.nextLine();

            monkeyList.add(new Monkey(name, monkeySpecies, gender, age, weight, acquisitionDate, country, defaultTrainingStatus, defaultReserved, 
            defaultServiceCountry, monkeyTailLength, monkeyHeight, monkeyBodyLength));
            System.out.println(name + " has been added to our registry.\nPlease press enter to return to the main menu.");
            scanner.nextLine();
        }

        //looks for unreserved animals of user specified type, and reserves the first available.
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Please specify the type of animal you would like to reserve");
            String userSpecies = scanner.nextLine();
            userSpecies.trim();
            System.out.println("Please specify the service country in which you would like to reserve and animal");
            String userCountry = scanner.nextLine();
            userCountry.trim();
            boolean foundAnimal = false;
                if (userSpecies.equalsIgnoreCase("monkey")){
                    for (Monkey monkey : monkeyList){
                        if (monkey.getReserved()){
                            ;
                        }
                        else {
                            if (monkey.getInServiceLocation().equalsIgnoreCase(userCountry)){
                                System.out.println(monkey.getName() + " has been reserved for your use.\nPlease press enter to return to the main menu");
                                monkey.setReserved(true);
                                foundAnimal = true;
                                scanner.nextLine();
                                break;
                            }
                        }
                    }
                }
                if (userSpecies.equalsIgnoreCase("dog")){
                    for (Dog dog : dogList){
                        if (dog.getReserved()){
                            ;
                        }
                        else {
                            if (dog.getInServiceLocation().equalsIgnoreCase(userCountry)){
                                System.out.println(dog.getName() + " has been reserved for your use.\nPlease press enter to return to the main menu");
                                dog.setReserved(true);
                                foundAnimal = true;
                                scanner.nextLine();
                                break;
                            }
                        }
                    }
                }
            if (!foundAnimal){
                System.out.println("No " + userSpecies + " is available in your service country");
            }
        }

        //menuChoice is set by the user choice in main, method prints dogs, monkeys or all un reserved animals based on case.
        public static void printAnimals(int menuChoice, Scanner scanner) {
            switch (menuChoice){
                case 4:
                    for (Dog dog: dogList){
                        System.out.print(dog.getName() + " ");
                    }
                    System.out.println("\nPlease press enter to return to the main menu");
                    scanner.nextLine();
                    break;
                
                case 5:
                    for(Monkey monkey: monkeyList){
                        System.out.print(monkey.getName() + " ");
                    }
                    System.out.println("\nPlease press enter to return to the main menu");
                    scanner.nextLine();
                    break;

                case 6:
                    for (Dog dog: dogList){
                        if (dog.getReserved()){
                            ;
                        }
                        else{
                            System.out.print(dog.getName() + " ");
                        }
                    }
                    for (Monkey monkey: monkeyList){
                        if (monkey.getReserved()){
                            ;
                        }
                        else{
                            System.out.print(monkey.getName() + " ");
                        }
                    }
                    System.out.println("\nPlease press enter to return to the main menu");
                    scanner.nextLine();
                    break;
                
                default:
                    break;
            }
        }
}

