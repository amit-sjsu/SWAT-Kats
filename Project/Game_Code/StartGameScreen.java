import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameScreen extends MSTGame
{

    //GreenfootSound rain=new GreenfootSound("rain-03.wav");
    /**
     * Constructor for objects of class StartGameScreen. Add Comments
     * 
     */
    public StartGameScreen()
    {
        /*GreenfootImage desc1 = new GreenfootImage(
                "Welcome to Muddy City", 40, null, null);
        GreenfootImage desc2 = new GreenfootImage(
                "There was huge rainfall due to which roads got damage pretty bad,", 30, null, null);
        GreenfootImage desc3 = new GreenfootImage(
                "To win you have to connect all the houses with minimal amount of bricks"
            , 22, null, null);
        getBackground().drawImage(desc1,
            getWidth()/2 - desc1.getWidth()/2,
            50);
        getBackground().drawImage(desc2,
            getWidth()/2 - desc2.getWidth()/2,
            300);
        getBackground().drawImage(desc3,
            getWidth()/2 - desc3.getWidth()/2,
            350);*/
        /*GifImage img = new GifImage("startfinal.gif");
        setImage(img.getCurrentImage());*/
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
    
    /*public void stopped()
    {
        rain.pause();
    }
    
    public void started()
    {
        rain.playLoop();
    }*/
    
}
