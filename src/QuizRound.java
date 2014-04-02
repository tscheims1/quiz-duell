/**
 * this class represents a single quizround
 * @author James
 *
 */
public class QuizRound {
	/**
	 * the amount of questions in a quizround
	 */
	private final static int ROUND_AMOUNT = 3;
	
	/**
	 * the current question
	 */
	private int currentQuestion = 0;
	
	/**
	 * all questions are stored in this variable
	 */
	private Question questions[];
	
	/**
	 * The constructor (creates all questions for this round)
	 */
	QuizRound()
	{
		QuestionPool questionPool = QuestionPool.getInstance();
		
		questions = new Question[ROUND_AMOUNT];
		for(int i = 0; i < ROUND_AMOUNT; i++)
		{
			questions[i] = questionPool.getRandomQuestion();
		}
		
	}
	/**
	 * display the current question
	 * @return String
	 */
	public String displayQuestion()
	{
		return questions[currentQuestion].getDescription();
	}
	/**
	 * check the answer of the current question
	 * @param number
	 * @return boolean
	 */
	public boolean answerQuestion(int number)
	{
		return questions[currentQuestion].isRightAnswer(number);
	}
	/**
	 * get the answer of the current question
	 * @return String
	 */
	public String getCorrectAnswer()
	{	
		return questions[currentQuestion].getCorrectAnswer();
		
	}
	/**
	 * check if this round has a next question
	 * @return boolean
	 */
	public boolean nextQuestion()
	{
		currentQuestion++;
		if(currentQuestion >= ROUND_AMOUNT)
		{
			currentQuestion = 0;
			return false;
		}
		return true;
	}
}