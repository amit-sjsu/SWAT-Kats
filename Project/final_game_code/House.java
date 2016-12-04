import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    // instance variables - replace the example below with your own
    private Point point;
    private int id;
    /**
     * Constructor for objects of class House
     */
    public House(int x, int y)
    {
        point = new Point(x,y);
    }
    
    public House(int x, int y, int id)
    {
        point = new Point(x,y);
        this.id = id;
    }
    
    public void setId(int i)
    {
        id = i;
    }
    
    public int getId()
    {
        return id;
    }
    
    public Point getPoint(){
        return point;
    }
    
    public void setPoint(int x, int y){
        point.setX(x);
        point.setY(y);
    }
    
    public String getLocation(){
        String loc = "" + point.getX();
        loc +=  point.getY();
        return loc;
    }
}
