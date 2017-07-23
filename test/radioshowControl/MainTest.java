/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radioshowControl;


import radioshowModel.Advert;
import radioshowModel.Content;
import radioshowModel.Music;
import radioshowModel.Person;
import radioshowModel.Presenter;
import radioshowModel.Schedule;
import radioshowModel.Show;
import radioshowModel.Talk;

import radioshowGUI.MainGui;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eilidh
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {

        String[] args = null;
        Main.main(args);
        System.out.println(">>Test Cases of Methods<<\n");
        
        // 'Schedule' Class Tests
        Schedule schedule = new Schedule();
        Person person = new Person("Mr", "Manager");
        schedule.setManager(person);
        
        System.out.println(">> Testing Schedule: setManager() and getManager()");
        System.out.println("Expected Result: Mr Manager");
        System.out.println("Outputted Result: " + schedule.getManager());
        System.out.println(">>");
        System.out.println(">> Testing Schedule: getNumberPresenters()");
        System.out.println("Expected Result: 0");
        System.out.println("Outputted Result: " + schedule.getNumberPresenters());
        System.out.println(">>");
        System.out.println(">> Testing Schedule: add/get Presenter");
        schedule.addPresenter(new Presenter("Danny", "Diamond", 100));
        System.out.println("Expected Result: Danny Diamond, Fee: £100");
        System.out.println("Outputted Result: " + schedule.getPresenter(0));
        System.out.println(">>");
        System.out.println(">> Testing Schedule: getShow(int)");
        System.out.println("Expected Result: 'Midnight Hour'");
        System.out.println("Outputted Result: " + schedule.getShow(0));
        System.out.println(">>");
        System.out.println(">> Testing Schedule: set/get Current Show");
        System.out.println("Expected Result: 'Early Morning'");
        schedule.setCurrentShow(1);
        System.out.println("Outputted Result: " + schedule.getCurrentShow());
        System.out.println(">>");
        System.out.println("Testing toString(): ");
        System.out.println("Output: " + schedule.toString());
        
        // 'Show' Class Tests
        Show testShow = schedule.getShow(0);
        System.out.println(">> Testing Show: getName()");
        System.out.println("Expected Result: Midnight Hour");
        System.out.println("Outputted Result: " + testShow.getName());
        System.out.println(">>");
        System.out.println(">> Testing Show: set/getPresenter()");
        testShow.setPresenter(new Presenter("Obi", "Wan Kenobi", 1000));
        System.out.println("Expected Result: Obi Wan Kenobi, fee: £1000");
        System.out.println("Outputted Result: " + testShow.getPresenter());
        System.out.println(">>");
        testShow.addTimeSlot(new Advert(4,60,"Companion Droids",true)); // primetime
        testShow.addTimeSlot(new Talk(5,300,"Mark Hamill"));
         Music m1 = (new Music(6,600,"The Cantina Band","Jabba's Tune"));
        testShow.addTimeSlot(m1);
        System.out.println(">> Testing Show: getNumItems()");
        System.out.println("Expected Result: 3");
        System.out.println("Outputted Result: " + testShow.getNumItems());
        System.out.println(">>");
        System.out.println(">> Testing Show: add/get Timeslot");
        System.out.println("Expected Result: [05] . 05:00 . . . Talk . . . Cost: £0 . . . Guests: Mark Hamill ");
        System.out.println("Outputted Result: " + testShow.getTimeSlot(1));
        System.out.println(">>");
        System.out.println(">> Testing Show: removeTimeSlot and getRunningSchedule()");
        System.out.println("Before removing timeslot:");
        System.out.println(testShow.getRunningSchedule());
        testShow.removeTimeSlot(m1);
        System.out.println("After removing timeslot");
        System.out.println(testShow.getRunningSchedule());
        System.out.println(">>");
        System.out.println(">> Testing Show: getRunningtime() and getTimeRemaining()");
        System.out.println("Expected Result: 360, 10440");
        System.out.println("Outputted Result: " + testShow.getRunningTime()+ ", " +testShow.getTimeRemaining());
        System.out.println(">>");
        // 'Talk' Class Test
        Talk testTalk = new Talk(2, 1000, "");
        System.out.println(">> Testing Talk: set/get guest");
        testTalk.setGuest("Storm Trooper #2132"); 
        System.out.println("Expected Result: Storm Trooper #2132");
        System.out.println("Outputted Result: " + testTalk.getGuest());
        System.out.println(">>");
        System.out.println(">> Testing Talk: calculateCost()");
        System.out.println("Expected Result: 0");
        System.out.println("Outputted Result: " + testTalk.calculateCost());
        System.out.println(">> Testing Talk: toString()");
        System.out.println("Output: " + testTalk.toString());
        System.out.println(">>");
        System.out.println(">> Testing Talk: set/get runningTime and runningOrder");
        testTalk.setRuntime(2000);
        testTalk.setRunningOrder(10);
        System.out.println("Expected Result: 2000, 10");
        System.out.println("Outputted Result: " + testTalk.getRuntime() + ", " + testTalk.getRunningOrder());
        System.out.println(">>");
        // 'Presenter' Class Test
        Presenter testPres = new Presenter("Han", "Solo", 140);
        System.out.println(">> Testing Presenter: set/get fee");
        testPres.setFee(200);
        System.out.println("Expected Result: 200");
        System.out.println("Outputted Result: " + testPres.getFee());
        System.out.println(">>");
        System.out.println("Testing Presenter: toString()");
        System.out.println("Output: " + testPres.toString());
        
        // 'Person' Class Test
        System.out.println(">>");
        Person testPerson = new Person("Leia", "Organa");
        System.out.println(">>");
        System.out.println(">> Testing Person: get first/second/full name");
        
        System.out.println("Expected Result: 'Leia;, 'Organa', 'Leia Organa'");
        System.out.println("Outputted Result: " + testPerson.getFirstName() + ", "+ testPerson.getSecondName() + ", " + testPerson.getFullName());
        
        // 'Content' Class Test
        Content testContent = new Content(1, 180, "Rebellion News Update", true);
        testContent.setInternallyProduced(false);
        System.out.println(">>");
        System.out.println("Testing Content: set/get internallyProduced");
        System.out.println("Expected Result: false");
        System.out.println("Outputted Result: " + testContent.isInternallyProduced());
        System.out.println(">>");
        System.out.println("Testing Content: calculate cost");
        System.out.println("Expected Result: 15");
        System.out.println("Outputted Result: " + testContent.calculateCost());
        System.out.println(">>");
        System.out.println("Testing Content: getDescription()");
        System.out.println("Expected Result: Rebellion News Update");
        System.out.println("Outputted Result: " + testContent.getDescription());
        System.out.println(">>");
        System.out.println("Testing Content: toString()");
        System.out.println("Output: " + testContent.toString());
        
        System.out.println(">>");
        System.out.println("Testing Music: set/get artist and songtitle");
        m1.setArtist("Jakku Jazz Trio");
        m1.setSongTitle("Funky Jedi");
        System.out.println("Expected Result: Jakku Jazz Trio, Funky Jedi");
        System.out.println("Outputted Result: " + m1.getArtist() + ", " + m1.getSongTitle());
        System.out.println(">>");
        System.out.println("Testing Music: calculatecost()");
        System.out.println("Expected Output: 20");
        System.out.println("Outputted Result: " + m1.calculateCost());
        System.out.println(">>");
        System.out.println("Testing Music: toString()");
        System.out.println("Output: " + m1.toString());
        
        Advert a1 = new Advert(1, 30, "", false);
        Advert a2 = new Advert(1, 60, "Tatooine Tattoo Parlour", false);
        System.out.println(">>");
        System.out.println("Testing Advert: get/set client");
        a1.setClient("Hutt Enterprises");
        System.out.println("Expected Result: Hutt Enterprises");
        System.out.println("Outputted Result: " + a1.getClient());
        System.out.println(">>");
        System.out.println("Testing Advert:set / get Primetime");
        a1.setPrimetime(true);
        System.out.println("Expected Result: true");
        System.out.println("Outputted Result: " + a1.isPrimetime());
        System.out.println(">>");
        System.out.println("Testing Advert: Calculate Cost (primetime)");
        System.out.println("Expected Output: 25");
        System.out.println("Outputted result: " + a1.calculateCost());
        System.out.println(">>");
        System.out.println("Testing Advert: Calculate Cost (not primetime)");
        System.out.println("Expected Output: 50");
        System.out.println("Outputted result: " + a2.calculateCost());
        System.out.println(">>");
        System.out.println("Testing Advert: toString()");
        System.out.println("Output: " + a1.toString());
        Music m2 = new Music(2, 180, "Jedi Force 5", "Falcon Funk");    
        // Testing Comparators
        System.out.println(">>");
        System.out.println("Testing Comparators: Sort Items by Runtime");
        System.out.println("Should be +1: "
                + m1.compareTo(m2));
        System.out.println("Should be -1: "
                + m1.compareTo(m2));
        System.out.println("Should be 0: "
                + m1.compareTo(m2));
        System.out.println(">>");
        testShow.addTimeSlot(m1);
        testShow.addTimeSlot(m2);
        testShow.addTimeSlot(testTalk);
    
        testShow.addTimeSlot(testContent);
        testShow.addTimeSlot(a2);
        testShow.addTimeSlot(m2); 
        // display "before" order
        System.out.println("Before sort: " + testShow.getRunningSchedule());
        // sort and then re-display "after" order
        testShow.sortItemsByOrder();
        System.out.println("After sorting by Order: " + testShow.getRunningSchedule());
        System.out.println(">>");
        System.out.println("Test Comparators: Sort Items by Run Time");
        testShow.sortItemsByRuntime();
        System.out.println("After sorting by run time" + testShow.getRunningSchedule());
        
     
        
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
