
/**
 * Constructor and methods for name of an event.
 *
 * @author (Danhui)
 * @version (Nov 4 2017)
 */
public class Name implements Comparable<Name>
{
    // instance variables
    private String eventName;

    /**
     * Constructor for objects of class Name
     */
    public Name()
    {
        this.eventName = null;
    }    
    public Name(String eventName)
    {
        this.eventName = eventName;
    }

    public String get() {
        return eventName;
    }
    
    public void set(String newName) {
        this.eventName = newName;
    }
    
    public int compareTo(Name otherEvent) {
        if (this.eventName.compareToIgnoreCase(otherEvent.get()) < 0) return -1;
        else if (this.eventName.compareToIgnoreCase(otherEvent.get()) == 0) return 0;
        else return 1;    
    }
    
     /**
     * Method to determine whether name matches with input parameter
     *
     * @param  name  a provided name
     * @return    true if name matches, false if not
     */
    public boolean match(String name) {
        return eventName.equalsIgnoreCase(name);
    }
}
