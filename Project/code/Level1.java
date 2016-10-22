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
    private Path path[] = new Path[8];
    
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
        addObject(house[3],391,488);
        house[4] = new House();
        addObject(house[4],154,323);
        Block block = new Block();
        addObject(block, 100, 100);
        Path p = new Path(house[3], house[1]);
        addObject(p,200,200);
        p.layoutBlock();
        
    }
}
