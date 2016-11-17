package server;

public class SingletonGameClass {
	private static MuddyGame gameInstance;
	public static MuddyGame getGameInstance(){
		if(gameInstance == null){
			gameInstance = new MuddyGame();
		}
		return gameInstance;
	}

}
