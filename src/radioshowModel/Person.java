
package radioshowModel;

/**
 * Class to store details of a Person
 * @author Eilidh Southren - 1513195
 */
public class Person {
    
    private final String firstName;
    private final String secondName;

    // Constructor
    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    
    public String getFullName() {
        return firstName + " " + secondName;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName;
    }    
}
