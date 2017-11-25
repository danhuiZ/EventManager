import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Constructor and methods for date of an event, if the event is only held on one day.
 *
 * @author (Danhui)
 * @version (Nov 4 2017)
 */
public class SingleDate
{
    private Date eventDate;

    /**
     * Constructor for objects of class Date
     */
    public SingleDate()
    {
        this.eventDate = null;
    }

    public SingleDate(String dateString)
    {
        this.eventDate = new Date(dateString);
    }
    
    public Date get() {
        return eventDate;
    }
    public void set(Date date) {
        this.eventDate = date;
    }
    
    /**
     * Override toString method
     *
     * @param  none 
     * @return  String representing the date
     */
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(this.eventDate);
    }
    
    public boolean withinRange(String startDateQuery, String endDateQuery) {
        Date start = new Date(startDateQuery);
        Date end = new Date(endDateQuery);
        return (this.eventDate.after(start) || this.eventDate.equals(start)) && (this.eventDate.before(end) || this.eventDate.equals(end));
    }

    /**
     * Method to determine whether date matches with input parameter
     *
     * @param  dateString  a provided date
     * @return  true if date matches, false if not
     */
    public boolean match(String queryDate) {
        Date query = new Date(queryDate);
        return this.eventDate.equals(query);
    }
}
