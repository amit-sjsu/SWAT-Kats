package server;

public interface IGame {
	public void addPlayerOne(String playerName);
	public void addPlayerTwo(String playerName);
	public void submitPlayerOneScore(String playerName, int score, int time);
	public void submitPlayerTwoScore(String playerName, int score, int time);
	public IState getCurrentGameState();
	public void startGame();
	public String getGameScroreBoard();
}
