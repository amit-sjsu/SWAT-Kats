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

}
