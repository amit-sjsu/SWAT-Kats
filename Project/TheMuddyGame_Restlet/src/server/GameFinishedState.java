package server;

public class GameFinishedState implements IState {
	  private MuddyGame game;

	  public GameFinishedState(MuddyGame _game) {
	    this.game = _game;
	  }

	  @Override
	  public void addPlayerOne(String playerName) {
	    System.out.println("Cannot add playerone Game Finshed state");
	  }

	  @Override
	  public void addPlayerTwo(String playerName) {
	    System.out.println("Cannot add playertwo Game Finshed state");
	  }

	  @Override
	  public void submitPlayerOneScore(String playerName, int score, int time) {
	    System.out.println("Cannot submit playerone score,  Game Finshed state");

	  }

	  @Override
	  public void submitPlayerTwoScore(String playerName, int score, int time) {
	    System.out.println("Cannot submit playerone score,  Game Finshed state");

	  }

	  @Override
	  public void startGame() {
	    System.out.println("Cannot start game, Game Finshed state");
	  }

	  @Override
	  public String toString(){
	    return "Game Finished State";
	  }

}
