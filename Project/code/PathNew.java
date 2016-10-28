import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PathNew extends Actor
{
    private static int count=0;
    private House startHouse;
    private House endHouse;
    private Block [] blocks;
    //private int sum=0;
      
    public PathNew(House start, House end){
        startHouse = start;
        endHouse = end;
    }
    
    
   
    public Integer [] findRangeXY(int xShift, int yShift, int quadrant){
        Integer [] range  = new Integer[4];
        if (quadrant == 1){
            
        }
        return range;
    }
    
    public int findQuadrant(int startPosX, int startPosY, int endPosX, int endPosY){
        if (((endPosX - startPosX) > 0) && ((endPosY - startPosY) > 0))
           return 1;
        else if ((endPosX - startPosX) < 0 && (endPosY - startPosY) > 0)
           return 2;
        else if ((endPosX - startPosX) < 0 && (endPosY - startPosY) < 0)
           return 3;
        else if ((endPosX - startPosX) > 0 && (endPosY - startPosY) < 0)
           return 4;
        else if ((endPosY - startPosY) == 0)
           return 5; // parallel to Y axis;
        else if ((endPosX - startPosX) == 0)
           return 6; // parallel to X axis;
        return 10; // point is outof the box;
    }
    
    public Integer [] findPointThruExtraPolate(int startPosX, int startPosY, int startRangeX, 
          int startRangeY, int endRangeX, int endRangeY, double slope){
        Integer [] point = new Integer [2];
        double newSlope = 0.0;
        
        for(; startRangeX<endRangeX; startRangeX++){
            for(; startRangeY<endRangeY; startRangeY++){
                newSlope = Math.toDegrees(Math.atan((startRangeY-startPosY)/(startRangeX-startPosX)));
                if (newSlope == slope){
                    point[0] = startRangeX;
                    point[1] = startRangeY;
                    break;
                }
            }            
        }
        
        return point;
        
    }
          
    
    public void layoutBlock(){
        Point startPoint = startHouse.getPoint();
        Point endPoint = endHouse.getPoint();
        
        double rotateDegree = startPoint.findSlope(endPoint);

        Block  block = new Block();
        block.turn((int)rotateDegree);
        getWorld().addObject(block, (int) startPoint.getX() + 50, (int)startPoint.getY() - 40);
        Block  block2 = new Block();
        block2.turn((int)rotateDegree);
        getWorld().addObject(block2, (int)endPoint.getX(), (int)endPoint.getY());
        
        
        
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
