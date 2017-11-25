import java.util.*;

/**
 * Constructor and methods for organizations of an event, there can be multiple organizations for one event.
 *
 * @author (Danhui)
 * @version (Nov 4 2017)
 */
public class Organizer
{
    private ArrayList<String> eventOrgs;
    private String orgs;

    /**
     * Constructor for objects of class Type
     */
    public Organizer(String listOfOrgs) {
        this.orgs = listOfOrgs;
        String[] orgArray = listOfOrgs.split("\\s*,\\s*");
        List<String> listOrgs = new ArrayList<String>(Arrays.asList(orgArray));
        this.eventOrgs = (ArrayList<String>)listOrgs;
    }    
    public Organizer()
    {
        this.orgs = null;        
        this.eventOrgs = new ArrayList<>(0);
    }    
    
    public ArrayList<String> get() {
        return eventOrgs;
    }
    public String getOrgString() {
        return orgs;
    }    
    
    public void set(String eventOrgs) {
        String[] orgArray = eventOrgs.split("\\s*,\\s*");
        List<String> listOrgs = new ArrayList<String>(Arrays.asList(orgArray));
        this.eventOrgs = (ArrayList<String>)listOrgs;        
    }

    /**
     * This method shows whether a given organization name shows up in an event's organizer list
     *
     * @param  oneOrg  name of one organization
     * @return  boolean  This shows whether the list of organizers contains given organization
     */    
    public boolean contains(String oneOrg) {
        int index = -1;
        // iterate to see whether the one organization exists in the organizer list
        for(Iterator<String> i=eventOrgs.iterator(); i.hasNext();) {
            index += 1;
            if(i.next().equalsIgnoreCase(oneOrg)) return true;
        }
        return false;
    }
}
