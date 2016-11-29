import java.util.ArrayList;
import java.util.HashSet;
/**
 * Write a description of class ValidateSolutino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValidateSolution  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ValidateSolutino
     */
    public ValidateSolution()
    {
    }
    
    public boolean validate(IEdge [] actualSolution, IEdge [] selectedSolution){
        if (actualSolution.length !=  selectedSolution.length)
            return false;
          
        for (IEdge actualEdge : actualSolution){
            boolean found = false;
            for(IEdge possibleEdge : selectedSolution){
                if (possibleEdge.getId().equals(actualEdge.getId())){
                    found = true;
                    break;
                }
            }
            if (!found){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean allHouseConnected(House [] houses, ArrayList<IEdge> paths){
        Boolean houseConnected = true;
        HashSet<Integer> connected = new HashSet<Integer>();
        HashSet<Integer []> pathConnecting = new HashSet<Integer[]>();
        if(paths.size() < houses.length - 1)
           return !houseConnected;
           
        for (IEdge pathSelected : paths){
            pathConnecting.add(new Integer []{pathSelected.getSrc(),pathSelected.getDest()});
            for(Integer [] c : pathConnecting){
                if(connected.isEmpty()){
                    connected.add(c[0]);
                    connected.add(c[1]);
                    pathConnecting.remove(c);
                    break;
                }
                else if (connected.contains(c[0]) || connected.contains(c[1])){
                    connected.add(c[0]);
                    connected.add(c[1]);
                    pathConnecting.remove(c);
                    break;
                }
            }
        }
        for(House house: houses){
            if(!connected.contains(house.getId())){
                return !houseConnected;
            }
            
        }
        return houseConnected;
    }

}
