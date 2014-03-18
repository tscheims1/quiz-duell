
public class Quiz {

	int number;
	private Player players[];
	private static final int MAX_ROUNDS = 6;
	private int currentRound = 0;
	private int currentPlayer = 0;
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
	public String getDescription()
	{
		String s = "Duell: "+number+" "+players[0].getName()+" - "+players[1].getName()+" : Round: "+ currentRound +": PLAYER: "+(currentPlayer+1);
		
		return s;
	}
	public String displayQuestion()
	{
		return quizRound[currentRound].displayQuestion();
	}
	public String answerQuestion(int number)
	{
		if(quizRound[currentRound].answerQuestion(number) == true)
			return "Correct answer";
		return "wrong answer";
			
	}
	public Player getCurrentPlayer()
	{
		return players[currentPlayer];
	}
	
}
