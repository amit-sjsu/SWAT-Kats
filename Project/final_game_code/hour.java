import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hour extends Actor
{  
    
    private GifImage gif = new GifImage("hour.gif");
    
    
    public void act() 
    {
         setImage(gif.getCurrentImage());
    }    
}
