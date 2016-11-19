import greenfoot.*;
import java.awt.Color;
import java.util.ArrayList;
 
public class Timer extends Actor
{
    private int timer=60;
    public Timer()
    {
        this("");
    }
 
    public Timer(String Time)
    {
        setTime(Time);
    }
 
    public void setTime(String Time)
    {
        setImage(new GreenfootImage(Time, 24, Color.GREEN, new Color(0, 0, 0, 0)));
    } 
}