import greenfoot.*;


public class Replay extends Buttons
{   private GreenfootImage replay = new GreenfootImage("replayBtn.png");
    /**
     * Act - do whatever the click wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Restarts the game when pressed 
     */
    public void act() 
    {
        //setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartGameScreen());
          //  EndGameScreen world = (EndGameScreen)getWorld();
          //  world.stopBackgroundMusic();
        }
    }    
}