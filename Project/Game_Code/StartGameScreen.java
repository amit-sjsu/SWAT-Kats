import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameScreen extends MSTGame
{
    GreenfootSound backgroundMusic = new GreenfootSound("Rain-sound-mp3.mp3");
    //GreenfootSound backgroundMusic = new GreenfootSound("musicFilename.mp3");
    //GreenfootSound rain=new GreenfootSound("rain-03.wav");
    /**
     * Constructor for objects of class StartGameScreen. Add Comments
     * 
     */
    public StartGameScreen()
    {
        backgroundMusic.playLoop();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage bg = new GreenfootImage("back.png");
        bg.scale(getWidth(), getHeight());

        setBackground(bg);
        System.out.println("set start");
        // rain.playLoop();
        PlayNowButton playnowbutton = new PlayNowButton();
        addObject(playnowbutton,298,495);
        Help help = new Help();
        addObject(help,639,495);
    }
    
    public void stopped()
    {
        backgroundMusic.stop();
    }
   
}
