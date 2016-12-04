/**
 * Write a description of class TimeSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface TimeSubject  
{
    // instance variables - replace the example below with your own
    void attach(TimeObserver pb);
    void detach();
    void notifySubmit();
}
