import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
public class Path extends Actor implements Comparable<IEdge>, IEdge, PathComponent//, PathObserver
{
    private ArrayList<Observer> observers = new ArrayList<Observer>() ;
    private House startHouse;
    private House endHouse;
    private ArrayList<PathComponent> blocks = new ArrayList<PathComponent>();
    private Submit submitObserver ;
    private int pathLength = 0;
    private int blockDistance = 0;
    private int pathWeight = 0;
    private int widthOfBlock = new Block().getImage().getWidth(); // 50 is width and 10 is padding towards left and other 10 for padding towards right
    //should try to get my image
    public Path(){
    }
      
    public Path(House start, House end){
        startHouse = start;
        endHouse = end;
        GreenfootImage i = null;
        setImage(i);
    }

    public int getSrc()
    {
        return this.startHouse.getId();
    }
    
    public int getDest()
    {
        return this.endHouse.getId();
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
        int quadrant = Point.findQuadrant(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
        int slopeAngle = 0;
        Point p = startPoint;
        Point endRange = new Point(100,100);
        slopeAngle = startPoint.findSlope(endPoint);
        pathWeight = findNoOfBlocks();
        blockDistance = blockDist(pathWeight);
        
        
        for(int i = 0 ;i< pathWeight; i++){
            Block block = new Block(this);
            addChild(block);
            block.turn(slopeAngle);
            int distance = 70;// initial house distance should get from house width/2 I calculated it on my own
            if (i != 0){
                distance = blockDistance;
                endRange.setX(widthOfBlock+20);
                endRange.setY(widthOfBlock+20);
            }
            p = p.findPointThruExtraPolate(p, endRange, distance, slopeAngle, quadrant);
            getWorld().addObject(block, p.getX(), p.getY());
        }        
    }
        
    public int getWeight()
    {
        return pathWeight;
    }
    
    public int compareTo(IEdge compareEdge)
    {
        return this.getWeight()-compareEdge.getWeight();
    }
    
    public House startHouse()
    {
        return startHouse;
    }
    
    public House endHouse()
    {
        return endHouse;
    }
    
    
    
    public void selectPath(){
        for(PathComponent block : blocks){
            block.selectPath();
        }
        submitObserver.addPath(this);
    }
    
    public void unSelectPath(){
        for(PathComponent block : blocks){
            block.unSelectPath();
        }
        submitObserver.removePath(this);
    }
    
    private void addChild(PathComponent c){
        blocks.add(c);
    }
    
    private void removeChild(PathComponent c){
        blocks.remove(c);
    }
    
    private PathComponent getChild(int i){
        return blocks.get(i);
    }
    
    public String getId(){
        return startHouse.getId() + "<-->" + endHouse.getId();
    }
    
    public void setSubmitObserver(Submit observer){
        submitObserver = observer;
    }
}
