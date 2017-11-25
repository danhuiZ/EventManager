import java.util.*;

/**
 * Abstract class Event - parent class of both SingleDayEvent and MultiDayEvent
 *
 * @author (Danhui)
 * @version (Nov 6, 2017)
 */
public abstract class Event
{
     // instance variables - replace the example below with your own
    protected Name name;
    protected Location location;
    protected Type type;
    protected Organizer orgs;
    protected String hashKey;
    protected String hashValue;
    
    /**
     * Constructor for objects of class Event
     */
    public Event(String name, String location, String type, String orgList) {
        try {
            this.name = new Name(name);
        } catch (NullPointerException e) {
            System.out.println("Name is required!");
        }
        if (location != null)  this.location = new Location(location);
        else {this.location = null;}        
        if (type != null)  this.type = new Type(type);
        else {this.type = null;}
        if (orgList != null)  this.orgs = new Organizer(orgList);        
        else {this.orgs = null;}
    }
    // public Event() {
        // this.name = null;
        // this.location = null;
        // this.type = null;
        // this.orgs = null;
    // }
    // public Event(Name name, Location location, Type type, Organizer organization) {
        // this.name = name;
        // this.location = location;
        // this.type = type;
        // this.orgs = organization;
    // }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getName() {
        return name.get();
    }    
    public void setName(String newName) {
        name.set(newName);
    }
    
    public abstract String getDate();  
    
    public String getLoc() {
        return location.get();
    }    
    public void setLoc(String newLoc) {
        location.set(newLoc);
    }    
    public boolean hasLoc() {
        return (location != null);
    }
    
    public String getType() {
        return type.get();
    }    
    public void setType(String newType) {
        type.set(newType);
    }    
    public boolean hasType() {
        return (type != null);
    }   
    
    public String getOrgs() {
        return orgs.getOrgString();
    }    
    public void setOrgs(String newOrgs) {
        orgs.set(newOrgs);
    }      
    public boolean hasOrgs() {
        return (this.orgs != null);
    }
    
    public String getKey() {
        return hashKey;
    }
    public String getValue() {
        return hashValue;
    }
    
    protected String computeHashValue(String name, String dateOrRange, String location, String type, String orgList) {
        ArrayList<String> valueList = new ArrayList<>();
        
        valueList.add("name");
        valueList.add(name); 
        valueList.add("date");
        valueList.add(dateOrRange);
        if (location != null) {
            valueList.add("location");
            valueList.add(location);
        } else {
            this.location = null;
        }
        if (type != null) {
            valueList.add("type");
            valueList.add(type);
        } else {
            this.type = null;
        }
        if (orgList != null) {
            valueList.add("organization");
            valueList.add(orgList);
        } else {
            this.orgs = null;
        } 
        String temp = Arrays.toString(valueList.toArray());
        String computedValue = temp.substring(1, temp.length()-1);
        return computedValue;
    }
    
    public abstract boolean withinQueryRange(String startDate, String endDate);
    
    public abstract boolean isSingleDayEvent();
    
    public String toString() {
        return "\nKey: " + this.hashKey + "\nValue: " + this.hashValue;
    }

}
