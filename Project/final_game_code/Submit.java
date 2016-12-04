import greenfoot.*;
import java.util.ArrayList;

public class Submit extends Buttons
{   private GreenfootImage submit = new GreenfootImage("submitBtn.png");
    private ArrayList<IEdge> selectedPath  = new ArrayList<IEdge>();
    public IEdge [] solution;
    Counter counter=new Counter();
    //Timer timer=new Timer();
    Proxy proxy=new Proxy();
    Score score;
    Timer timer;

    public void act() 
    {

        if(Greenfoot.mouseClicked(this))
        {
            submit();

        }
    }  

    public void submit()
    {

        IEdge [] selected =  new IEdge[selectedPath.size()];
        selectedPath.toArray(selected);
        ValidateSolution vs = new ValidateSolution();
        boolean result = vs.validate(solution, selected);
        proxy.submitSolution(result, timer.getTimeSecs(), score.getScore());    
        Greenfoot.setWorld(new LevelChangeScreen());

    }

    public void addPath(IEdge path){
        selectedPath.add(path);
    }

    public void removePath(IEdge path){
        selectedPath.remove(path);
    }

    public void setTimer(Timer t){
        timer = t;
    }

    public void setScore(Score s){
        score = s;
    }
}