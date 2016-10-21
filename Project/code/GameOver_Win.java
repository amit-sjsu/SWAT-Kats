import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver_Win extends World
{
    private GreenfootSound backgroundMusic = new GreenfootSound("atebrains.wav");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameOver_Win()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
        backgroundMusic.play();
    }
    private void prepare()
    {  
        NextLevel objnextLevel = new NextLevel();
        addObject(objnextLevel, 700, 505);   
    }
    public void stopBackgroundMusic()
    {
        backgroundMusic.stop();
    }
}
