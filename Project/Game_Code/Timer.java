import greenfoot.*;
import java.awt.Color;
import java.util.ArrayList;
 
public class Timer extends Actor implements TimeSubject
{
    private static String time;
    private int secs = 0;
    private long curTime, prevTime;
    private static final long DELAY_TIME = 1000; // in milliseconds
    TimeObserver tb ;
    
    public Timer()
    {
        //this("");
        this.time="";
    }
    
    public Timer(int secs)
    {
        //this("");
        this.secs = secs;
    }
 
    public Timer(String Time)
    {
        setTime(Time);
    }
 
    public void setTime(String Time)
    {
        this.time = Time;
        setImage(new GreenfootImage(Time, 24, Color.GREEN, new Color(0, 0, 0, 0)));
    }
    public int getTime(){
        return secs;
    }
    
    public void act()
    {
        curTime = System.currentTimeMillis();
        if (prevTime +DELAY_TIME > curTime) {
              return;
        } else {
           if (secs >= 0){
               prevTime = curTime;
               secs = secs - 1;
               setImage(new GreenfootImage("Time left: " + secs , 24, Color.GREEN, new Color(0, 0, 0, 0)));
               if (secs == 0)
                  notifySubmit();
           }     
        }     
    }
    
    public void attach(TimeObserver tb){
        this.tb = tb;
    }
    public void detach(){
        this.tb = null;
    }
    public void notifySubmit(){
        if(null != this.tb){
            this.tb.submitSolution();
        }
    }
}