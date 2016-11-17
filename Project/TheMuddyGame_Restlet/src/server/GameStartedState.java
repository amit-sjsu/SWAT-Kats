package server;

public class GameStartedState implements IState {
	private MuddyGame game;

	  public GameStartedState(MuddyGame _game) {
	    this.game = _game;
	  }

	  @Override
	  public void addPlayerOne(String playerName) {
	    System.out.println("Game has started, cannot add playerOne");
	  }

	  @Override
	  public void addPlayerTwo(String playerName) {
	    System.out.println("Game has started, cannot add playerTwo");
	  }

	  @Override
	  public void submitPlayerOneScore(String playerName, int score,int time) {
	    System.out.println("Game has started, playerOne submitting score");
	    game.updatePlayerOneScore(playerName, score, time);
	    game.setState(game.getPlayerOneSubmittedScoreState());
	  }

	  @Override
	  public void submitPlayerTwoScore(String playerName, int score, int time) {
	    System.out.println("Game has started, cannot submit player two before");
	  }

	  @Override
	  public void startGame() {

	  }

	  @Override
	  public String toString(){
	    return "Game Started State";
	  }

}
