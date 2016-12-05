
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameScreen extends MSTGame
{
    public static GreenfootSound backgroundMusic = new GreenfootSound("Rain-sound-mp3.mp3");
    public static GreenfootSound backgroundMusic1 = new GreenfootSound("Instructions.mp3");
    public int i=1;
    private static boolean flag=true;
    //GreenfootSound rain=new GreenfootSound("rain-03.wav");
    /**
     * Constructor for objects of class StartGameScreen. Add Comments
     * 
     */
    public StartGameScreen()
    {
        //backgroundMusic.playLoop();
        prepare();

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage bg = new GreenfootImage("startback.png");
        bg.scale(getWidth(), getHeight());

        setBackground(bg);
        PlayNowButton playnowbutton = new PlayNowButton();
        addObject(playnowbutton,298,495);
        Help help = new Help();
        addObject(help,639,495);
        help.setLocation(785,557);
        playnowbutton.setLocation(453,559);
        playnowbutton.setLocation(511,553);
        help.setLocation(767,552);
        DemoButton demobutton = new DemoButton();
        addObject(demobutton,643,597);
        demobutton.setLocation(639,594);
    }
    
    public static void stopSound()
    {
        flag=false;
        backgroundMusic.stop();
        backgroundMusic1.stop();
    }
    public void act(){
        
        if(flag)
        {
        backgroundMusic.playLoop();    
        if(i==1){
            backgroundMusic1.play();
            i++;
        }
      }
    }
   
}
