import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class EndGameScreen extends MSTGame
{
    private GreenfootSound backgroundMusic = new GreenfootSound("atebrains.wav");

    public EndGameScreen()//int score)
    {    
        backgroundMusic.play(); 
        int score=0; 
        Counter counter = new Counter();
        addObject(counter,300,430);
        counter.setValue(score);
        Replay replay = new Replay();
        addObject(replay, 750, 425);
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
    }
}
