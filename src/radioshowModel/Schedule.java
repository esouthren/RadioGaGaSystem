package radioshowModel;
import java.util.ArrayList;

/**
 * Class to store details of a Schedule of Radio Shows
 * @author Eilidh Southren - 1513195
 */
public class Schedule {
    
    private Person manager;
    private Show[] shows;
    private ArrayList<Presenter> presenters;
    private int currentShow = 0;

    public Schedule(Person manager) {
        this.manager = manager;
        this.shows = new Show[8];
        this.presenters = new ArrayList<>();
        setShowsInSchedule(); // line added for Part 3
        setSomePresenters();  // line added for Part 3
    }
    
    public Schedule() {
        this.manager = null;
        this.shows = new Show[8];
        this.presenters = new ArrayList<>();
        setShowsInSchedule();
        
    }
    
    // Code for initialising shows
    public void setShowsInSchedule(){
        String[] showNames = new String[]{
            "Midnight Hour",  "Early Hours", 
            "Breakfast Show", "Morning Show", 
            "Noon-til-Three", "Drive Time", 
            "Evening Show",   "Night Time"};
        for (int i = 0; i < shows.length; i++){
            boolean prime = (i==2 || i==3 || i==5);
            shows[i] = new Show(
                    showNames[i],new Presenter("Not Assigned", "", 0),
                    prime);
        }
    }
    
    // Code for presenters
    public void setSomePresenters(){
        presenters.add(new Presenter("Danny", "Diamond", 200));
        presenters.add(new Presenter("Garry", "B", 500));
        presenters.add(new Presenter("Vinyl", "Richie", 300));
        presenters.add(new Presenter("DJ Annie", "Max", 400));
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }
     
    public int getNumberPresenters(){
        return presenters.size();
    }
    
    public Presenter getPresenter(int i){
        return presenters.get(i);
    } 
    
    public ArrayList<Presenter> getPresenters() {
        return this.presenters;
    }
    
    public void addPresenter(Presenter dj){
        presenters.add(dj);
    }

    public Show getShow(int i){
        return shows[i];
    }
    
    public Show[] getShows() {
        return this.shows;
    }
    
    // Code for returning the currently selected show: added for Part 3
    public Show getCurrentShow(){
        return shows[currentShow];
    }
    
    // Code for assigning the currently selected show: added for Part 3
    public void setCurrentShow(int currentShow) {
        this.currentShow = currentShow;
    }

    @Override
    public String toString() {
        String str = "Schedule manager: " + this.manager.toString() + "\n";
        for(int i = 0; i < 8; i++) {
            str += shows[i].toString() +"\n";
        }
        return str;
    }
}
