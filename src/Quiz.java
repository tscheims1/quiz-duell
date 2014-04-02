/**
 * This class represent a singe Quiz
 * @author James
 *
 */
public class Quiz {

	/**
	 * the unique number of the quiz
	 */
	int number;
	
	/**
	 * the two players
	 */
	private Player players[];
	
	/**
	 * the round amount
	 */
	private static final int MAX_ROUNDS = 6;
	
	/**
	 * the current Round
	 */
	private int currentRound = 0;
	
	/**
	 * current player (0 or 1)
	 */
	private int currentPlayer = 0;
	
	/**
	 * is the quiz already finished?
	 */
	private boolean isFinished = false;
	
	/**
	 * all quizrounds are stored in this variable
	 */
	private QuizRound quizRound[];
	
	/**
	 * Constructor (creates a quiz with all rounds and questions)
	 * @param a
	 * @param b
	 */
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
	/**
	 * get all players
	 * @return Player[2]
	 */
	public Player[] getPlayers()
	{
		return this.players;
	}
	/**
	 * get the description of the quiz
	 * (the actual round, the sorce, and the current round)
	 * @return String
	 */
	public String getDescription()
	{
		String s = "Duell: "+number+" "+players[0].getDescription()+" - "+players[1].getDescription();
		if(this.isFinished == true)
		{
			s+= " : FINISHED";
			if(this.players[0].getScore() > this.players[1].getScore())
			{
				s += " : "+this.players[0].getName()+" WON";
			}
			else if (this.players[0].getScore() < this.players[1].getScore())
			{
				s+= ": "+this.players[0].getName()+" WON";
			}
			else
				s+= ": Game ends in a tie";
		}
		else
		{
			s+= " : Round: "+ currentRound +": PLAYER: "+(currentPlayer+1);
		}
			return s;
	}
	/**
	 * Displays the current question
	 * @return String
	 */
	public String displayQuestion()
	{
		return quizRound[currentRound].displayQuestion();
	}
	/**
	 * this method allow to answer a questions
	 * the answer is delegated to the QuizRound Class
	 * @param number
	 * @return String
	 */
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
	/**
	 * get the current player
	 * @return Player
	 */
	public Player getCurrentPlayer()
	{
		return players[currentPlayer];
	}
	/**
	 * check if the quiz is finished
	 * @return boolean
	 */
	public boolean isFinished()
	{
		return this.isFinished;
	}
	
}