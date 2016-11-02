import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SingleBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    private Path fromPath;
    private Boolean pathSelected = false;
    /**
     * Act - do whatever the SingleBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Block(){
    }
    
    public Block(Path path){
        fromPath = path;
    }
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        { 
          if (pathSelected) {
              fromPath.remove();
              pathSelected = false;
          }
          else{
              fromPath.add();
              pathSelected = true;
          }
        }
    }
}
