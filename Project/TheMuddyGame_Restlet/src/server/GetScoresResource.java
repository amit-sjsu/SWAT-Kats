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

public class GetScoresResource extends ServerResource {
	private List<String> users = new ArrayList<String>();
	private String status;
	
    @Get
    public JsonRepresentation represent() throws IOException {
    	MuddyGame game = SingletonGameClass.getGameInstance();
    			
    	JSONObject response = new JSONObject();
    	response.put("userWithScore", game.getGameScroreBoard());
    	
        return (new JsonRepresentation(response));
    }

}
