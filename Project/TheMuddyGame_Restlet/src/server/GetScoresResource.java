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
	//private List<String> users = new ArrayList<String>();
	//private String status;
	
    @Get
    public JsonRepresentation represent() throws IOException {
    	MuddyGame game = SingletonGameClass.getGameInstance();
    	System.out.println("Scores = "+game.getScores());
    	System.out.println("Decision = "+game.getGameScoreBoard());
    	JSONObject response = new JSONObject();
    	response.put("Scores", game.getScores());
    	response.put("Decision", game.getGameScoreBoard());
    	
        return (new JsonRepresentation(response));
    }

}
