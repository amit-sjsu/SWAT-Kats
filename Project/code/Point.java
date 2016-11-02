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
    
    private static double slope(double startX, double startY, double endX, double endY){
       return Math.toDegrees(Math.atan((endY-startY)/(endX-startX)));
    }
   
    /**
     * this helps to find slope between two point, 
     * First parameters take is starting point and second one is ending point
     */
    
    public static double findSlope(Point start, Point end){  
        return slope(start.getX(), start.getY(), end.getX(), end.getY());
    }
    
    public double findSlope(Point end){
        return slope(getX(), getY(), end.getX(), end.getY());        
    }
    
    public double findSlope(int x, int y){
        return slope(getX(), getY(), x, y);        
    }
    
    private int findQuadrant(int startPosX, int startPosY, int endPosX, int endPosY){
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
    
    public Point findPointThruExtraPolate(Point a,  Point endRange, int distance, double slope){
        Point xy = new Point();
        int endX = a.getX() + endRange.getX();
        int endY = a.getY();        
        for (int startX = a.getX()+10; startX <= endX; startX++){
            for (int startY = endY - endRange.getY();startY <= endY; startY++){
                int dist = (int)a.distance(startX, startY);
                int testSlope = (int)a.findSlope(startX, startY);              
                if (( dist - 1 < distance && distance < dist + 2) && (int)slope == testSlope){
                    xy.setX(startX);
                    xy.setY(startY);
                    break;
                }
            }
        }
        return xy;
    }
    private static double calculateDistance(Point a, Point b){
        double diffX = a.getX()-b.getX();
        double diffY = a.getY()-b.getY();
        return Math.sqrt(Math.pow(diffX,2) + Math.pow(diffY,2));
    }
    
    public static double distance(Point a, Point b){
        return calculateDistance(a, b);
    }
    
    public double distance(Point b){
        return calculateDistance(this, b);
    }
    public double distance(int x, int y){
        Point b = new Point(x,y);
        return calculateDistance(this, b);
    }
    
    public String toString(){
        return "Point : (" + getX() + ", " + getY() +")";
    }
    
}
