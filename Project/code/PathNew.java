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
    private House startPoint;
    private House endPoint;
    //private int sum=0;
      
    public PathNew(House start, House end){
        startPoint = start;
        endPoint = end;
    }
    
    public void layoutBlock(){
        double startX = startPoint.getX();
        double startY = startPoint.getY();
        double endX = endPoint.getX();
        double endY = endPoint.getY();
        System.out.println("Starting House X : " + startX + " Y:" + startY);
        System.out.println("Ending House X : " + endX + " Y:"+ endY);
        System.out.println("Slope  y2-y1: " + (endY-startY));
        System.out.println("Slope  x2-x1: " + (endX-startX));
        System.out.println("Slope  x2-x1: " + (endY-startY)/(endX-startX));
        //Math.toDegrees(Math.atan((y2-y1)/(x2-x1)))
        System.out.println("Degree to rotate using atan is : " + Math.atan((endY-startY)/(endX-startX))) ;
        System.out.println("Degree to rotate using atan2 is : " + Math.atan2((endY-startY), (endX-startX))) ;
        double rotateDegree = Math.toDegrees(Math.atan((endY-startY)/(endX-startX))); 
        System.out.println("Degree turn is : " + rotateDegree);
        System.out.println("Degree turn is : " +  Math.toDegrees(Math.atan2((endY-startY), (endX-startX))));
        Block  block = new Block();
        block.turn((int)rotateDegree);
        getWorld().addObject(block, (int) startX+50, (int)startY-40);
        Block  block2 = new Block();
        block2.turn((int)rotateDegree);
        getWorld().addObject(block2, (int)endX, (int)endY);
        
        
        
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
