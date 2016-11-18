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
       
   setImage(new GreenfootImage("Score : " + score , 24 , Color.GREEN , Color.WHITE ));
   
   }
   
   
   public void addScore(int value)
    {
       this.score= this.score+value;
  
    }
    
    public void deleteScore(int value)
    {
        
        this.score=this.score-value;
   
    }
    
}
