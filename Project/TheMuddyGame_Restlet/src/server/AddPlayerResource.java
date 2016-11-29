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
	private static String playerName;
	private static String FirstplayerName;
	private static String SecondplayerName;
	private static String Players;
	JSONObject response = new JSONObject();
	
	
	@Get
    public String represent() {
		Players= FirstplayerName + "," +SecondplayerName;
		return Players;
    }
	
	
//	@Get
//    public JsonRepresentation represent() {
//		return (new JsonRepresentation(response));
//    }
	
	
    @Post
    public JsonRepresentation represent(Representation entity) throws IOException {
    	MuddyGame game = SingletonGameClass.getGameInstance();
    	
    	System.out.println("entity:"+entity);
    	
    	JsonRepresentation represent = new JsonRepresentation(entity);
    	
    	JSONObject jsonobject = represent.getJsonObject();
    	
    	System.out.println("jsonobject.getString(username):"+jsonobject.getString("username"));
    	if(game.getCurrentGameState().toString()=="Game Finished State")
    	{
    		System.out.println("inside new method");
    		game.setState(game.getNoPlayerState());
    		game.setParameters();
    	}
    	
    	if(game.getCurrentGameState().toString() == "NoPlayerState"){
    		FirstplayerName=jsonobject.getString("username");
    		playerName=jsonobject.getString("username");
    		game.addPlayerOne(jsonobject.getString("username"));
    		users.add(jsonobject.getString("username"));
        	
        	//JSONObject response = new JSONObject();
        	
        	response.put("users", users);
        	response.put("gameState", game.getCurrentGameState());
        	
            return (new JsonRepresentation(response));
    	}
    	else if(game.getCurrentGameState().toString() == "OnePlayerState"){
    		SecondplayerName=jsonobject.getString("username");
    		playerName=jsonobject.getString("username");
    		game.addPlayerTwo(jsonobject.getString("username"));
    		game.startGame();
    		users.add(jsonobject.getString("username"));
        	
        	//JSONObject response = new JSONObject();
        	
        	response.put("users", users);
        	response.put("gameState", "TwoPlayerState");
        	
            return (new JsonRepresentation(response));
    	}
    	
    	//users.add(jsonobject.getString("username"));
    	
    	//JSONObject response = new JSONObject();
    	response.put("Message", "Wrong State to add Users");
    	response.put("gameState", game.getCurrentGameState());
    	
        return (new JsonRepresentation(response));
    }
}

