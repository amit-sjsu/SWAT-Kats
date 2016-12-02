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
    GreenfootSound backgroundMusic = new GreenfootSound("Hearbeat_2-Mike_Koenig-143666461.mp3");
    private ArrayList<IEdge> selectedPath  = new ArrayList<IEdge>();
    public IEdge [] solution;

    /**
     * Constructor for objects of class Level1.
     * 
     */
    private int timer=1800;
    Timer timerText = new Timer();
   
    private House house[]= new House[8];
    private Path path[] = new Path[15];
    Counter counter;
    Submit submit, submit2;

    public Level1()
    {
        prepare();
        setupObjects();

    }

    public void setupObjects(){
        System.out.println("Loading Level 1:");
        house[0] = new House(250, 100);
        house[0].setId(0);
        addObject(house[0], house[0].getPoint().getX(), house[0].getPoint().getY());
        house[1] = new House(600, 100);
        house[1].setId(1);
        addObject(house[1], house[1].getPoint().getX(), house[1].getPoint().getY());
        house[2] = new House(450, 250);
        house[2].setId(2);
        addObject(house[2], house[2].getPoint().getX(), house[2].getPoint().getY());
        house[3] = new House(850, 250);
        house[3].setId(3);
        addObject(house[3], house[3].getPoint().getX(), house[3].getPoint().getY());
        house[4] = new House(150, 450);
        house[4].setId(4);
        addObject(house[4], house[4].getPoint().getX(), house[4].getPoint().getY());
        house[5] = new House(620, 450);
        house[5].setId(5);
        addObject(house[5], house[5].getPoint().getX(), house[5].getPoint().getY());
		house[6] = new House(350, 600);
        house[6].setId(6);
        addObject(house[6], house[6].getPoint().getX(), house[6].getPoint().getY());
		house[7] = new House(800, 600);
        house[7].setId(7);
        addObject(house[7], house[7].getPoint().getX(), house[7].getPoint().getY());
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

        addObject(path[0], 0,0);
        addObject(path[1], 0,0);
        addObject(path[2], 0,0);
        addObject(path[3], 0,0);
        addObject(path[4], 0,0);
        addObject(path[5], 0,0);
        addObject(path[6], 0,0);
        addObject(path[7], 0,0);
		addObject(path[8], 0,0);
        addObject(path[9], 0,0);
        addObject(path[10], 0,0);
        addObject(path[11], 0,0);
        addObject(path[12], 0,0);
        addObject(path[13], 0,0);
        addObject(path[14], 0,0);
        
        
        path[0].layoutBlock();
        path[1].layoutBlock();
        path[2].layoutBlock();
        path[3].layoutBlock();
        path[4].layoutBlock();
        path[5].layoutBlock();
        path[6].layoutBlock();
        path[7].layoutBlock();
		path[8].layoutBlock();
        path[9].layoutBlock();
        path[10].layoutBlock();
        path[11].layoutBlock();
        path[12].layoutBlock();
        path[13].layoutBlock();
        path[14].layoutBlock();
        
        
        int c = 0;
        System.out.println("Initial");
        for(Path pat : path)
        {
             pat.setSubmitObserver(submit2);
        }
        
        Graph graph = new Graph(8, 15);
        graph.addEdges(path[0]);
        graph.addEdges(path[1]);
        graph.addEdges(path[2]);
        graph.addEdges(path[3]);
        graph.addEdges(path[4]);
        graph.addEdges(path[5]);
        graph.addEdges(path[6]);
        graph.addEdges(path[7]);
		graph.addEdges(path[8]);
        graph.addEdges(path[9]);
        graph.addEdges(path[10]);
        graph.addEdges(path[11]);
        graph.addEdges(path[12]);
        graph.addEdges(path[13]);
		graph.addEdges(path[14]);

        IEdge[] paths = graph.GetMinimalSpanningEdges();
        int totalLen = paths.length;
        int counter = 0;
        System.out.println("minimal spanning tree" + " len: "+ paths.length );
        for(IEdge path : paths)
        {
            counter++;
             
            System.out.println("count : " + counter + " " + path.getWeight() + " id: " + path.getId());
        }
        submit2.solution =  paths;
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
        
        
        Timer timerObj = new Timer();
        addObject(timerObj,894,45);
        addObject(timerText, 890, 50);
        timerText.setTime("Time left: " + (timer/60));
        
        ScoreBox scoreObj = new ScoreBox();
        addObject(scoreObj,90,45);
      
        counter = new Counter();
        addObject(counter,94,51);
        //counter.setCounter("Score: " + (0));
     
        submit = new Submit();
        addObject(submit,775,695);
        removeObject(submit);
        submit2 = new Submit();
        addObject(submit2,869,729);
      
    }
    
    
   
    public void act()
    {
        timer -= 6;
        int timeleft=timer/60;
        if (timer%60 == 0)
        {
                    if(timeleft==9){
                        backgroundMusic.play();
                    }
                    if(timeleft == 0)
                    {
                        timerText.setTime("Time left: " + (timer/60));
                        submit2.submit();
                       // Greenfoot.stop();
                        
                    }  
            
            
            timerText.setTime("Time left: " + (timer/60));
        }
             
    }
}
