/**
 * Write a description of class PathSubect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface PathSubject  
{
    // instance variables - replace the example below with your own
    void attach(PathObserver pb);
    void detach(PathObserver pb);
    void notifySelect();
    void notifyUnSelect();
}
