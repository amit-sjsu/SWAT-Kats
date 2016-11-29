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
public class SubmitObserver implements PathObserver
{
    // instance variables - replace the example below with your own
    private ArrayList<IEdge> selectedPath  = new ArrayList<IEdge>();
    private ValidateSolution vs = new ValidateSolution();
    private House [] houses ;
    private Path [] paths;
    private Graph solution;
    private final String service_url = "http://localhost:8091/restlet/" ;
    Counter counter=new Counter();
    Timer timer=new Timer();

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
        IEdge [] selected =  new IEdge[selectedPath.size()];
        selectedPath.toArray(selected);
        boolean result = vs.validate(solution.GetMinimalSpanningEdges(), selected);
        System.out.println("Is solution correct ?? : " + result);
        
        Greenfoot.setWorld(new LevelChangeScreen());
           // Level1 world = ( Level1)getWorld();
        try {
            ClientResource helloClientresource = new ClientResource( service_url + "getGameState" );
            Representation response = helloClientresource.get();
            JSONObject jsonobject= new JSONObject(response.getText());
            JSONObject obj= new JSONObject();
            System.out.println(jsonobject.getString("currentGameState"));
            if(jsonobject.getString("currentGameState").equals("Game Started State")){
                obj.put("username",PlayerWait.firstPlayer);
                /*obj.put("score",String.valueOf(counter.getValue()));
                obj.put("time",timer.getTime());
                obj.put("isSolutionMST",String.valueOf(result));*/
            }
            else if(jsonobject.getString("currentGameState").equals("PlayerOneSubmiitedState")){
                obj.put("username",PlayerWait.secondPlayer);
                /*obj.put("score",String.valueOf(counter.getValue()));
                obj.put("time",timer.getTime());
                obj.put("isSolutionMST",String.valueOf(result));*/
            }
            
            obj.put("time",timer.getTime());
            obj.put("isSolutionMST",String.valueOf(result));
            if (result)
                obj.put("score",String.valueOf(counter.getValue() + 500));
            else
                obj.put("score",String.valueOf(counter.getValue()));
            //JSONObject obj= new JSONObject();
            //obj.put("username","navneet");
            
            helloClientresource = new ClientResource( service_url+"submitScore" );
            response = helloClientresource.post(obj) ;
            jsonobject= new JSONObject(response.getText());
            
            System.out.println(jsonobject.getString("gameState"));
            if(jsonobject.getString("gameState").equals("PlayerOneSubmittedScoreState")){
                System.out.println("Player One Submitted State. Waiting for other player");
            }
            else if(jsonobject.getString("gameState").equals("Game Finished State")){
                System.out.println("Player Two Submitted.Game Finished State");
                try{
                    helloClientresource = new ClientResource( service_url + "getScores" );
                    response = helloClientresource.get() ;
                    jsonobject= new JSONObject(response.getText());
                    System.out.println(jsonobject.getString("Scores"));
                    System.out.println(jsonobject.getString("Decision"));
                }
                catch(Exception e){
                    System.out.println( e.getMessage() ) ;
                }
            }
            
        } catch ( Exception e ) {
            System.out.println( e.getMessage() ) ;
        }
        
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
    
}
