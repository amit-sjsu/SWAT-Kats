package server;

public class NoPlayerState implements IState {
private MuddyGame game ;
    
    public NoPlayerState(MuddyGame _game)
    {
        this.game = _game;
    }
    
    public void addPlayerOne(String playerName)
    {
        System.out.println("In NoPLayer State , adding one player");
        game.updatePlayerOne(playerName);
        game.setState(game.getOnePlayerState());
    }

    public void addPlayerTwo(String playerName)
    {
        System.out.println("In NoPLayer State , have to add first player one");
    }
    
    public void submitPlayerOneScore(String playerName, int score, int time, String sol)
    {
        System.out.println("cannot submit score, in no player state");
    }

    @Override
    public void submitPlayerTwoScore(String playerName, int score, int time, String sol) {
    	System.out.println("cannot submit score, in no player state");
    }

    @Override
    public void startGame() {
    	System.out.println("Cannot start game, noplyers connected");
    }

    public String toString()
    {
        return "NoPlayerState";
    }


}
