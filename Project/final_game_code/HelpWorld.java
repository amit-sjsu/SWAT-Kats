import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Class;

/**
 * Write a description of class HelpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class HelpWorld extends MSTGame
{

    private GreenfootSound backgroundMusic = new GreenfootSound("MuddyRoadGame.mp3");
    private MouseInfo mouseinfo;
    private Actor actor;
    HelpPlayAudio audio;
    HelpStopAudio stop;
    HelpPauseAudio pause;
    Back back;
    public HelpWorld()
    {    
        audio = new HelpPlayAudio();
        stop= new HelpStopAudio();
        pause= new HelpPauseAudio();
        back = new Back();
        prepare();
    }
    private void prepare()
    {
        GreenfootImage bg = new GreenfootImage("Helpfinal.jpg");
        bg.scale(getWidth(), getHeight());
        
         setBackground(bg);
        addObject(back,739,620);
        addObject(audio,240,620);
        addObject(stop,340,620);
        addObject(pause,140,620);
        audio.setNextButton(stop);
        stop.setNextButton(pause);
        pause.setNextButton(back);
        
        
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(audio)){
            audio.handleRequest("Play");
        }
        else if(Greenfoot.mouseClicked(stop)){
            audio.handleRequest("Stop");
        }
        else if(Greenfoot.mouseClicked(pause)){

            audio.handleRequest("Pause");
        }
        else if(Greenfoot.mouseClicked(back)){


            audio.handleRequest("Back");
        }
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

