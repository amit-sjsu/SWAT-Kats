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

public class GetGameStateResource extends ServerResource{
private MuddyGame game;
	
    @Get
    public JsonRepresentation represent() throws IOException {
    	
    	game = SingletonGameClass.getGameInstance();
    	
    	JSONObject response = new JSONObject();
    	response.put("currentGameState", game.getCurrentGameState());
    	
        return (new JsonRepresentation(response));
    }

}
