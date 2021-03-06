import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

/**
 * Write a description of class HelpPlayAudio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpPauseAudio extends Buttons implements IButton
{
    /**
     * Act - do whatever the HelpPlayAudio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private IButton nextButton;
    public void setNextButton(IButton next){
        System.out.println("set next in HelpPause Audio");
        this.nextButton=next;
    }
    public void handleRequest(String request){
        HelpWorld world = (HelpWorld)getWorld();
        if(request=="Pause"){
            System.out.println("if in HelpPause Audio");
            world.pauseHelpSound(); 
        }
        else{
            System.out.println("else in HelpPause Audio");
            nextButton.handleRequest(request);
        }
        
    }
}
