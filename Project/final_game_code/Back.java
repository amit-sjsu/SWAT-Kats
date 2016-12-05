import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Buttons implements IButton
{
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private IButton nextButton;
    public void setNextButton(IButton next){
        this.nextButton=next;
    }
    public void handleRequest(String request){
        HelpWorld world = (HelpWorld)getWorld();
        if(request=="Back"){
            world.stopHelpSound();
            Greenfoot.setWorld(new StartGameScreen());
        }
        else{
            nextButton.handleRequest(request);
        }
        
    }       
}
