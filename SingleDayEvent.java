import java.util.*;

/**
 * A child class of the abstract class Event, with the extra 
 * instance variable, date, as the event is only held on one day.
 *
 * @author (Danhui)
 * @version (Nov 7 2017)
 */
public class SingleDayEvent extends Event
{
    private SingleDate date;
    
    /**
     * Constructor for objects of class Event
     */
    public SingleDayEvent(String name, String singleDate, String location, String type, String orgList) {        
        super(name, location, type, orgList);
        try {
            this.date = new SingleDate(singleDate);
        } catch (NullPointerException e) {
            System.out.println("Date is required!");
        }
        this.hashKey = this.name.get()+this.date.toString();
        this.hashValue = computeHashValue(name, singleDate, location, type, orgList);
    }
      
    public static void main(String[] args) {
        SingleDayEvent testEvent = new SingleDayEvent("fun event", "11/07/2017", "Marquis", "fun", null);
        // String res = testEvent.getValue();
        // System.out.println(res);
        System.out.println(testEvent.hasLoc());        
    }

    public String getDate() {
        return date.toString();
    }
    
    /**
     * Check whether an event is a SingleDayEvent
     *
     * @param  nothing
     * @return  true since the event is only held on one day
     */  
    public boolean isSingleDayEvent() {
        return true;
    }
    
    public boolean withinQueryRange(String startDate, String endDate) {
        return date.withinRange(startDate, endDate);
    }

}
