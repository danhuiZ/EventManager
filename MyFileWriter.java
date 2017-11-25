import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a description of class MyFileWriter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyFileWriter
{
    // instance variables - replace the example below with your own
    private PrintWriter outputFile;
    private Experiment experiment;
    
    /**
     * Constructor for objects of class MyFileWriter
     */
    public MyFileWriter(String outputFileName, Experiment exp)
    {
        this.experiment = exp;
        try {
            this.outputFile = new PrintWriter(outputFileName);            
            List<Event> eventDB = new ArrayList<Event>(this.experiment.getMap().values());
            for(Iterator<Event> i = eventDB.iterator(); i.hasNext();) {
                Event temp = i.next();
                this.outputFile.println("name: " + temp.getName());                
                this.outputFile.println("date: " + temp.getDate());
                if(temp.hasLoc())  this.outputFile.println("location: " + temp.getLoc());
                if(temp.hasType()) this.outputFile.println("type: " + temp.getType());                
                if(temp.hasOrgs()) this.outputFile.println("organization: " + temp.getOrgs());
                this.outputFile.println();
            }
            this.outputFile.close();
        } catch (Exception e) {
            System.out.println("Error occurred in FileWriter: " + e);
            e.printStackTrace();
        }

    }

    public MyFileWriter(String outputFileName, ArrayList<Event> eventsFound)
    {
        try {
            this.outputFile = new PrintWriter(outputFileName);            
            for(Iterator<Event> i = eventsFound.iterator(); i.hasNext();) {
                Event temp = i.next();
                System.out.println(temp);
                this.outputFile.println("name: " + temp.getName());    
                this.outputFile.println("date: " + temp.getDate());
                if(temp.hasLoc())  this.outputFile.println("location: " + temp.getLoc());
                if(temp.hasType()) this.outputFile.println("type: " + temp.getType());                
                if(temp.hasOrgs()) this.outputFile.println("organization: " + temp.getOrgs());
                this.outputFile.println();
            }
            this.outputFile.close();
        } catch (Exception e) {
            System.out.println("Error occurred in FileWriter: " + e);
            e.printStackTrace();
        }

    }
    
    public MyFileWriter(String dataInput, int numEvents) 
    {
        try{
            this.outputFile = new PrintWriter(dataInput);
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            long x = 1483228800000L;
            long y = 1514764800000L;
            Random r = new Random();
            for (int i=0; i<numEvents-2; i++) {
                if (i%2 == 0) {
                    long dateinMS = x+((long)(r.nextDouble()*(y-x)));
                    Date randomDate = new Date(dateinMS);
                    this.outputFile.println("name: " + genWord(8));    
                    this.outputFile.println("date: " + formatter.format(randomDate));  
                    this.outputFile.println("location: " + genWord(5) + " " + genWord(6));    
                    this.outputFile.println("type: " + genWord(6));       
                    this.outputFile.println("organization: " + genWord(6)); 
                    this.outputFile.println();
                } else {
                    long dateinMS = x+((long)(r.nextDouble()*(y-x)));
                    long a = 172800000L;
                    long b = 604800000L;
                    long endDate = dateinMS+((long)(r.nextDouble()*(b-a)));
                    Date randomStartDate = new Date(dateinMS);
                    Date randomEndDate = new Date(endDate);                
                    this.outputFile.println("name: " + genWord(8)); 
                    this.outputFile.println("date: " + formatter.format(randomStartDate) + " " + formatter.format(randomEndDate));  
                    this.outputFile.println("location: " + genWord(5) + " " + genWord(6));    
                    this.outputFile.println("type: " + genWord(6));       
                    this.outputFile.println("organization: " + genWord(6)); 
                    this.outputFile.println();
                }
            }
            this.outputFile.println("name: testEvent");    
            this.outputFile.println("date: 11/18/2017");  
            this.outputFile.println("location: Lafayette College Watson Courts");    
            this.outputFile.println("type: residential");       
            this.outputFile.println("organization: Reslife"); 
            this.outputFile.println();
            this.outputFile.println("name: anotherTestEvent");    
            this.outputFile.println("date: 11/18/2017 12/03/2017");  
            this.outputFile.println("location: Farinon");    
            this.outputFile.println("type: music");       
            this.outputFile.println("organization: Arts Society"); 
            this.outputFile.println();            
            
            this.outputFile.close();
        } catch (Exception e) {
            System.out.println("Error occurred writing data file: " + e);
            e.printStackTrace();
        }
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void writeDataFile(PrintWriter file) {
        
    }
    
    public String genWord(int wordLen) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(wordLen);
        for (int i = 0; i < wordLen; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();     
        System.out.println(generatedString);
        return generatedString;
    }
}
