import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/*
 * to be done 
 * 1) Block placing should not be calculated using fixed house width/hieght, 
 * for now logic is total distance(from starthouse to endhouse) - 2(width of house /2) 
 * and divide total distance by width of block image. Ideally it should find a end point 
 * on the house using distance and extrapolate function,  * and add some initial spacing 
 * to point which gives proper spacing for each house. I think it wont take more than a hour.
 * 
 * 2) for now paths are in a straing line, add more function so that it can be created in 
 * different shapes like S or Arc or Circle or Z. * this can be done at last
 * 
 */
public class Path extends Actor
{
    private House startHouse;
    private House endHouse;
    private Block [] blocks;
    private int pathLength = 0;
    private int blockDistance = 0;
    private int pathWeight = 0;
    private int widthOfBlock = new Block().getImage().getWidth(); // 50 is width and 10 is padding towards left and other 10 for padding towards right
    //should try to get my image
      
    public Path(House start, House end){
        startHouse = start;
        endHouse = end;
        GreenfootImage i = null;
        setImage(i);
    }
    
    public int findNoOfBlocks(){
        int distance = Point.distance(startHouse.getPoint(), endHouse.getPoint());
        int widthofhouse = startHouse.getImage().getWidth() / 2;
        pathLength = (distance - widthofhouse * 2);
        return pathLength / widthOfBlock;
    }
    
    private int blockDist(int noOfBlocks){
        return pathLength / noOfBlocks;
    }
             
    public void layoutBlock(){
        Point startPoint = startHouse.getPoint();
        Point endPoint = endHouse.getPoint();
        int slopeAngle = 0;
        Point p = startPoint;
        Point endRange = new Point(100,100);
        slopeAngle = startPoint.findSlope(endPoint);
        pathWeight = findNoOfBlocks();
        blockDistance = blockDist(pathWeight);        
        blocks = new Block[pathWeight];
        for(int i = 0 ;i<pathWeight; i++){
            blocks[i] = new Block(this);
            blocks[i].turn(slopeAngle);
            int distance = 70;// initial house distance should get from house width/2 I calculated it on my own
            if (i != 0){
                distance = blockDistance;
                endRange.setX(widthOfBlock+20);
                endRange.setY(widthOfBlock+20);
            }
            p = p.findPointThruExtraPolate(p, endRange, distance, slopeAngle);
            getWorld().addObject(blocks[i], p.getX(), p.getY());
        }        
    }
        
    public int getWeigth()
    {
        return pathWeight;
    }
      
  
    public void remove(){
        for(int i = 0; i < getWeigth(); i++){
            blocks[i].setImage("path-white.png");
        }
    }
    
    public void add(){
        for(int i = 0; i < getWeigth(); i++){
            blocks[i].setImage("Red-path.png");
        }
    }
    
}
