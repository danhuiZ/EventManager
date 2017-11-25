import java.util.*;
import java.text.SimpleDateFormat;

/**
 * A class that contains Date String as keys and LinkedLists of hashKey of events as values. 
 * When an event spans multiple days, the hashKey of the event appears in the LinkedLists matching all days.
 *
 * @author (Danhui)
 * @version (Nov 11 2017)
 */
public class TreeMapContainer
{
    private TreeMap<String, LinkedListContainer> eventsByDates;
    private Experiment exp;

    /**
     * Constructor for objects of class TreeMapContainer
     */
    public TreeMapContainer(Experiment exp)
    {
        this.eventsByDates = new TreeMap<String, LinkedListContainer>();
        this.exp = exp;
    }

    /**
     * Loop through eventDB - database of events stored in hashmap to store in a TreeMap by dates as keys and LinkedList of hashKeys as values
     *
     * @param  nothing
     * @return  nothing
     */
    public void run() 
    {
        List<Event> eventDB = new ArrayList<Event>(this.exp.getMap().values());
        for(Iterator<Event> it = eventDB.iterator(); it.hasNext();) {
            Event temp = it.next();
            String tempKey = temp.getKey();
            if (temp.isSingleDayEvent()) {
                String tempDate = temp.getDate();
                if(!eventsByDates.containsKey(tempDate)) {
                    LinkedListContainer eventKeyLL = new LinkedListContainer(tempDate);
                    eventKeyLL.addKey(tempKey);
                    eventsByDates.put(tempDate, eventKeyLL);
                } else {
                    LinkedListContainer eventKeyLL = eventsByDates.get(tempDate);
                    eventKeyLL.addKey(tempKey);  
                    eventsByDates.put(tempDate, eventKeyLL);                    
                }
            } else {
                MultiDayEvent tempM = (MultiDayEvent)temp;
                Date startDate = tempM.getDateRange().getStart();
                Date endDate = tempM.getDateRange().getEnd(); 
                
                Calendar start = Calendar.getInstance();
                start.setTime(startDate);
                Calendar end = Calendar.getInstance();
                end.setTime(endDate);
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                for (Date date = start.getTime(); start.before(end) || start.equals(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                    String dateString = formatter.format(date);
                    if(!eventsByDates.containsKey(dateString)) {
                        LinkedListContainer eventKeyLL = new LinkedListContainer(dateString);
                        eventKeyLL.addKey(tempKey);
                        eventsByDates.put(dateString, eventKeyLL);
                    } else {
                        LinkedListContainer eventKeyLL = eventsByDates.get(dateString);
                        eventKeyLL.addKey(tempKey);  
                        eventsByDates.put(dateString, eventKeyLL);                    
                    }
                }
            }
        }
    }
    
    public TreeMap<String, LinkedListContainer> getTreeMap() {
        return eventsByDates;
    }
    
    /**
     * Check whether the TreeMap contains a certain dateString provided
     *
     * @param  dateString
     * @return   true if dateString given is a key in the TreeMap
     */
    public boolean containsKey(String dateString) {
        return eventsByDates.containsKey(dateString);
    }

    /**
     * Return LinkedListContainer given dateString as Key
     *
     * @param  dateString
     * @return  The LinkedListContainer value in the TreeMap
     */
    public LinkedListContainer getLLbyDate(String dateString) {
        return eventsByDates.get(dateString);
    }
}
