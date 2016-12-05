import greenfoot.*; 
import java.util.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Demo extends MSTGame
{

    private int timer=1620;
    private boolean flag=true;
     GreenfootSound backgroundMusic = new GreenfootSound("Demo_Instructions.mp3");
   
    
    public Demo()
    {
        prepare();
    }
    
    public void prepare()
    {    
        
       // backgroundMusic.play();
        GreenfootImage wait = new GreenfootImage("Demo0.png");
        wait.scale(getWidth(), getHeight());
        setBackground(wait);   
        
        
        }

    
    
    public void act()
    
    {
        if(flag)
        {
        backgroundMusic.play();
        }
        timer=timer-6;
       
        
        if(timer%60==0)
            {
                
              
                if(timer<1020 && timer>840)
                {
                    GreenfootImage wait = new GreenfootImage("Demo1.png");
                     wait.scale(getWidth(), getHeight());
                     setBackground(wait);
                 }   
                    
                 else if(timer <840 && timer>420)
                 {
                    GreenfootImage wait = new GreenfootImage("Demo2.png");
                     wait.scale(getWidth(), getHeight());
                     setBackground(wait);
                 } 
                 
                 else if(timer <420 && timer >0)
                     {
                     GreenfootImage wait = new GreenfootImage("Demo3.png");
                     wait.scale(getWidth(), getHeight());
                     setBackground(wait);
                     //backgroundMusic.stop();
                     } 
                     else if(timer==0)
                     {
                         flag=false;
                       
                     }
                     
                     else if(timer<-120 && timer>-156)
                     {
                        backgroundMusic.stop();
                     }
                    else if(timer<-156)
                    {     
                        
                        Greenfoot.setWorld(new StartGameScreen());
                       
                    }
               }
             
                 
                 
             }
             
        
           
        
        
        
    }
    
    
    

