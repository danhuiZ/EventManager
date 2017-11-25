
/**
 * Constructor and methods for location of an event.
 *
 * @author (Danhui)
 * @version (Nov 4 2017)
 */
public class Location
{
    // instance variables - replace the example below with your own
    private String eventLoc;

    /**
     * Constructor for objects of class Location
     */
    public Location()
    {
        eventLoc = null;
    }
    public Location(String location)
    {
        eventLoc = location;
    }
    
    public String get() {
        return eventLoc;
    }
    public void set(String location) {
        this.eventLoc = location;
    }

    /**
     * Check whether location matches
     *
     * @param  location
     * @return  true if matches
     */
    public boolean match(String location) {
        return eventLoc.equalsIgnoreCase(location);
    }
    
}
