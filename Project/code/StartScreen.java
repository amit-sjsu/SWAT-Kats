import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartScreen extends World
{

   
     private GreenfootSound background = new GreenfootSound("menu.wav");
    public StartScreen()
    {    
        super(1000, 600, 1); 
        prepare();
     
    }

     public void stopBackgroundMusic()
    {
       // background.stop();
    }
    
    private void prepare()
    {
        PlayNow playnow = new PlayNow();
        addObject(playnow,315,307);

        playnow.setLocation(497,481);
    }
}
