import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Level
{
    Timer timerText;
    Score score;
    Submit submit;
    private House house[]= new House[6];
    private Path path[] = new Path[8];
    SubmitObserver submitObserver;

    public Level1()
    {
        prepare();
        setupObjects();
        timerText = new Timer(30);
        addObject(timerText, 874, 38);
        submit.setTimer(timerText);
        submit.setScore(score);
        submitObserver.setTimer(timerText);
        submitObserver.setScore(score);

    }

    public void setupObjects(){
        System.out.println("Loading Level 1:");
        house[0] = new House(350, 235);
        house[1] = new House(700, 100);
        house[2] = new House(900, 330);
        house[3] = new House(500, 488);
        house[4] = new House(154, 323);
        house[5] = new House(293, 470);
        path[0] = new Path(house[1], house[3]);
        path[1] = new Path(house[4], house[0]);
        path[2] = new Path(house[3], house[2]);
        path[3] = new Path(house[1], house[2]);
        path[4] = new Path(house[0], house[1]);
        path[5] = new Path(house[5], house[3]);
        path[6] = new Path(house[0], house[3]);
        path[7] = new Path(house[5], house[4]);
        
        for (int i = 0; i < house.length; i++){
            house[i].setId(i);
           addObject(house[i], house[i].getPoint().getX(), house[i].getPoint().getY());
        }
        
        Graph graph = new Graph(house.length, path.length);
        submitObserver = new SubmitObserver(house, path, graph);
        for (int i = 0; i < path.length; i++){
           addObject(path[i], -200,0);
           path[i].layoutBlock();
           path[i].setSubmitObserver(submit);
           path[i].attach(submitObserver);
           path[i].attach(score);
           graph.addEdges(path[i]);
        }
        submit.solution =  graph.GetMinimalSpanningEdges();
    }
    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage bg = new GreenfootImage("grassBackground.jpg");
        bg.scale(getWidth(), getHeight());
        
        setBackground(bg);
        /*addObject(timerText, 874, 38);
        timerText.setTime("Time left: " + (timer/60));*/
        score = new Score();
        addObject(score,94,51);
        submit = new Submit();
        addObject(submit,869,729);
      
    }

}
