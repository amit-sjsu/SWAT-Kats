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
          if (pathSelected) {
              counter.deleteScore(path.getWeight());
              path.unSelectPath();
              pathSelected = false;
          }
          else{
              counter.addScore(path.getWeight());
              path.selectPath();
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
