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


public class Submit extends Buttons
{   private GifImage gif = new GifImage("submit.gif");
    private ArrayList<IEdge> selectedPath  = new ArrayList<IEdge>();
    public IEdge [] solution;
    private final String service_url = "http://localhost:8091/restlet/" ;
    Counter counter=new Counter();
    Timer timer=new Timer();
   
     public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            submit();
            
           
        }
    }  
    
    public void submit()
    {
          System.out.println("Hellllllllloooooooo Clicked");
        
            System.out.println(timer.getTime());
            System.out.println("Submit Button Clicked");
            System.out.println("Validating Solution");
            IEdge [] selected =  new IEdge[selectedPath.size()];
            selectedPath.toArray(selected);
            System.out.println("Solution Result");
            ValidateSolution vs = new ValidateSolution();
            boolean result = vs.validate(solution, selected);
            System.out.println("Is this a valid Solution :" + result);
            
            
            
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
    
    public void addPath(IEdge path){
        selectedPath.add(path);
    }
    
    public void removePath(IEdge path){
        selectedPath.remove(path);
    }
}