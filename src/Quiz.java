
public class Quiz {

	private Player players[];
	private static final int MAX_ROUNDS = 6;
	private int currentRound = 0;
	private QuizRound quizRound[];
	
	Quiz(Player a, Player b)
	{
		quizRound = new QuizRound[MAX_ROUNDS];
		for(int i = 0; i < MAX_ROUNDS;i++)
		{
			quizRound[i] = new QuizRound();
		}
		players = new Player[2];
		players[0] = a;
		players[1] = b;
	}
	
	public Player[] getPlayers()
	{
		return this.players;
	}
	
}
