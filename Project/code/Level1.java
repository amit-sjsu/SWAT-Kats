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
        house[0] = new House(350, 235);
        addObject(house[0],350, 235);
        house[1] = new House(700, 200);
        addObject(house[1],700,200);
        house[2] = new House(830, 293);
        addObject(house[2],830,293);
        house[3] = new House(500, 488);
        addObject(house[3],500,488);
        house[4] = new House(154, 323);
        addObject(house[4],154,323);
        Path p = new Path(house[3], house[1]);
        Path p1 = new Path(house[4], house[0]);
        Path p2 = new Path(house[3], house[2]);
        Path p3 = new Path(house[4], house[2]);
        Path p4 = new Path(house[0], house[1]);
        addObject(p, 0,0);
        addObject(p1, 0,0);
        addObject(p2, 0,0);
        addObject(p3, 0,0);
        addObject(p4, 0,0);
        p.layoutBlock();
        p1.layoutBlock();
        p2.layoutBlock();
        p3.layoutBlock();
        p4.layoutBlock();
        
        
    }
}
