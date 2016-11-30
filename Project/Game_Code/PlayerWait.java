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
    
   // private final String service_url = "http://localhost:8091/restlet/" ;
    Timer timerText = new Timer();
    Message message= new Message();
    Proxy proxy=new Proxy();
    
  
    private int timer=300;
    private String playState;
    private String playerName;
    public   static String firstPlayer;
    public   static String secondPlayer;
    private   int OnePlayerStateCounter=0;
    private   int TwoPlayerStateCounter=0;
    private  boolean flag=false;
    private  String state="";
    
    
    
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
        
        
        if(flag)
        {
              try {
                   
                     
                    JSONObject jsonobject= proxy.gamePlay();
                    
                     
                     state=jsonobject.getString("currentGameState");
                     if(jsonobject.getString("currentGameState").equals("Game Started State"))
                     {
                        flag=false;
                        TwoPlayerStateCounter=1;
                     }

                     } catch ( Exception e ) {  }   
        
        
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
             try{
             
                Representation result= proxy.getPlayer();
              
              
               String[] Players = result.getText().split(",");
              TwoPlayerStateCounter=1;
              this.firstPlayer=Players[0];
               this.secondPlayer=Players[1];
             
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
        
                    catch ( Exception e ) {}  
            
        
        
            }
         
         
        
        else if( (OnePlayerStateCounter==1) && (TwoPlayerStateCounter>0))
        {
            prepare();
            
            try{
          
                
                Representation result= proxy.getPlayer();
                 String[] Players = result.getText().split(",");
  
                     this.secondPlayer=Players[1];
          
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
                    catch ( Exception e ) {}  
            
            
            
            
        }
        
       }
    }

