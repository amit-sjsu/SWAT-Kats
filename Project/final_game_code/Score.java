import greenfoot.*;  
import java.awt.Color;
import java.util.concurrent.TimeUnit;


public class Score extends Actor implements PathObserver
{
   private int score;
   private int previousScore;
   private Boolean scoreUpdate = true;
   
   public Score()
   {
      this.score = 0;
      this.previousScore = 0;
   }
    
   public void act()
   {
          setImage(new GreenfootImage("Score : " + score , 24 , Color.BLACK , Color.ORANGE ));
   }
   
   public void updateSelect(IEdge path){
       
       this.previousScore = this.score;
       int value = path.getWeight();
       this.score= this.score + (200 - (value *20));
       scoreUpdate = true;
   }
   
   public void updateUnSelect(IEdge path){
       this.previousScore = this.score;
       int value = path.getWeight();
       this.score= this.score - (200 - (value *20));
       scoreUpdate = true;
   }
   
   public int getScore(){
       return this.score;
   }
    
}
