import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class HelpWorld extends MSTGame
{

    /**
     * Constructor for objects of class HelpWorld.
     * 
     */
    private GreenfootSound backgroundMusic = new GreenfootSound("MuddyRoadGame.wav");
    public HelpWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(1000, 800, 1); 
        prepare();
        //GreenfootSound sound = new GreenfootSound("MuddyRoadGame.wav");
    }
    private void prepare()
    {
        System.out.println("Entered Help World");
        Back back = new Back();
        addObject(back,839,720);
        HelpPlayAudio audio = new HelpPlayAudio();
        addObject(audio,239,720);
        HelpStopAudio stop= new HelpStopAudio();
        addObject(stop,340,720);
        HelpPauseAudio pause= new HelpPauseAudio();
        addObject(pause,139,720);
        
    }
    public void startHelpSound()
    {
        backgroundMusic.play();
    }
    public void pauseHelpSound()
    {
        backgroundMusic.pause();
    }
    public void stopHelpSound()
    {
        backgroundMusic.stop();
    }
}

