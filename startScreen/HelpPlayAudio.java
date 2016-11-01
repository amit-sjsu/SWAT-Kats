import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpAudio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpPlayAudio extends Button
{
    /**
     * Act - do whatever the HelpAudio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //public GreenfootSound backgroundMusic = new GreenfootSound("MuddyRoadGame.wav");
    public void act() 
    {
        HelpWorld world = (HelpWorld)getWorld();
        if(Greenfoot.mouseClicked(this))
        {
            world.startHelpSound();
            //System.out.println("Mouse clicked on Help");
            //Greenfoot.setWorld(new HelpWorld());
            //HelpWorld world = (HelpWorld)getWorld();
                      
        }
        //Greenfoot.playSound("breathe.wav");// Add your action code here.
    }    
}
