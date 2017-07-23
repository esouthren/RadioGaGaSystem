package radioshowModel;
/**
 * An abstract class to store information about a radio time slot
 * @author Eilidh Southren - 1513195
 */
public abstract class TimeSlot implements Comparable<TimeSlot>{
    
    private int runningOrder;
    private int runtime;
    
    // Constructor
    public TimeSlot(int order, int seconds) {
        this.runningOrder = order;
        this.runtime = seconds;
    }

    // Getters
    public int getRunningOrder() {
        return runningOrder;
    }
  
    public int getRuntime() {
        return runtime;
    }
    
    // Setters
    public void setRunningOrder(int runningOrder) {
        this.runningOrder = runningOrder;
    }    
 
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    } 
   
    public abstract int calculateCost();

    // toString for displaying info in Timeslot List Window
    @Override
    public String toString() {
        
        String seconds = String.valueOf(this.getRuntime()%60);
        String minutes = String.valueOf(this.getRuntime()/60);
        
        // Pad values for better formatting
        String pad = "[";
        if (this.getRuntime()%60 == 0) {
            seconds = "00";
        } 
        if (seconds.length() == 1) {
            seconds += 0;
        }
        if (minutes.length() == 1) {
            minutes = "0" + minutes;
        }
        if (this.getRunningOrder() < 10) {
            pad = "[0";
        }
        return  pad + this.getRunningOrder() + "] . " + minutes + ":" + seconds;
    }

    public int compareTo(TimeSlot o) {
        if (this.getRuntime() < o.getRuntime()){
            return -1;
        } else if (this.getRuntime() > o.getRuntime()){
            return +1;
        } else {
            return 0;
        }
    }   
}
