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
        System.out.println("Starting House X : " + startX + " Y:" + startY);
        System.out.println("Ending House X : " + endX + " Y:"+ endY);
        System.out.println("Y2-Y1: " + (endY-startY));
        System.out.println("x2-X1: " + (endX-startX));
        System.out.println("(Y2-Y1)-(X2-X1): " + (endY-startY)/(endX-startX));
        System.out.println("Radians to rotate using atan is : " + Math.atan((endY-startY)/(endX-startX))) ;
        double rotateDegree = Math.toDegrees(Math.atan((endY-startY)/(endX-startX)));
        System.out.println("Degree turn using atan is : " + rotateDegree);
        System.out.println("Degree turn using atan2 is : " +  Math.toDegrees(Math.atan2((endY-startY), (endX-startX))));
        return rotateDegree;
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
    
    public Point findPointThruExtraPolate(Point a, Point startRange, Point endRange, int distance, double slope){
        Point xy = new Point();
        int startX = a.getX() + startRange.getX();
        int endX = a.getX() + endRange.getX();
        int startY = a.getY() + startRange.getY();
        int endY = a.getY()+ endRange.getY();
        
        for (; startX <= endX; startX++){
            for (;startY <= endY; startY++){
                int dist = (int)a.distance(startX, startY);
                double testSlope = a.findSlope(startX, startY);
                if (dist == distance && slope == testSlope){
                    xy.setX(startX);
                    xy.setY(startY);
                    
                }
            }
        }
        return xy;
    }
    private static double calculateDistance(Point a, Point b){
        double diffX = a.getX()-b.getX();
        double diffY = a.getY()-b.getY();
        double sumofsquare = Math.pow(diffX,2) + Math.pow(diffY,2);
        return Math.sqrt(sumofsquare);
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
    
}
