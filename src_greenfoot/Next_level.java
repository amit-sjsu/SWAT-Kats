import greenfoot.*;


public class Next_level extends Buttons
{   private GifImage gif = new GifImage("continue.gif");
   
    public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartGameScreen());
            LevelChangeScreen world = (LevelChangeScreen)getWorld();
          
        }
    }    
}