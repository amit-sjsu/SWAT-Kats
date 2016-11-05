import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpPlayAudio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpPlayAudio extends Buttons
{
    /**
     * Act - do whatever the HelpPlayAudio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        HelpWorld world = (HelpWorld)getWorld();
        if(Greenfoot.mouseClicked(this))
        {
            world.startHelpSound();
                    
        }// Add your action code here.
    }    
}
