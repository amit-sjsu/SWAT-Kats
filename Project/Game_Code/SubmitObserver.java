import java.util.ArrayList;
/**
 * Write a description of class SubmitObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SubmitObserver implements PathObserver
{
    // instance variables - replace the example below with your own
    private ArrayList<IEdge> selectedPath  = new ArrayList<IEdge>();
    private ValidateSolution vs = new ValidateSolution();
    private House [] houses ;
    private Path [] paths;
    private Graph solution;

    /**
     * Constructor for objects of class SubmitObserver
     */
    public SubmitObserver(House [] houses, Path [] paths, Graph solution)
    {
        this.houses = houses;
        this.paths = paths;
        this.solution = solution;
    }
    
    public void SubmitSolution(){
        System.out.println("Submitting solution");
    }

    public void updateSelect(IEdge path){
        System.out.println("Path selected  " + path.getId());
        selectedPath.add(path);
        if (vs.allHouseConnected(houses, selectedPath)){
            //vs.
            System.out.println("are all house connected???");
            //submitSolution();
        }
    }
    public void updateUnSelect(IEdge path){
        System.out.println("Path un selected  " + path.getId());
        selectedPath.remove(path);
         if (vs.allHouseConnected(houses, selectedPath)){
            //vs.
            System.out.println("are all house connected???");
        }
    }
    
}
