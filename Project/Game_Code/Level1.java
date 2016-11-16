import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Level
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    private House house[]= new House[5];
    private Path path[] = new Path[5];

    public Level1()
    {
        setupObjects();
        prepare();
    }

    public void setupObjects(){
        System.out.println("Loading Level 1:");
        house[0] = new House(350, 235);
        house[0].setId(0);
        addObject(house[0], house[0].getPoint().getX(), house[0].getPoint().getY());
        house[1] = new House(700, 200);
        house[1].setId(1);
        addObject(house[1], house[1].getPoint().getX(), house[1].getPoint().getY());
        house[2] = new House(830, 293);
        house[2].setId(2);
        addObject(house[2], house[2].getPoint().getX(), house[2].getPoint().getY());
        house[3] = new House(500, 488);
        house[3].setId(3);
        addObject(house[3], house[3].getPoint().getX(), house[3].getPoint().getY());
        house[4] = new House(154, 323);
        house[4].setId(4);
        addObject(house[4], house[4].getPoint().getX(), house[4].getPoint().getY());
        path[0] = new Path(house[3], house[1]);
        path[1] = new Path(house[4], house[0]);
        path[2] = new Path(house[3], house[2]);
        path[3] = new Path(house[4], house[2]);
        path[4] = new Path(house[0], house[1]);
        addObject(path[0], 0,0);
        addObject(path[1], 0,0);
        addObject(path[2], 0,0);
        addObject(path[3], 0,0);
        addObject(path[4], 0,0);
        
        path[0].layoutBlock();
        path[1].layoutBlock();
        path[2].layoutBlock();
        path[3].layoutBlock();
        path[4].layoutBlock();
        
        int c = 0;
        System.out.println("Initial");
        for(IEdge pat : path)
        {
            c++;
             System.out.println("count : " + c + " " + pat.getWeight() + " src: " + pat.getSrc()+ " dest: " + pat.getDest());
        }
        Graph graph = new Graph(5, 5);
        graph.addEdges(path[0]);
        graph.addEdges(path[1]);
        graph.addEdges(path[2]);
        graph.addEdges(path[3]);
        graph.addEdges(path[4]);
        IEdge[] paths = graph.GetMinimalSpanningEdges();
        Path[] selectedPaths = new Path[3]; //test path
        int totalLen = paths.length;
        int counter = 0;
        System.out.println("minimal spanning tree" + " len: "+ paths.length );
        for(IEdge path : paths)
        {
            counter++;
             
            System.out.println("count : " + counter + " " + path.getWeight() + " src: " + path.getSrc()+ " dest: " + path.getDest());
        }
        /*for(IEdge path : paths)
        {
            int src = path.getSrc();
            int des = path.getDest();
            for(Path selPath : selectedPaths)
            {
                if(src == selPath.getSrc() && des == selPath.getDest())
                    counter++;
                    
            }
            
        }*/
        String result= "Loose";
        if(counter == totalLen && paths.length == selectedPaths.length)
            result = "Win";
        
    }
    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Counter counter = new Counter();
        addObject(counter,94,51);
        Submit submit = new Submit();
        addObject(submit,775,695);
        removeObject(submit);
        Submit submit2 = new Submit();
        addObject(submit2,869,729);
    }
}
