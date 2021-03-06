import greenfoot.*;
import javax.swing.*;
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
 * Write a description of class MagicianClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Proxy  
{
     private final String service_url = "http://52.196.47.211:8088/restlet/";
    //private final String service_url = "http://localhost:8092/restlet/";
     Counter counter=new Counter();
     Timer timer=new Timer();
     Message message= new Message();
     //PlayerWait playWait=new PlayerWait();
     private  boolean flag=false;
    private String playState;
    private String playerName;
    public   static String firstPlayer;
    public   static String secondPlayer;
    private   int OnePlayerStateCounter=0;
    private   int TwoPlayerStateCounter=0;
 //   private  boolean flag=false;
    private  String state="";
    
    public Proxy()
    {
    }

    public void addPlayer(String userName)
    {
        try {
                    ClientResource helloClientresource = new ClientResource( service_url+"addPlayer" );
                    
                    JSONObject obj= new JSONObject();
                    obj.put("username",userName);
                    Representation result = helloClientresource.post(obj) ;
                    JSONObject jsonobject= new JSONObject(result.getText());
                    
                    if(jsonobject.getString("gameState").equals("OnePlayerState"))
                    {
                        Greenfoot.setWorld(new PlayerWait("OnePlayerState",userName));
                        
                    }
                    else if(jsonobject.getString("gameState").equals("TwoPlayerState"))
                    {

                        Greenfoot.setWorld(new PlayerWait("TwoPlayerState",userName));
                        
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(new JInternalFrame(), 
                        "Game has been started with 2 players","Game Started", JOptionPane.INFORMATION_MESSAGE);

                   
                       }

            } catch ( Exception e ) 
            {
                 System.out.println(e);
            }   
                       
    }
    
    public void submitSolution(boolean result, int time, int score)
    {
        try {
            ClientResource helloClientresource = new ClientResource( service_url + "getGameState" );
            Representation response = helloClientresource.get();
            JSONObject jsonobject= new JSONObject(response.getText());
            JSONObject obj= new JSONObject();

            if(jsonobject.getString("currentGameState").equals("Game Started State"))
            {
                obj.put("username",PlayNowButton.name);

            }
            else if(jsonobject.getString("currentGameState").equals("PlayerOneSubmiitedState"))
            {
                obj.put("username",PlayNowButton.name);

            }

            obj.put("time",String.valueOf(time));
            obj.put("isSolutionMST",String.valueOf(result));
            if (result)
                obj.put("score",String.valueOf(score + 500));
            else
                obj.put("score",String.valueOf(score));

            helloClientresource = new ClientResource( service_url+"submitScore" );
            response = helloClientresource.post(obj) ;
            jsonobject= new JSONObject(response.getText());

            if(jsonobject.getString("gameState").equals("PlayerOneSubmittedScoreState"))
            {
                System.out.println("Player One Submitted State. Waiting for other player");
            }
            else if(jsonobject.getString("gameState").equals("Game Finished State"))
            {
                try{
                    helloClientresource = new ClientResource( service_url + "getScores" );
                    response = helloClientresource.get() ;
                    jsonobject= new JSONObject(response.getText());
                    
                }
                catch(Exception e){
                    System.out.println( e.getMessage() ) ;
                }
            }

        } 
        catch ( Exception e ) 
        {
            System.out.println(e) ;

        } 
    }
    
    public JSONObject gamePlay()
   {
                  try{
                    ClientResource helloClientresource = new ClientResource( service_url+"getGameState" );
                    Representation result = helloClientresource.get() ; 
                    JSONObject jsonobject= new JSONObject(result.getText());
                    
                    return jsonobject;
                   }
                   catch(Exception e)
                   {
                       return null;
                   }
                
       
   }
   public Representation getPlayer()
   {
      try{
          
          ClientResource helloClientresource = new ClientResource( service_url+"addPlayer" );
          Representation result = helloClientresource.get() ; 
          return result ;
         }
         catch(Exception e)
          { 
             return null;
            }
       
       
  }
  public JSONObject getScore(){
      try{
                            ClientResource helloClientresource = new ClientResource( service_url+"getScores" );
                            Representation response = helloClientresource.get();
                            JSONObject jsonobject= new JSONObject(response.getText());
                            return jsonobject;
                        }
                        catch(Exception e)
          { 
             return null;
            }
    }
    
    
    
    
   
}
    