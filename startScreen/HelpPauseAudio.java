import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpPauseAudio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpPauseAudio extends Button
{
    /**
     * Act - do whatever the HelpPauseAudio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        HelpWorld world = (HelpWorld)getWorld();
        if(Greenfoot.mouseClicked(this))
        {
            world.pauseHelpSound();     
        }// Add your action code here.
    }    
}
