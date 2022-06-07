
import java.util.ArrayList;

public class Monkey extends RescueAnimal{
    // Instance variable
    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;

    // Constructor
    public Monkey(String name, String species, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry, String tail, String height, String body) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tail);
        setHeight(height);
        setBodyLength(body);

    }

    // Accessor Method
    public String getSpecies() {
        return species;
    }
    
    public String getTailLength(){
        return tailLength;
    }

    public String getHeight(){
        return height;
    }

    public String getBodyLength(){
        return bodyLength;
    }

    // Mutator Method
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }

    public void setTailLength(String tail){
        tailLength = tail;
    }

    public void setHeight(String monkeyHeight){
        height = monkeyHeight;
    }

    public void setBodyLength(String body){
        bodyLength = body;
    }

}
