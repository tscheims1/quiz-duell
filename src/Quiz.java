
public class Quiz {

	int number;
	private Player players[];
	private static final int MAX_ROUNDS = 6;
	private int currentRound = 0;
	private int currentPlayer = 0;
	private boolean isFinished = false;
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
		String s = "Duell: "+number+" "+players[0].getDescription()+" - "+players[1].getDescription()+" : Round: "+ currentRound +": PLAYER: "+(currentPlayer+1);
		if(this.isFinished == true)
		{
			s+= "FINISHED";
			if(this.players[0].getScore() > this.players[1].getScore())
			{
				s += "Player 1 WON";
			}
			else if (this.players[0].getScore() > this.players[1].getScore())
			{
				s+= "Player 2 WON";
			}
			else
				s+= "Game ends in a draw";
		}
			return s;
	}
	public String displayQuestion()
	{
		return quizRound[currentRound].displayQuestion();
	}
	public String answerQuestion(int number)
	{
		String resp  = "";
		if(quizRound[currentRound].answerQuestion(number) == true)
		{
			resp =  "Correct answer";
			players[currentPlayer].addScore();
		}
			
		else
		{
			resp =  "wrong answer - "+quizRound[currentRound].getCorrectAnswer();
		}
		if(!quizRound[currentRound].nextQuestion())
		{
			
			currentRound++;
			currentPlayer = currentPlayer == 1 ? 0:1;
			if(currentRound == MAX_ROUNDS )
				isFinished = true;
		}
		return resp;
			
	}
	public Player getCurrentPlayer()
	{
		return players[currentPlayer];
	}
	public boolean isFinished()
	{
		return this.isFinished;
	}
	
}
