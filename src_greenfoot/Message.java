import greenfoot.*;
import java.awt.Color;
import java.util.ArrayList;
 
public class Message extends Actor
{
   
    public Message()
    {
        this("");
    }
 
    public Message(String Message)
    {
        setMessage(Message);
    }
 
    public void setMessage(String Message)
    {
        setImage(new GreenfootImage(Message, 24, Color.GREEN, new Color(0, 0, 0, 0)));
    } 
}