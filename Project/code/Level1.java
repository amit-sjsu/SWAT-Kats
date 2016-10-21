import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Level
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    private House house[]= new House[5];
    
    public Level1()
    {
        setupObjects();
    }
    
    public void setupObjects(){
        house[0] = new House();
        addObject(house[0],350,235);
        house[1] = new House();
        addObject(house[1],581,291);
        house[2] = new House();
        addObject(house[2],830,293);
        house[3] = new House();
        addObject(house[3],496,392);
        house[4] = new House();
        addObject(house[4],154,323);
        Path path1 = new Path();
        addObject(path1,614,511);
        Path path2 = new Path();
        addObject(path2,671,486);
        Path path3 = new Path();
        addObject(path3,719,461);
        
    }
}
