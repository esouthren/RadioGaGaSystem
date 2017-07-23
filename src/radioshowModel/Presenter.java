
package radioshowModel;

/**
 * Class to store details of a Presenter of a Radio Show.
 * @author Eilidh Southren - 1513195
 */
public class Presenter extends Person {
    private int fee;

    public Presenter(String fname, String sname, int fee) {
        super(fname,sname);
        this.fee = fee;
    }    
    
    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
    
    @Override
    public String toString() {
       return this.getFullName() + " -- Fee: £" + this.getFee();
    }
       
}
