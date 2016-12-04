import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends Buttons
{
    /**
     * Act - do whatever the Help wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        StartGameScreen world = (StartGameScreen)getWorld(); 
        if(Greenfoot.mouseClicked(this))
        {
            world.stopped();
            Greenfoot.setWorld(new HelpWorld());
            //HelpWorld world = (HelpWorld)getWorld();
        }// Add your action code here.
    }    
}
