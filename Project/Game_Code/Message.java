import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
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
       GreenfootImage img =new GreenfootImage(Message, 32, Color.RED, new Color(0, 0, 0, 0));
       
       // setImage(new GreenfootImage(Message, 24, Color.RED, new Color(0, 0, 0, 0)));
        img.setFont(new java.awt.Font("Comic Sans", java.awt.Font.PLAIN,32));
        setImage(img);
    } 
}