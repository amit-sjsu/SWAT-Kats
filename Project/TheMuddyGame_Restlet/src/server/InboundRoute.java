package server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class InboundRoute extends Application{
	@Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/addPlayer", AddPlayerResource.class);
        router.attach("/getGameState", GetGameStateResource.class);
        router.attach("/getScores", GetScoresResource.class);
        router.attach("/submitScore", SubmitScoreResource.class);

        return router;
    }

}
