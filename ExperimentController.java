
/**
 * The class for the controller of experiments
 *
 * @author (Danhui)
 * @version (Nov 11 2017)
 */
public class ExperimentController
{
    /**
     * Constructor for objects of class ExperimentController
     */
    public ExperimentController()
    {

    }

    public static void main(String[] args) {
        // ExperimentController ex = new ExperimentController();
        MyFileWriter input = new MyFileWriter("testInput.txt", 10000);
        Experiment e = new Experiment("testInput.txt", "testOutput.txt");
        e.run();
    }
    
}
