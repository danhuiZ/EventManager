
/**
 * A child class of the abstract class Event, with the extra 
 * instance variable, range, as the event is held on multiple days.
 *
 * @author (Danhui)
 * @version (Nov 7 2017)
 */
public class MultiDayEvent extends Event
{
    private DateRange range;
    
    /**
     * Constructor for objects of class Event
     */
    // make eventDateRange a space separated date range string
    public MultiDayEvent(String name, String eventDateRange, String location, String type, String orgList) {
        super(name, location, type, orgList);
        try {            
            int spaceIndex = eventDateRange.indexOf(" ");
            String startDate = eventDateRange.substring(0, spaceIndex);
            String endDate = eventDateRange.substring(spaceIndex+1);        
            this.range = new DateRange(startDate, endDate);
        } catch (NullPointerException e) {
            System.out.println("Date is required!");
        }
        this.hashKey = this.name.get()+this.range.toCommaSeparatedString();
        eventDateRange = eventDateRange.replaceAll(" ", ", ");
        this.hashValue = computeHashValue(name, eventDateRange, location, type, orgList);
    }    
    
    public static void main(String[] args) {
        MultiDayEvent testEvent = new MultiDayEvent("fun event", "11/07/2017 11/09/2017", null, "fun", null);
        String res = testEvent.getValue();
        System.out.println(testEvent.getKey());            
        System.out.println(res);     
        System.out.println(testEvent);
        System.out.println(testEvent.withinQueryRange("11/06/2017", "11/10/2017"));   
        System.out.println(testEvent.withinQueryRange("11/07/2017", "11/10/2017"));  
        System.out.println(testEvent.withinQueryRange("11/9/2017", "11/10/2017"));   
        System.out.println(testEvent.withinQueryRange("11/9/2016", "11/10/2016"));          
    }
    
    public String getDate() {
        return range.toCommaSeparatedString().replaceAll(", ", " ");
    }
    
    public DateRange getDateRange() {
        return range;
    }
    
    /**
     * Check whether an event is a SingleDayEvent
     *
     * @param  nothing
     * @return  false since the event is held on multiple days
     */  
    public boolean isSingleDayEvent() {
        return false;
    }
    
    public boolean withinQueryRange(String startDate, String endDate) {
        return range.withinRange(startDate, endDate);
    }
     
}

