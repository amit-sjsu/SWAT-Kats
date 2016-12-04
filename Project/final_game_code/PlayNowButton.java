

import greenfoot.*;
import javax.swing.JOptionPane; 
import javax.swing.JInternalFrame;

public class PlayNowButton extends Buttons
{   
   
    Proxy proxy=new Proxy();
    private GreenfootImage img = new GreenfootImage("play!.png");
   
    
    
    public void act() 
    {
        setImage(img);
        StartGameScreen world = (StartGameScreen)getWorld();
        if(Greenfoot.mouseClicked(this))
        {
            world.stopped();
            String inputValue = JOptionPane.showInputDialog("enter your name");
            
            proxy.addPlayer(inputValue);
        
        }
    }    
    
    
    
}