import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Handles command line input from the user.
 *
 * @author (Danhui)
 * @version (Nov 11 2017)
 */
public class EventHandler
{
    private List<Event> userEvents;
    private Experiment exp;
    private ArrayList<Event> foundEvents;
    private String outputFileName;
       
    /**
     * Constructor for objects of class EventHandler
     */
    public EventHandler(Experiment exp, String outputFile)
    {
        this.userEvents = new LinkedList<>();
        this.exp = exp;
        this.foundEvents = new ArrayList<>();
        this.outputFileName = outputFile;
    }

    /**
     * Run the command line interface input reader using BufferedReader
     * Process user inputs to execute add event, find events according to a category, 
     * delete an event by name, write to output file and exit the reader actions
     *
     * @param  nothing
     * @return  nothing
     */
    public void run() {
        //Scanner CLIReader = new Scanner(System.in);
        BufferedReader CLIReader = new BufferedReader(new InputStreamReader(System.in));
        String primaryCmd;
        MyFileWriter fileWriter;
        boolean quit = false;

        try {
            do {
                System.out.println("******************************Welcome to Command Line Interface****************************");
                System.out.println("a: add (an event). You will be prompted to input name, date and other data for the event.");
                System.out.println("f: find. Specify category when prompted. The acceptable options are: ");  
                System.out.println("  - n: name of the event \n  - d: date \n  - r: range of dates \n  - l: location \n  - t: type \n  - o: organizer");
                System.out.println("u: update. (not implemented)");
                System.out.println("d: delete (remove). Input the name of the event when prompted and then remove the event if found");
                System.out.println("w: write. The program will write its data in the output file and then continue.");
                System.out.println("x: exit. Data is saved in the output file and the program is terminated");
                System.out.println("Enter your command: ");            
                String inputCommandLine = CLIReader.readLine();
                String[] inputCmds = inputCommandLine.split("\\s*");
                primaryCmd = inputCmds[0];

                switch(primaryCmd) {
                    case "a":   String n, d, r, l, t, o;
                                n = d = r = l = t = o = null;
                                System.out.println("You are about to add an event");
                                System.out.println("name: ");
                                n = CLIReader.readLine();
                                System.out.println("single-day event? (Y/N): ");
                                String dateChoice = CLIReader.readLine();
                                if(dateChoice.equalsIgnoreCase("Y")) {
                                    System.out.println("date: ");
                                    d = CLIReader.readLine();
                                } else if(dateChoice.equalsIgnoreCase("N")) {
                                    System.out.println("range of dates (separated by a space between these dates): ");
                                    r = CLIReader.readLine();
                                }
                                System.out.println("location: ");  
                                l = CLIReader.readLine();
                                System.out.println("type: ");  
                                t = CLIReader.readLine();            
                                System.out.println("organization (separate by comma if there are multiple): ");  
                                o = CLIReader.readLine();  
                                long startTime = System.currentTimeMillis();
                                if (d != null) userEvents.add(new SingleDayEvent(n, d, l, t, o));
                                else userEvents.add(new MultiDayEvent(n, r, l, t, o));
                                System.out.println(userEvents);
                                ListIterator<Event> i = userEvents.listIterator(0);
                                while(i.hasNext()) {
                                    Event temp = i.next();
                                    String key = temp.getKey();
                                    Event value = temp;
                                    this.exp.getMap().put(key, value);
                                }
                                long stopTime = System.currentTimeMillis();
                                System.out.println("@@@ Time taken: " + (stopTime - startTime) + " milliseconds");
                                break;
                    case "f":   System.out.println("Specify category: ");
                                String findBy = CLIReader.readLine();
                                List<Event> eventDB = new ArrayList<Event>(this.exp.getMap().values());
                                TreeMapContainer dateTreeMap = new TreeMapContainer(this.exp);
                                dateTreeMap.run();
                                // System.out.println("TreeMap is here!" + dateTreeMap.getTreeMap());
                                switch(findBy) {
                                    case "n":   System.out.println("Specify name: ");
                                                String findInput_n = CLIReader.readLine();
                                                long startTime1 = System.currentTimeMillis();
                                                for(Iterator<Event> it = eventDB.iterator(); it.hasNext();) {
                                                    Event temp = it.next();
                                                    if(temp.getName().equalsIgnoreCase(findInput_n)) foundEvents.add(temp);
                                                }
                                                if (foundEvents.size() > 0) fileWriter = new MyFileWriter(outputFileName, foundEvents);
                                                else System.out.println("Not found");
                                                long stopTime1 = System.currentTimeMillis();
                                                System.out.println("@@@ Time taken: " + (stopTime1 - startTime1) + " milliseconds");
                                                break;
                                    case "d":   System.out.println("Specify one date: ");
                                                String findInput_d = CLIReader.readLine();
                                                long startTime2 = System.currentTimeMillis();
                                                if (dateTreeMap.containsKey(findInput_d)) {
                                                    LinkedList<String> dateLL = dateTreeMap.getLLbyDate(findInput_d).getKeyList();
                                                    ListIterator<String> iter = dateLL.listIterator(0);
                                                    while(iter.hasNext()) {
                                                        Event temp = this.exp.getMap().get(iter.next());
                                                        foundEvents.add(temp);
                                                    }
                                                    fileWriter = new MyFileWriter(outputFileName, foundEvents);
                                                } else System.out.println("Not found");
                                                long stopTime2 = System.currentTimeMillis();
                                                System.out.println("@@@ Time taken: " + (stopTime2 - startTime2) + " milliseconds");
                                                break;
                                    case "r":   System.out.println("Specify two dates, separated by a space: ");
                                                String findInput_r = CLIReader.readLine();
                                                long startTime3 = System.currentTimeMillis();
                                                int spaceIndex = findInput_r.indexOf(" ");
                                                String startDateStr = findInput_r.substring(0, spaceIndex);
                                                String endDateStr = findInput_r.substring(spaceIndex+1); 
                                                Date startDate = new Date(startDateStr);
                                                Date endDate = new Date(endDateStr);
                                                Calendar start = Calendar.getInstance();
                                                start.setTime(startDate);
                                                Calendar end = Calendar.getInstance();
                                                end.setTime(endDate);
                                                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                                for (Date date = start.getTime(); start.before(end) || start.equals(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                                                    String dateString = formatter.format(date);
                                                    if (dateTreeMap.containsKey(dateString)) {
                                                        LinkedList<String> dateLL = dateTreeMap.getLLbyDate(dateString).getKeyList();
                                                        ListIterator<String> iter = dateLL.listIterator(0);
                                                        while(iter.hasNext()) {
                                                            Event temp = this.exp.getMap().get(iter.next());
                                                            foundEvents.add(temp);
                                                        }
                                                        fileWriter = new MyFileWriter(outputFileName, foundEvents);
                                                    }
                                                }
                                                if (foundEvents.size() > 0) fileWriter = new MyFileWriter(outputFileName, foundEvents);
                                                else System.out.println("Not found");
                                                long stopTime3 = System.currentTimeMillis();
                                                System.out.println("@@@ Time taken: " + (stopTime3 - startTime3) + " milliseconds");                                                
                                                break;
                                    case "l":   System.out.println("Specify location: ");
                                                String findInput_l = CLIReader.readLine();
                                                long startTime4 = System.currentTimeMillis();
                                                for(Iterator<Event> it = eventDB.iterator(); it.hasNext();) {
                                                    Event temp = it.next();
                                                    if(temp.hasLoc()) {
                                                        if(temp.getLoc().equalsIgnoreCase(findInput_l)) foundEvents.add(temp);
                                                    }
                                                }
                                                if (foundEvents.size() > 0) fileWriter = new MyFileWriter(outputFileName, foundEvents);
                                                else System.out.println("Not found");
                                                long stopTime4 = System.currentTimeMillis();
                                                System.out.println("@@@ Time taken: " + (stopTime4 - startTime4) + " milliseconds");
                                                break;  
                                    case "t":   System.out.println("Specify type: ");
                                                String findInput_t = CLIReader.readLine();
                                                long startTime5 = System.currentTimeMillis();
                                                for(Iterator<Event> it = eventDB.iterator(); it.hasNext();) {
                                                    Event temp = it.next();
                                                    if(temp.hasType()) {
                                                        if(temp.getType().equalsIgnoreCase(findInput_t)) foundEvents.add(temp);
                                                    }
                                                }
                                                System.out.println("why not accumulate" + foundEvents);
                                                if (foundEvents.size() > 0) fileWriter = new MyFileWriter(outputFileName, foundEvents);
                                                else System.out.println("Not found");
                                                long stopTime5 = System.currentTimeMillis();
                                                System.out.println("@@@ Time taken: " + (stopTime5 - startTime5) + " milliseconds");
                                                break;
                                    case "o":   System.out.println("Specify organization: ");
                                                String findInput_o = CLIReader.readLine();
                                                long startTime6 = System.currentTimeMillis();
                                                for(Iterator<Event> it = eventDB.iterator(); it.hasNext();) {
                                                    Event temp = it.next();
                                                    if(temp.hasOrgs()) {
                                                        if(temp.getOrgs().indexOf(findInput_o) > -1) foundEvents.add(temp);
                                                    }
                                                }
                                                if (foundEvents.size() > 0) fileWriter = new MyFileWriter(outputFileName, foundEvents);
                                                else System.out.println("Not found");
                                                long stopTime6 = System.currentTimeMillis();
                                                System.out.println("@@@ Time taken: " + (stopTime6 - startTime6) + " milliseconds");                                                
                                                break;                                                
                                }
                                foundEvents.clear();
                                break;                 
                    case "u":   System.out.println("The update method is not implemented.");
                                break;                    
                    case "d":   System.out.println("Specify name: ");
                                String fileToDelete = CLIReader.readLine();
                                long startTime8 = System.currentTimeMillis();
                                List<Event> eventDB2 = new ArrayList<Event>(this.exp.getMap().values());
                                for(Iterator<Event> it = eventDB2.iterator(); it.hasNext();) {
                                    Event temp = it.next();
                                    if(temp.getName().equalsIgnoreCase(fileToDelete)) {
                                        this.exp.getMap().remove(temp.getKey());
                                    }
                                }
                                long stopTime8 = System.currentTimeMillis();
                                System.out.println("@@@ Time taken: " + (stopTime8 - startTime8) + " milliseconds");
                                break;                    
                    case "w":   long startTime7 = System.currentTimeMillis();
                                this.exp.writeToFile(outputFileName);
                                long stopTime7 = System.currentTimeMillis();
                                System.out.println("@@@ Time taken: " + (stopTime7 - startTime7) + " milliseconds");
                                break;
                    case "x":   quit = true;
                                break;                            
                    default:    System.out.println("Please input a valid command as shown in the instructions.");
                                break;            
                }
                
            } while (!quit);
        } catch(Exception e) {
            System.out.println("Exception caught in running EventHandler: " + e);
            e.printStackTrace();
        }
    }
    
    public ArrayList<Event> getFound() {
        return foundEvents;
    }

}
