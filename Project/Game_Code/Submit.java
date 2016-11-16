import greenfoot.*;
import java.util.ArrayList;


public class Submit extends Buttons
{   private GifImage gif = new GifImage("submit.gif");
    private ArrayList<IEdge> selectedPath  = new ArrayList<IEdge>();
    public IEdge [] solution;
   
    public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            System.out.println("Submit Button Clicked");
            System.out.println("Validating Solution");
            IEdge [] selected =  new IEdge[selectedPath.size()];
            selectedPath.toArray(selected);
            System.out.println("Solution Result");
            ValidateSolution vs = new ValidateSolution();
            boolean result = vs.validate(solution, selected);
            System.out.println("Is this a valid Solution :" + result);
            
            Greenfoot.setWorld(new StartGameScreen());
            Level1 world = ( Level1)getWorld();
            
           
        }
    }  
    
    public void addPath(IEdge path){
        selectedPath.add(path);
    }
    
    public void removePath(IEdge path){
        selectedPath.remove(path);
    }
}