import greenfoot.*;
import java.util.ArrayList;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation ;
import org.restlet.*;
import org.json.*;
import java.lang.String;;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import javax.swing.JOptionPane; 
import javax.swing.JInternalFrame;
/**
 * Write a description of class SubmitObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SubmitObserver implements PathObserver,  TimeObserver
{
    // instance variables - replace the example below with your own
    private ArrayList<IEdge> selectedPath  = new ArrayList<IEdge>();
    private ValidateSolution vs = new ValidateSolution();
    private House [] houses ;
    private Path [] paths;
    private Graph solution;
    private final String service_url = "http://52.196.47.211:8088/restlet/" ;
    Counter counter=new Counter();
    //Timer timer=new Timer();
    Score score;
    Timer timer;


    /**
     * Constructor for objects of class SubmitObserver
     */
    public SubmitObserver(House [] houses, Path [] paths, Graph solution)
    {
        this.houses = houses;
        this.paths = paths;
        this.solution = solution;
    }
    
    public void submitSolution(){
        System.out.println("Submitting solution");
        IEdge [] selectedEdges =  new IEdge[selectedPath.size()];
        selectedPath.toArray(selectedEdges);
        boolean result = vs.validate(solution.GetMinimalSpanningEdges(), selectedEdges);
        System.out.println("Is solution correct ?? : " + result);
        if (result){
        Proxy proxy = new Proxy();
        proxy.submitSolution(result, timer.getTimeSecs(), score.getScore());
        Greenfoot.setWorld(new LevelChangeScreen());
        }
        
    }
    public void submitTimeExpire(){
        System.out.println("Submitting solution");
        IEdge [] selectedEdges =  new IEdge[selectedPath.size()];
        selectedPath.toArray(selectedEdges);
        boolean result = vs.validate(solution.GetMinimalSpanningEdges(), selectedEdges);
        Proxy proxy = new Proxy();
        proxy.submitSolution(result, timer.getTimeSecs(), score.getScore());
        Greenfoot.setWorld(new LevelChangeScreen());
    }

    public void updateSelect(IEdge path){
        System.out.println("Path selected  " + path.getId());
        selectedPath.add(path);
        if (vs.allHouseConnected(houses, selectedPath)){
            //vs.
            System.out.println("are all house connected???");
            submitSolution();
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
    
    public void setTimer(Timer t){
        timer = t;
    }
    
    public void setScore(Score s){
        score = s;
    }

    
}
