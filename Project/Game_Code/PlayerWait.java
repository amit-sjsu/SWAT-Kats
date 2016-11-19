import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
 * Write a description of class IntermediatePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerWait extends MSTGame
{
    
    private final String service_url = "http://localhost:8091/restlet/" ;
    Timer timerText = new Timer();
    Message message= new Message();
    
  
    private int timer=600;
    private String playState;
    private String playerName;
    private static String firstPlayer;
    private static String secondPlayer;
    private static int OnePlayerStateCounter=0;
    private static int TwoPlayerStateCounter=0;
    private static boolean flag=false;
     private static String state="";
    
    
    
    /**
     * Constructor for objects of class IntermediatePage.
     * 
     */
    public PlayerWait(String playState, String playerName)
    {
         this.playState=playState;
         this.playerName=playerName;
         prepare();
    }
    
    public void prepare()
    {
        System.out.println(playState);
        if(playState.equals("OnePlayerState"))
          {
             addObject(message, 500, 280);
            
          }
        
        else if(playState.equals("TwoPlayerState"))
         {
         addObject(message, 500, 280);  
         addObject(timerText, 500, 580);
         timerText.setTime("Get Ready !! Your Game will start in : " + (timer/60) + " seconds");
         }
         
         
         if((OnePlayerStateCounter==1) && (TwoPlayerStateCounter>0))
         {
             
         addObject(message, 500, 280);  
         addObject(timerText, 500, 580);
         timerText.setTime("Get Ready !! Your Game will start in : " + (timer/60) + " seconds");
             
         }
    }
    
    public void act()
    {
        
         System.out.println(OnePlayerStateCounter);
          System.out.println(TwoPlayerStateCounter);
         System.out.println("hhhhh" + state);
        
        if(flag)
        {
         try {
                    ClientResource helloClientresource = new ClientResource( service_url+"getGameState" );
                    Representation result = helloClientresource.get() ; 
                     JSONObject jsonobject= new JSONObject(result.getText());
                     System.out.println(jsonobject.getString("currentGameState"));
                     state=jsonobject.getString("currentGameState");
                     if(jsonobject.getString("currentGameState").equals("Game Started State"))
                     {
                        flag=false;
                        System.out.println("Started");
                        TwoPlayerStateCounter=1;
                     }
                    
                     
                    //System.out.println(result.getText());
                   // setMessage( result.getText() ) ;  ; 
                     } catch ( Exception e ) {
                // setMessage( e.getMessage() ) ;
             }   
        
        
            }
        
        
         if(playState.equals("OnePlayerState") && OnePlayerStateCounter==0)
         {
              this.firstPlayer=playerName;
              message.setMessage("Player " + firstPlayer + " Added. Waiting for second player to add"  );
              OnePlayerStateCounter =1;
              flag=true;
         }
         
         
         
          else if(playState.equals("TwoPlayerState"))
           {
             TwoPlayerStateCounter=1;
             this.secondPlayer=playerName;
             message.setMessage("Player " + this.firstPlayer + " and player " + this.secondPlayer + " Added. "  );
            timer-=6;
            if (timer%60==0) 
            {  
             timerText.setTime("Get Ready !! Your Game will start in : " + (timer/60) + " seconds");
            }
            if(timer==0)
            {
            
           
             Greenfoot.setWorld(new Level1());
          
           
            }
         }
         
         
        
        else if( (OnePlayerStateCounter==1) && (TwoPlayerStateCounter>0))
        {
            prepare();
            System.out.println("Start timer for Player 1");
            message.setMessage("Player " + this.firstPlayer + " and player " + this.secondPlayer + " Added. "  );
          timer-=6;
        if (timer%60==0) 
        {  
            timerText.setTime("Get Ready !! Your Game will start in : " + (timer/60) + " seconds");
        }
        if(timer==0)
            {
      
             Greenfoot.setWorld(new Level1());
          
           
            }
            
            
        }
        
       }
    }

