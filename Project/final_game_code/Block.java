import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SingleBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor implements PathComponent
{
    private Path path;
    private Boolean pathSelected = false;
    private Counter counter=new Counter();
    GreenfootSound backgroundMusic = new GreenfootSound("Mario_Jumping-Mike_Koenig-989896458.mp3");
    /**
     * Act - do whatever the SingleBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Block(){
        
    }
    
    public Block(Path path){
        this.path = path;
    }
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        { 
          backgroundMusic.play();  
          if (pathSelected) {
              counter.deleteScore(path.getWeight());
              path.unSelectPath();
              pathSelected = false;
          }
          else{
              counter.addScore(path.getWeight());
              path.selectPath();
              System.out.println("Src house"+path.getSrc());
              System.out.println("Src house"+path.getDest());
              pathSelected = true;
          }
        }
    }
    
    public void selectPath(){
        this.setImage("Red-path.png");
        pathSelected = true;

    }
    
    public void unSelectPath(){
        this.setImage("path-white.png");
        pathSelected = false;
    }
}
