package radioshowModel;

/**
 * Class to store details of a Radio Talk segment.
 * @author Eilidh Southren - 1513195
 */
public class Talk extends Content {
    
    String guest;
   
    // Constructor
    public Talk(int order, int seconds, String guests) {
        super(order, seconds, "Talk", true);
        if (guests.trim().length() == 0){
            guest = "none";
        }
        else{
            guest = guests;
        }
    }
    // Getters
    public String getGuest() {
        return guest;
    }
    // Setters
    public void setGuest(String guest) {
        this.guest = guest;
    }
    
    @Override
    public int calculateCost() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " . . . Guests: " + guest;
    }  
}
