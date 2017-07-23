package radioshowControl;

import javax.swing.UIManager;
import radioshowModel.Advert;
import radioshowModel.Content;
import radioshowModel.Music;
import radioshowModel.Person;
import radioshowModel.Presenter;
import radioshowModel.Schedule;
import radioshowModel.Show;
import radioshowModel.Talk;

import radioshowGUI.MainGui;
/**
 *
 * @author Eilidh Southren 1513195
 * Radio Dhow Coursework
 */
public class Main {

    public static void main(String[] args) {
        
        // Set look and feel of program
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
        ex.printStackTrace(); 
        }
        
        Schedule schedule = new Schedule(new Person("Biggie", "Boss"));
        MainGui g = new MainGui(schedule);
        g.setVisible(true);
        
        // Set some data to display in window
        
        Content c1 = new Content(1,180,"Weather",false); // externally produced
        Content c2 = new Content(2,180,"Weather",true); // internally produced

        Advert a1 = new Advert(3,30,"Werthers Original",false); //non-primetime
        Advert a2 = new Advert(4,60,"Twix",true); // primetime

        Talk t1 = new Talk(5,300,"Tony Soprano");

        Music m1 = new Music(6,331,"Rolling Stones","Gimme Shelter");

        schedule.setManager(new Person("Alan","Sugar"));

        schedule.addPresenter(new Presenter("Davey","L",100));
        schedule.addPresenter(new Presenter("Billy","Bob",200));
   
        Presenter p1 = new Presenter("Garry", "Pressy", 400);
        schedule.getShow(1).setPresenter(p1);
       
        schedule.getShow(1).addTimeSlot(c2);
        schedule.getShow(1).addTimeSlot(c1);
        schedule.getShow(1).addTimeSlot(a1);
        schedule.getShow(1).addTimeSlot(a2);
        schedule.getShow(1).addTimeSlot(t1);
        schedule.getShow(1).addTimeSlot(m1);

    }
}
