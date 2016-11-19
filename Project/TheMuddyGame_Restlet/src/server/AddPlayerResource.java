package server;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class AddPlayerResource extends ServerResource {
	private static List<String> users = new ArrayList<String>();
	private String status;
	
    @Post
    public JsonRepresentation represent(Representation entity) throws IOException {
    	MuddyGame game = SingletonGameClass.getGameInstance();
    	
    	System.out.println("entity:"+entity);
    	
    	JsonRepresentation represent = new JsonRepresentation(entity);
    	
    	JSONObject jsonobject = represent.getJsonObject();
    	
    	System.out.println("jsonobject.getString(username):"+jsonobject.getString("username"));
    	
    	if(game.getCurrentGameState().toString() == "NoPlayerState"){
    		game.addPlayerOne(jsonobject.getString("username"));
    		users.add(jsonobject.getString("username"));
        	
        	JSONObject response = new JSONObject();
        	response.put("users", users);
        	response.put("gameState", game.getCurrentGameState());
        	
            return (new JsonRepresentation(response));
    	}
    	else if(game.getCurrentGameState().toString() == "OnePlayerState"){
    		game.addPlayerTwo(jsonobject.getString("username"));
    		game.startGame();
    		users.add(jsonobject.getString("username"));
        	
        	JSONObject response = new JSONObject();
        	response.put("users", users);
        	response.put("gameState", "TwoPlayerState");
        	
            return (new JsonRepresentation(response));
    	}
    	
    	//users.add(jsonobject.getString("username"));
    	
    	JSONObject response = new JSONObject();
    	response.put("Message", "Wrong State to add Users");
    	response.put("gameState", game.getCurrentGameState());
    	
        return (new JsonRepresentation(response));
    }
}
