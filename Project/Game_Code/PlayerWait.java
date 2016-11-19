import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntermediatePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerWait extends MSTGame
{
    Timer timerText = new Timer();
    Message message= new Message();
    
  
    private int timer=600;
    private String playState;
    private String playerName;
    private static String firstPlayer;
    private static String secondPlayer;
    
    
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
    }
    
    public void act()
    {
        
        
        
        
        
         if(playState.equals("OnePlayerState"))
         {
              this.firstPlayer=playerName;
              message.setMessage("Player " + firstPlayer + " Added. Waiting for second player to add"  );
           
         }
         
        else if(playState.equals("TwoPlayerState"))
         {
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
    }
}
