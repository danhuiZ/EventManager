import java.util.*;
import java.io.*;

/**
 * Reads event information from the input file
 * Need to make sure input file has a blank line in the end
 *
 * @author (Danhui)
 * @version (Nov 8 2017)
 */
public class MyFileReader
{
    private List<Event> readInEvents;
    private String inputFileName;
    /**
     * Constructor for objects of class MyFileReader
     */
    public MyFileReader(String inputFileName)
    {
        this.readInEvents = new LinkedList<>();
        this.inputFileName = inputFileName;
    }

    /**
     * Initialize the file reader
     *
     * @param  nothing
     * @return  nothing
     */
    public void initialize() {
        Scanner inputFile;
        String[] line;
        Event anEvent;
        String name = null;
        String date = null;
        String location = null;
        String type = null;        
        String organization = null;

        try {
            inputFile = new Scanner(new FileReader(inputFileName));
            while(inputFile.hasNextLine()){
                line = inputFile.nextLine().split(": ");
                switch(line[0].toLowerCase()) {
                    case "name": name = line[1];
                                break;
                    case "date": date = line[1];      
                                break;                 
                    case "location": location = line[1];
                                break;                    
                    case "type": type = line[1];  
                                break;                    
                    case "organization": organization = line[1];
                                break;
                    default: if (date.indexOf(" ")>0) {    // MultiDayEvent expected
                                 anEvent = new MultiDayEvent(name, date, location, type, organization);
                                 // System.out.println("1" + anEvent);
                             } else {    // SingleDayEvent expected
                                 anEvent = new SingleDayEvent(name, date, location, type, organization);            
                                 // System.out.println("2" + anEvent);                                                              
                             }
                             readInEvents.add(anEvent);
                             name = null;
                             date = null;
                             location = null;
                             type = null;        
                             organization = null;
                             break;            
                }
            }            
            // System.out.println(readInEvents);            
        } catch (Exception e) {
            System.out.println("Error occurred in FileReader: " + e);
            e.printStackTrace();
        }
    }
    
    public List<Event> getEvents() {
        return readInEvents;
    }
}
