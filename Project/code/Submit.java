import greenfoot.*;


public class Submit extends Buttons
{   private GifImage gif = new GifImage("submit.gif");
   
    public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartGameScreen());
            Level1 world = ( Level1)getWorld();
           
        }
    }    
}