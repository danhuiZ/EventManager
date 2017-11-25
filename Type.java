
/**
 * Constructor and methods for type of an event, type can be anything.
 *
 * @author (Danhui)
 * @version (Nov 4 2017)
 */
public class Type
{
    private String eventType;

    /**
     * Constructor for objects of class Type
     */
    public Type()
    {
        this.eventType = null;
    }    
    public Type(String eventType)
    {
        this.eventType = eventType;
    }

    public String get() {
        return eventType;
    }
    
    public void set(String eventType) {
        this.eventType = eventType;
    }
    
    /**
     * Check whether type matches
     *
     * @param  type
     * @return  true if matches
     */
    public boolean match(String type) {
        return eventType.equalsIgnoreCase(type);
    }    
}
