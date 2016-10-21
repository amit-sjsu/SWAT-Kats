import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver_Lose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver_Lose extends World
{
    private GreenfootSound backgroundMusic = new GreenfootSound("atebrains.wav");
    /**
     * Constructor for objects of class GameOver_Lose.
     * 
     */
    public GameOver_Lose()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        prepare();
        backgroundMusic.play();
    }
    private void prepare()
    {  
        Replay objReplay = new Replay();
        addObject(objReplay, 700, 505);   
    }
    public void stopBackgroundMusic()
    {
        backgroundMusic.stop();
    }
}