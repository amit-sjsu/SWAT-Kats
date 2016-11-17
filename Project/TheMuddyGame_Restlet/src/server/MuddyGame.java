package server;

public class MuddyGame implements IGame {
	  IState noPlayerState;
	  IState onePlayerState;
	  IState twoPlayerState;
	  IState gameStartedState;
	  IState playerOneSubmittedScoreState;
	  IState playerTwoSubmittedScoreState;
	  IState gameFinishedState;
	  IState state;
	  String playerOne;
	  String playerTwo;

	  int playerOneScore;
	  int playerTwoScore;
	  int playerOneTime;
	  int playerTwoTime;

	  public MuddyGame(){
		  noPlayerState = new NoPlayerState(this);
		  onePlayerState = new OnePlayerSate(this);
		  twoPlayerState = new TwoPlayerState(this);
		  gameStartedState = new GameStartedState(this);
		  playerOneSubmittedScoreState = new PlayerOneSubmittedScoreState(this);
		  gameFinishedState = new GameFinishedState(this);
		  state = noPlayerState;
	  }

	  void setState(IState state) {
	    this.state = state;
	  }

	  public void addPlayerOne(String playerName) {
	    state.addPlayerOne(playerName);
	  }

	  public void updatePlayerOne(String playerName) {
	    playerOne = playerName;
	  }

	  public void addPlayerTwo(String playerName) {
	    playerTwo = playerName;
	    state.addPlayerTwo(playerName);
	  }

	  public void updatePlayerTwo(String playerName) {
	    playerTwo = playerName;
	  }

	  public IState getOnePlayerState() {
	    return onePlayerState;
	  }

	  public IState getTwoPlayerState() {
	    return twoPlayerState;
	  }

	  public IState getGameStartedState() {
	    return gameStartedState;
	  }

	  public IState getPlayerOneSubmittedScoreState() {
	    return playerOneSubmittedScoreState;
	  }

	  public IState getPlayerTwoSubmittedScoreState() {
	    return playerTwoSubmittedScoreState;
	  }

	  public void submitPlayerOneScore(String playerName, int score, int time) {
	    state.submitPlayerOneScore(playerName, score, time);
	  }

	  public void updatePlayerOneScore(String playerName, int score, int time) {
	    playerOne = playerName;
	    playerOneScore = score;
	    playerOneTime = time;
	  }

	  @Override
	  public void submitPlayerTwoScore(String playerName, int score, int time) {
	    state.submitPlayerTwoScore(playerName, score, time);
	  }

	  public void updatePlayerTwoScore(String playerName, int score, int time) {
	    playerTwo = playerName;
	    playerTwoScore = score;
	    playerTwoTime = time;
	  }

	  public IState getCurrentGameState() {
	    return state;
	  }

	  public void startGame() {
	    state.startGame();
	    //System.out.println("Game Started");
	  }

	  public void startingGame(){

	  }

	  @Override
	  public String getGameScroreBoard() {

	    String scoreBoard = playerOne + " - " + playerOneScore;
	    scoreBoard += "  |  " + playerTwo + " - " + playerTwoScore;
	    return scoreBoard;
	  }

	  public IState getGameFinishedState() {
	    return gameFinishedState;
	  }

}
