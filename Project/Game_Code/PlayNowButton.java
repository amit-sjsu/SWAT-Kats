

import greenfoot.*;
import javax.swing.*;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation ;
import org.restlet.*;
import org.json.*;
import java.lang.String;;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import javax.swing.JOptionPane; 
import javax.swing.JInternalFrame;

public class PlayNowButton extends Buttons
{   
    private final String service_url = "http://localhost:8091/restlet/" ;

    private GifImage gif = new GifImage("play_button.gif");
   
    
    
    public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            
            String inputValue = JOptionPane.showInputDialog("enter your name");
            
           // Greenfoot.setWorld(new Level1());
            try {
                    ClientResource helloClientresource = new ClientResource( service_url+"addPlayer" );
                    
                    JSONObject obj= new JSONObject();
                    obj.put("username",inputValue);
                    Representation result = helloClientresource.post(obj) ;
                    
                    JSONObject jsonobject= new JSONObject(result.getText());
                    
                    System.out.println(jsonobject.getString("gameState"));
                    if(jsonobject.getString("gameState").equals("OnePlayerState")){
                        System.out.println("Player 1 Added");
                        Greenfoot.setWorld(new PlayerWait("OnePlayerState",inputValue));
                        
                    }
                    else if(jsonobject.getString("gameState").equals("TwoPlayerState")){
                        
                        
                        
                        System.out.println("Player 2 Added");
                        Greenfoot.setWorld(new PlayerWait("TwoPlayerState",inputValue));
                        
                    }
                    else{
                        System.out.println("Cannot Add new Player");
                        JOptionPane.showMessageDialog(new JInternalFrame(), 
                        "Game has been started with 2 players","Game Started", JOptionPane.INFORMATION_MESSAGE);

                   
                       }
                    
                    //System.out.println(result.getText());
                   // setMessage( result.getText() ) ;  ; 
            } catch ( Exception e ) {
                // setMessage( e.getMessage() ) ;
            }   
            
            //Level1 world = (Level1)getWorld();
            
            
          
        }
    }    
    
    
    
}