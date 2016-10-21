import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Replay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Replay extends Buttons
{
    /**
     * Act - do whatever the Replay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Background());
            GameOver_Lose world = (GameOver_Lose)getWorld();
            world.stopBackgroundMusic();
        }// Add your action code here.
    }    
}
