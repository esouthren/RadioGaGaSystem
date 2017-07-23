
package radioshowModel;

/**
 * Class to store details of a Radio Advert.
 * @author Eilidh Southren - 1513195
 */
public class Advert extends TimeSlot{
    
    private String client;
    private boolean primetime;

    public Advert(int order, int seconds, String client, boolean prime) {
        super(order, seconds);
        this.client = client;
        this.primetime = prime;
    }
    // Getters
    public String getClient() {
        return client;
    }
    // Setters
    public void setClient(String client) {
        this.client = client;
    }
    public void setPrimetime(boolean primetime) {
        this.primetime = primetime;
    }
    
    public boolean isPrimetime() {
        return primetime;
    }
    
    @Override
    public int calculateCost(){
        if (this.primetime)
            return 50;
        else 
            return 25;
    }

    @Override
    public String toString() {
        String str = super.toString() + " . . . Advert . . . . . . Income: £" +
                calculateCost() + " . . . Client: " + this.getClient();
        return str;
    }   
    
}
