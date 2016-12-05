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
       
        if(Greenfoot.mouseClicked(this))
        {
            StartGameScreen.stopSound();
            Greenfoot.setWorld(new HelpWorld());
        }// Add your action code here.
    }    
}
