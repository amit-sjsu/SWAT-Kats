import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Path extends Actor
{
    private static int count=0;
    //private int sum=0;
      
       public void act() 
    {
           
       if(Greenfoot.mouseClicked(this))
        { 
          count++;
          World world;
          world = getWorld();
          Background background = (Background)world;
          getWorld().addObject(new Red(), getX(), getY());
          getWorld().removeObjects(getWorld().getObjects(Player.class));
          getWorld().addObject(new Player(), getX(), getY());
          getWorld().addObject(new Message("Move " + count), 69,40);
          
          
          getWorld().removeObject(this);
          
        }
    }    
    
    public int getCount()
    {
        return count;
    }
    public void setCount(int val)
    {
        count=val;
    }
     
}
