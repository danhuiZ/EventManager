import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Constructor and methods for dates of an event, if the event is held on multiple dates.
 *
 * @author (Danhui)
 * @version (Nov 4 2017)
 */
public class DateRange
{
    private Date startDate;
    private Date endDate;

    /**
     * Constructor for objects of class DateRange
     */
    public DateRange()
    {
        this.startDate = null;
        this.endDate = null;
    }
    public DateRange(String startDateStr, String endDateStr)
    {
        this.startDate = new Date(startDateStr);
        this.endDate = new Date(endDateStr);
    }
      
    public Date getStart() {
        return startDate;
    }
    public Date getEnd() {
        return endDate;
    }    
    public void setStart(Date start) {
        this.startDate = start;
    }
    public void setEnd(Date end) {
        this.endDate = end;
    }   
    
    public boolean withinRange(String startDateQuery, String endDateQuery) {
        Date start = new Date(startDateQuery);    
        Date end = new Date(endDateQuery);
        return (this.endDate.after(start) || this.endDate.equals(start)) && (this.startDate.before(end) || this.startDate.equals(end));
    }
    
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return "From " + formatter.format(this.startDate) + " to " + formatter.format(this.endDate);
    }
    
    /**
     * Convert dateString to a comma separated string
     *
     * @param  none
     * @return  comma-separated two date strings representing a date range
     */      
    public String toCommaSeparatedString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(this.startDate) + ", " + formatter.format(this.endDate);
    }
    
    
}
