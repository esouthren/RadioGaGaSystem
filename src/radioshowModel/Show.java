
package radioshowModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

/**
 * Class to store details of a Radio Show.
 * @author Eilidh Southren - 1513195
 */

public class Show {
    private ArrayList<TimeSlot> items;
    private boolean primetime;
    private Presenter presenter; 
    private final String name;
    private static int totalTime = 3*60*60;
    
    // Constructor
    public Show(String name, Presenter dj, boolean prime) {
        this.name = name;
        this.presenter = dj;
        this.primetime = prime;
        items = new ArrayList<>();
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter dj) {
        this.presenter = dj;
    }

    public ArrayList<TimeSlot> getItems() {
        return items;
    }
    
    public int getNumItems() {
        return items.size();
    }
    
    public TimeSlot getTimeSlot(int i) {
        return items.get(i);
    }

    public void addTimeSlot(TimeSlot ts){
        items.add(ts);
    }
    
    public void addTimeSlot(TimeSlot ts, int i){
        items.add(i,ts);
    }
    
    public void removeTimeSlot(TimeSlot ts){
        items.remove(ts);
    }

    public boolean isPrimetime() {
        return primetime;
    }

    public void setPrimetime(boolean primetime) {
        this.primetime = primetime;
    }
    
    public String getRunningSchedule(){
        String rs = "";
        for(int i = 0 ; i < items.size() ; i++){
            rs += items.get(i).toString() + "\n";
        }
        return rs;
    }
    
    public int getRunningTime(){
        int time = 0;
        for(TimeSlot ts: items){
            time += ts.getRuntime();
        }
        return time;
    }
    
    public int getTimeRemaining(){
        return totalTime - getRunningTime();
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
   
    public void readFromFile(File f){
        // delete previous items
        this.items.clear();
        
        try {
            Scanner s = new Scanner(f);
            s.useDelimiter(",|\n");
            int numberOfItems = s.nextInt();
            boolean isPrimetime = s.nextBoolean();
            this.setPrimetime(isPrimetime);
            int fee = s.nextInt();
            Presenter newDJ = new Presenter(s.next(), s.next(), fee);           
            this.setPresenter(newDJ);    
            // For each Item
            for (int i = 0; i < numberOfItems; i++){
                // Read description and runtime and type
                char type = s.next().charAt(0);
                int order = s.nextInt();
                int runtimeOfItem = s.nextInt();    
                // content then depends on type
                    if (type == 'A'){
                        String client = s.next();                       
                        Advert item = new Advert(order,runtimeOfItem,client,isPrimetime);
                        this.addTimeSlot(item);
                        System.out.println(item);
                    } else if (type == 'M'){
                        String artist = s.next();
                        String song = s.next();
                        Music item = new Music(order,runtimeOfItem,artist,song);
                        this.addTimeSlot(item);
                        System.out.println(item);
                    } else if (type == 'T'){
                        String guests = s.next();
                        Talk item = new Talk(order,runtimeOfItem,guests);
                        this.addTimeSlot(item);
                        System.out.println(item);
                    } else if (type == 'C'){
                        String description = s.next();
                        Content item = new Content(order,runtimeOfItem,description,false);
                        this.addTimeSlot(item);
                        System.out.println(item);
                    }
            }
            s.close();
        } catch (FileNotFoundException ex) {}
        
    }
    
    public void sortItems(){
        Collections.sort(items);
    }
    
    // Saving data to file
    public void saveToFile(File f){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(this.getNumItems() + "");
            System.out.println(this.getNumItems());
            bw.write("," + this.isPrimetime());
            bw.write("," + this.getPresenter().getFee() + ","  
                    + this.getPresenter().getFirstName() + ","
                    + this.getPresenter().getSecondName() 
                    );
            System.out.println(this.getPresenter().getSecondName());
            bw.newLine();
            for (int i = 0; i < this.getItems().size(); i++){
                TimeSlot t = this.getTimeSlot(i);
                if (t instanceof Advert){
                        bw.write("A," + t.getRunningOrder() + "," 
                        + t.getRuntime() + "," 
                        +((Advert) t).getClient());
                    } else if (t instanceof Music){
                        bw.write("M," + t.getRunningOrder() + "," 
                        + t.getRuntime() + "," 
                        + ((Music) t).getArtist() + "," + ((Music) t).getSongTitle());
                    } else if (t instanceof Talk){
                        bw.write("T," + t.getRunningOrder() + "," 
                        + t.getRuntime() + "," + ((Talk) t).getGuest());
                    } else if (t instanceof Content){
                        bw.write("C" + "," + t.getRunningOrder() + "," 
                        + t.getRuntime() + "," + ((Content)t).getDescription());
                    }
                
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception ex) {}
        
    }
    
    
    
    public void sortItemsByOrder(){
        items.sort(new OrderComparator());
    } 
    
    // Aditional method for sorting Show TimeSlots by RunTime: added for Part 3
    public void sortItemsByRuntime(){
        items.sort(new RuntimeComparator());    
    }    
}
