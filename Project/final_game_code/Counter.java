import greenfoot.*;  
import java.awt.Color;


public class Counter extends Actor
{
   static int score;
   
    public Counter()
    {
      this.score = 0;
    }
   
    
   
   public void act()
   {
       
   setImage(new GreenfootImage("Score : " + score , 24 , Color.BLACK , new Color(0,0,0,0) ));
   
   }
   
   
   public void addScore(int value)
    {
       this.score= this.score + (200 - (value *20));
  
    }
    
    public void deleteScore(int value)
    {
        
        this.score=this.score - (200 - (value *20));
   
    }
    public int getValue(){
        return this.score;
    }
    
}


