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
       if (scoreUpdate){
           int start, stop;
           scoreUpdate = false;
           start = previousScore;
           stop  = score;
          
           for(;;){
              
              try{
                  Greenfoot.delay(0);
              }
              catch(Exception e){
                  System.out.println("Error from score, with error : " +  e.toString());
              }
              
              if (previousScore < score){
                  start++;
              }else{
                  start--;
              }
              setImage(new GreenfootImage("Score : " + start , 24 , Color.GREEN , Color.WHITE ));
              if ((start == stop) || (previousScore == score))
                  break;
          }
       }
   
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
