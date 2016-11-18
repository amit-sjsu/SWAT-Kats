

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class LevelChangeScreen extends MSTGame
{
    private GreenfootSound backgroundMusic = new GreenfootSound("atebrains.wav");

    public LevelChangeScreen()//int score)
    {    
        backgroundMusic.play(); 
        int score=0; 
       
      
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
        smily smily = new smily();
        addObject(smily,513,314);
        Next_level next_level = new Next_level();
        addObject(next_level,555,662);
        smily.setLocation(496,309);
        next_level.setLocation(529,674);
    }
}
