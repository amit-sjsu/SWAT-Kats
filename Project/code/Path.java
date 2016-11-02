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
        int distance = (int) Point.distance(startHouse.getPoint(), endHouse.getPoint());
        System.out.println("Total Distance is : " + distance);
        int widthofhouse = startHouse.getImage().getWidth()/2;
        System.out.println("width of house is " + widthofhouse);
        this.pathLength = (distance - widthofhouse*2);
        int noOfBlocks =  pathLength/widthOfBlock;
        return noOfBlocks; 
    }
    
    private int blockDist(int noOfBlocks){
        return pathLength/noOfBlocks;
        
    }
             
    public void layoutBlock(){
        Point startPoint = startHouse.getPoint();
        Point endPoint = endHouse.getPoint();
        double rotateDegree = startPoint.findSlope(endPoint);
        pathWeight = findNoOfBlocks();
        blockDistance = blockDist(pathWeight);        
        blocks = new Block[pathWeight];
        Point p = startPoint;
        Point endRange = new Point(100,100);
        for(int i = 0 ;i<pathWeight; i++){
            blocks[i] = new Block();
            blocks[i].turn((int)rotateDegree);
            int distance = 70;// initial house distance should get from house width/2 I calculated it on my own
            if (i != 0){
                distance = blockDistance;
                endRange.setX(widthOfBlock+20);
                endRange.setY(widthOfBlock+20);
            }
            System.out.println("Distance is : " + distance);
            System.out.println("Start Point is " + p.toString());
            p = p.findPointThruExtraPolate(p, endRange, distance, rotateDegree);
            getWorld().addObject(blocks[i], p.getX(), p.getY());
        }        
    }
    
       public void act() 
    {
           
       if(Greenfoot.mouseClicked(this))
        { 
          
        }
    }    
    
    public int getWeigth()
    {
        return pathWeight;
    }
      
  
    
}
