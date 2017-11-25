import java.util.*;

/**
 * A class for one experiment, read one input file and write to one output file
 *
 * @author (Danhui)
 * @version (Nov 8 2017)
 */
public class Experiment
{
    private Map<String, Event> map;
    private String inputFileName;    
    private String outputFileName;

    /**
     * Constructor for objects of class Experiment
     */
    public Experiment(String inputFileName, String outputFileName)
    {
        map = new HashMap<String, Event>();  
        this.inputFileName = inputFileName;        
        this.outputFileName = outputFileName;
    }  
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Map<String, Event> getMap() {
        return map;
    }
    
    public void run() {
        readEventsFromFile(inputFileName);
        readEventsFromCLI();
    }
    
    private void readEventsFromFile(String fileName) {
        MyFileReader reader = new MyFileReader(fileName);
        reader.initialize();
        ListIterator<Event> i = reader.getEvents().listIterator(0);
        while(i.hasNext()) {
            Event temp = i.next();
            String key = temp.getKey();
            Event value = temp;
            map.put(key, value);
        }
        // List<Event> listOfEvents = new ArrayList<Event>(map.values());
        // System.out.println(listOfEvents);        
    }
    
    private void readEventsFromCLI() {
        EventHandler CLI = new EventHandler(this, outputFileName);
        CLI.run();
    }    
    
    public void writeToFile(String fileName) {
        MyFileWriter fileWriter = new MyFileWriter(fileName, this);
    }    
}
