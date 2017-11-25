import java.util.*;

/**
 * The Container of a LinkedList of hashKeys of events stored in the hashMap
 *
 * @author (Danhui)
 * @version (Nov 11 2017)
 */
public class LinkedListContainer implements Comparable<LinkedListContainer>
{
    // instance variables - replace the example below with your own
    private String dateString;
    private LinkedList<String> hashKeyList;
    /**
     * Constructor for objects of class LinkedListContainer
     */
    public LinkedListContainer(String dateString)
    {
        this.dateString = dateString;
        this.hashKeyList = new LinkedList<String>();
    }

    /**
     * Add a hashKey of an event to the LinkedList for the particular dateString
     *
     * @param  eventKey the hashKey String of an event
     * @return  nothing
     */
    public void addKey(String eventKey)
    {
        this.hashKeyList.add(eventKey);
    }

    /**
     * Get the dateString matching this LinkedList of event hashKeys
     *
     * @param  nothing
     * @return  dateString
     */
    public String getDateString() {
        return dateString;
    }
    
    /**
     * Get the LinkedList of hashKeys
     *
     * @param  nothing
     * @return  LinkedList of Strings
     */    
    public LinkedList<String> getKeyList() {
        return hashKeyList;
    }

    
    @Override
    public int compareTo(LinkedListContainer dateLL) {
        return this.dateString.compareTo(dateLL.getDateString());
    }
}
