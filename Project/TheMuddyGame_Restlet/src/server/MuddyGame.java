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
	  String playerOneSol;
	  String playerTwoSol;

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

	  public void submitPlayerOneScore(String playerName, int score, int time, String sol) {
	    state.submitPlayerOneScore(playerName, score, time,sol);
	  }

	  public void updatePlayerOneScore(String playerName, int score, int time, String sol) {
	    playerOne = playerName;
	    playerOneScore = score;
	    playerOneTime = time;
	    playerOneSol = sol;
	  }

	  @Override
	  public void submitPlayerTwoScore(String playerName, int score, int time, String sol) {
	    state.submitPlayerTwoScore(playerName, score, time,sol);
	  }

	  public void updatePlayerTwoScore(String playerName, int score, int time, String sol) {
	    playerTwo = playerName;
	    playerTwoScore = score;
	    playerTwoTime = time;
	    playerTwoSol = sol;
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
	  public String getGameScoreBoard() {
		  String scoreBoard="";
		  if(playerOneSol.equals("false")&&playerTwoSol.equals("false")){
			  scoreBoard="None";
		  }
		  else if(playerOneSol.equals("true")&&playerTwoSol.equals("false")){
			  scoreBoard=playerOne;
		  }
		  else if(playerOneSol.equals("false")&&playerTwoSol.equals("true")){
			  scoreBoard=playerTwo;
		  }
		  else if(playerOneSol.equals("true")&&playerTwoSol.equals("true")){
			  if(playerOneTime>playerTwoTime){
				  scoreBoard=playerOne;
			  }
			  else if(playerOneTime<playerTwoTime){
				  scoreBoard=playerTwo;  
			  }
			  else{
				  scoreBoard="Tie";
			  }
		  }
		  setState(noPlayerState);
	    return scoreBoard;
	  }
	  @Override
	  public String getScores(){
		  String score=playerOne+":"+playerOneScore+":"+playerOneTime+"||"+playerTwo+":"+playerTwoScore+":"+playerTwoTime;
		  
		  return score;
	  }

	  public IState getGameFinishedState() {
	    return gameFinishedState;
	  }

}
