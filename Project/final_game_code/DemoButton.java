import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DemoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemoButton extends Buttons
{ 
    // StartGameScreen obj=new StartGameScreen();
    
    public void act() 
    {
   
        if(Greenfoot.mouseClicked(this))
        { 
            StartGameScreen.stopSound();
            
            Greenfoot.setWorld(new Demo());
        }
    }    
}
