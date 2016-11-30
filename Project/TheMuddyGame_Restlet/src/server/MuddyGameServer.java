package server;
//import org.restlet.Application;
//import org.restlet.Restlet;
//import org.restlet.routing.Router;
//import org.restlet.data.Protocol;
import org.restlet.*;
import org.restlet.data.Protocol;

public class MuddyGameServer{
	/**
     * Creates a root Restlet that will receive all incoming calls.
     */
    
    public static void main(String[] args) throws Exception {  
        // Create a new Component.  
    	System.out.println("Hi");
        //Component component = new Component(); 
        Component component=new Component();

        // Add a new HTTP server listening on port 8080.  
        component.getServers().add(Protocol.HTTP, 8091);  

        // Attach the sample application.  
        component.getDefaultHost().attach("/restlet", new InboundRoute());  

        // Start the component.  
        component.start();  
    }  



}
