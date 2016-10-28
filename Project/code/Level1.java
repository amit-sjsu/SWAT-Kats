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
    private PathNew path[] = new PathNew[8];
    
    public Level1()
    {
        setupObjects();
    }
    
    public void setupObjects(){
        house[0] = new House(350, 235);
        addObject(house[0],350, 235);
        house[1] = new House(400, 351);
        addObject(house[1],400,351);
        house[2] = new House(830, 293);
        addObject(house[2],830,293);
        house[3] = new House(391, 488);
        addObject(house[3],391,488);
        house[4] = new House(154, 323);
        addObject(house[4],154,323);
        PathNew p = new PathNew(house[3], house[1]);
        addObject(p, 0,0);
        p.layoutBlock();
        
    }
}
