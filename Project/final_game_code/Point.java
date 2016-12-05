/**
 * Write a description of class Location here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point  
{
    // instance variables - replace the example below with your own
    private int xcoord;
    private int ycoord;

    /**
     * Constructor for objects of class Location
     */
    public Point()
    {
    }
    
    public Point(int x, int y)
    {
        xcoord = x;
        ycoord = y;
    }

    public int getX(){
        return xcoord;
    }
    
    public int getY(){
        return ycoord;
    }
    
    public void setY(int y){
        ycoord = y;
    }
    
    public void setX(int x){
        xcoord = x;
    }
    
    private static int slope(double startX, double startY, double endX, double endY){
       return (int) Math.toDegrees(Math.atan((endY-startY)/(endX-startX)));
    }
   
    /**
     * this helps to find slope between two point, 
     * First parameters take is starting point and second one is ending point
     */
    
    public static int findSlope(Point start, Point end){  
        return slope(start.getX(), start.getY(), end.getX(), end.getY());
    }
    
    public int findSlope(Point end){
        return slope(getX(), getY(), end.getX(), end.getY());        
    }
    
    public int findSlope(int x, int y){
        return slope(getX(), getY(), x, y);        
    }
    
    public static int findQuadrant(int startPosX, int startPosY, int endPosX, int endPosY){
        
        
        if ((startPosX > endPosX)  && (startPosY > endPosY))
           return 1;
        else if ((startPosX < endPosX)  && (startPosY > endPosY))
           return 1;
        else if ((startPosX < endPosX)  && (startPosY < endPosY))
           return 2;
        else if ((startPosX > endPosX)  && (startPosY < endPosY))
           return 2;
        return 3; // point is outof the box;
    }
    
    
    public Point findPointThruExtraPolate(Point a,  Point endRange, int distance, int slope, int quadrant){
        Point xy = new Point();
        int endX = 0;
        int endY = a.getY();
        int startPosY = 0;
        int startPosX = 0;
        int dist = 0, testSlope = 0;
        
        if (slope < 0){
            if (quadrant == 1){
                startPosX = a.getX() + 10;
                startPosY = a.getY() - endRange.getY();
                endX  = startPosX + endRange.getX();
                endY = a.getY();
            }
            else {
                startPosX = a.getX() - endRange.getX();
                startPosY = a.getY() ;
                endX  = a.getX();
                endY = a.getY() + endRange.getY();
            }
        }
        else{
            if (quadrant == 1){
                startPosX = a.getX() - endRange.getX();
                startPosY = a.getY() - endRange.getY();
                endX  = a.getX() + 10;
                endY = a.getY();
            }
            else {
                startPosX = a.getX() + 10;
                startPosY = a.getY() ;
                endX  = startPosX + endRange.getX();
                endY = a.getY() + endRange.getY();
            }
        }   
        for (int startX = startPosX; startX < endX  ; startX++){
            for (int startY = startPosY;startY < endY  ; startY++ ){
                dist = a.distance(startX, startY);
                testSlope = a.findSlope(startX, startY);              
                if (( dist - 1 < distance && distance < dist + 2) && (int)slope == testSlope){
                    xy.setX(startX);
                    xy.setY(startY);
                    break;
                }
            }
        }
        return xy;
    }
    private static int calculateDistance(Point a, Point b){
        double diffX = a.getX()-b.getX();
        double diffY = a.getY()-b.getY();
        return (int) Math.sqrt(Math.pow(diffX,2) + Math.pow(diffY,2));
    }
    
    public static int distance(Point a, Point b){
        return calculateDistance(a, b);
    }
    
    public int distance(Point b){
        return calculateDistance(this, b);
    }
    public int distance(int x, int y){
        Point b = new Point(x,y);
        return calculateDistance(this, b);
    }
    
    public String toString(){
        return "Point : (" + getX() + ", " + getY() +")";
    }
    
}
