package server;

public class TwoPlayerState implements IState{
	  private MuddyGame game;

	  public TwoPlayerState(MuddyGame _game) {
	    this.game = _game;
	  }

	  @Override
	  public void addPlayerOne(String playerName) {
	    System.out.println("Game is about to start, cannot add playerone");
	  }

	  @Override
	  public void addPlayerTwo(String playerName) {
	    System.out.println("Game is about to start, cannot add playertwo");
	  }

	  @Override
	  public void submitPlayerOneScore(String playerName, int score, int time) {
	    System.out.println("Game is about to start, cannot submit subscore playerone");
	  }

	  @Override
	  public void submitPlayerTwoScore(String playerName, int score, int time) {
	    System.out.println("Game is about to start, cannot submit subscore playerTwo");
	  }

	  @Override
	  public void startGame() {
	    System.out.println("Lets Start Game, both players added");
	    game.startingGame();
	    game.setState(game.getGameStartedState());
	  }

	  @Override
	  public String toString() {
	    return "TwoPlayerState";
	  }

}
