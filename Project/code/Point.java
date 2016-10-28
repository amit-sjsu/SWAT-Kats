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
    
}
