import greenfoot.*;
import java.awt.Color;
import java.util.ArrayList;
 
public class Timer extends Actor
{
    private static String time;
    
    public Timer()
    {
        //this("");
        this.time="";
    }
 
    public Timer(String Time)
    {
        
        setTime(Time);
    }
 
    public void setTime(String Time)
    {
        this.time=Time;
        setImage(new GreenfootImage(Time, 24, Color.GREEN, new Color(0, 0, 0, 0)));
    }
    public String getTime(){
        String[] parts = this.time.split(":");
        System.out.println(parts[1].trim());
        return parts[1].trim();
    }
}