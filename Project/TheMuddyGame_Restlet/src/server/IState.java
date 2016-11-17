package server;

public interface IState {
	public void addPlayerOne(String playerName);
	public void addPlayerTwo(String playerName);
	public void submitPlayerOneScore(String playerName, int score, int time);
	public void submitPlayerTwoScore(String playerName, int score, int time);
	public void startGame();
}
