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
    private House startHouse;
    private House endHouse;
    private Block [] blocks;
    private int widthOfBlock = 50 + 10 + 10; // 50 is width and 10 is padding towards left and other 10 for padding towards right
    //should try to get my image
      
    public Path(House start, House end){
        startHouse = start;
        endHouse = end;
    }
    
    public int findNoOfBlocks(){
        int distance = (int) Point.distance(startHouse.getPoint(), endHouse.getPoint());
        int noOfBlocks =  distance/widthOfBlock;
        return noOfBlocks; 
    }
             
    public void layoutBlock(){
        Point startPoint = startHouse.getPoint();
        Point endPoint = endHouse.getPoint();
        int noOfBlocks = findNoOfBlocks();
        double rotateDegree = startPoint.findSlope(endPoint);
        //System.out.println("Total no of blocks along the path :" + findNoOfBlocks());
        blocks = new Block[noOfBlocks];
        Point p = startHouse.getPoint();
        Point endRange = new Point(100,100);
        for(int i =0 ;i<noOfBlocks; i++){
            blocks[i] = new Block();
            blocks[i].turn((int)rotateDegree);
           
             p= p.findPointThruExtraPolate(p, endRange, 65, rotateDegree);
            System.out.println("New x is : " + p.getX());
            System.out.println("New Y is : " + p.getY());
            getWorld().addObject(blocks[i], p.getX(), p.getY());
        }
        
        //     )
        
        
        
    }
    
       public void act() 
    {
           
       if(Greenfoot.mouseClicked(this))
        { 
          count++;
          /*World world;
          world = getWorld();
          //Background background = (Background)world;
          getWorld().addObject(new Red(), getX(), getY());
          getWorld().removeObjects(getWorld().getObjects(Player.class));
          getWorld().addObject(new Player(), getX(), getY());
          getWorld().addObject(new Message("Move " + count), 69,40);
          
          
          getWorld().removeObject(this);*/
          
        }
    }    
    
    public int getCount()
    {
        return count;
    }
      
  
    
}
