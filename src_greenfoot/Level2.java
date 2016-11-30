import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Level
{
    private Timer timerText;   
    private House house[]= new House[8];
    private Path path[] = new Path[15];
    Counter counter;
    private Score score;
    Submit submit;
    SubmitObserver submitObserver;

    public Level2()
    {
        prepare();
        setupObjects();
        timerText = new Timer(45);
        addObject(timerText, 874, 38);
        timerText.attach(submitObserver);
        submitObserver.setTimer(timerText);
        submitObserver.setScore(score);
        submit.setTimer(timerText);
        submit.setScore(score);        
    }

    public void setupObjects(){
        System.out.println("Loading Level 1:");
        house[0] = new House(250, 100, 0);
        house[1] = new House(600, 100, 1);
        house[2] = new House(450, 250, 2);
        house[3] = new House(850, 250, 3);
        house[4] = new House(150, 450, 4);
        house[5] = new House(620, 450, 5);
        house[6] = new House(350, 600, 6);
        house[7] = new House(800, 600, 7);
        
        for (int i = 0; i < house.length; i++){
           addObject(house[i], house[i].getPoint().getX(), house[i].getPoint().getY());
        }
        
        path[1] = new Path(house[0], house[1]);
        path[2] = new Path(house[0], house[2]);
        path[3] = new Path(house[0], house[4]);
        path[4] = new Path(house[1], house[2]);
        path[5] = new Path(house[1], house[3]);
        path[6] = new Path(house[5], house[1]);
        path[7] = new Path(house[1], house[7]);
        path[8] = new Path(house[2], house[4]);
        path[9] = new Path(house[2], house[5]);
        path[10] = new Path(house[2], house[6]);
        path[11] = new Path(house[3], house[7]);
        path[12] = new Path(house[4], house[6]);
        path[13] = new Path(house[5], house[6]);
        path[14] = new Path(house[5], house[7]);
        path[0] = new Path(house[6], house[7]);
        
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
        submit.solution =  graph.GetMinimalSpanningEdges();;
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
        submit = new Submit();
        addObject(submit,869,729);
        score = new Score();
        addObject(score,94,51);
    }
}
