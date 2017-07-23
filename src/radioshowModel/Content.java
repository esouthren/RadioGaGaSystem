package radioshowModel;

/**
 * Class to store details of Radio Show Content that is produced elsewhere.
 * @author Eilidh Southren - 1513195
 */
public class Content extends TimeSlot{
    private boolean internallyProduced;
    private String description;

    public Content(int order, int seconds, String desc, boolean own) {
        super(order, seconds);
        this.description = desc;
        this.internallyProduced = own;
    }

    public boolean isInternallyProduced() {
        return internallyProduced;
    }

    public void setInternallyProduced(boolean internallyProduced) {
        this.internallyProduced = internallyProduced;
    }
    
    @Override
    public int calculateCost(){
        if(!internallyProduced) return 5 * getRuntime() / 60;
        else return 0;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    @Override
    public String toString() {
        return super.toString() + " . . . " + this.getDescription().trim() 
                + " . . . Cost: £" + this.calculateCost() ; 
    }
    
}
