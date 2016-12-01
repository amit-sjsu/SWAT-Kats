import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class EndGameScreen extends MSTGame
{
    private GreenfootSound backgroundMusic = new GreenfootSound("atebrains.wav");

    public EndGameScreen()//int score)
    {    
        backgroundMusic.play(); 
        int score=0; 
       
        Replay replay = new Replay();
        addObject(replay, 800, 625);
        prepare();
    }

    public void stopBackgroundMusic()
    {
        backgroundMusic.stop();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage endbg = new GreenfootImage("End.jpg");
        endbg.scale(getWidth(), getHeight());
        setBackground(endbg);
        
    }
}
