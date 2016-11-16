/**
 * Write a description of class IButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IButton  
{
    public void setNextButton(IButton next);
    public void handleRequest(String request);
}
