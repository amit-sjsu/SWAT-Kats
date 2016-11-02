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
        prepare();
    }

    public void setupObjects(){
        house[0] = new House(350, 235);
        addObject(house[0], house[0].getPoint().getX(), house[0].getPoint().getY());
        house[1] = new House(700, 200);
        addObject(house[1], house[1].getPoint().getX(), house[1].getPoint().getY());
        house[2] = new House(830, 293);
        addObject(house[2], house[2].getPoint().getX(), house[2].getPoint().getY());
        house[3] = new House(500, 488);
        addObject(house[3], house[3].getPoint().getX(), house[3].getPoint().getY());
        house[4] = new House(154, 323);
        addObject(house[4], house[4].getPoint().getX(), house[4].getPoint().getY());
        path[0] = new Path(house[3], house[1]);
        path[1] = new Path(house[4], house[0]);
        path[2] = new Path(house[3], house[2]);
        path[3] = new Path(house[4], house[2]);
        path[4] = new Path(house[0], house[1]);
        addObject(path[0], 0,0);
        addObject(path[1], 0,0);
        addObject(path[2], 0,0);
        addObject(path[3], 0,0);
        addObject(path[4], 0,0);
        path[0].layoutBlock();
        path[1].layoutBlock();
        path[2].layoutBlock();
        path[3].layoutBlock();
        path[4].layoutBlock();

    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
