
public class QuizRound {
	private final static int ROUND_AMOUNT = 3;
	private int currentQuestion = 0;
	
	private Question questions[];
	
	QuizRound()
	{
		QuestionPool questionPool = new QuestionPool();
		
		questions = new Question[ROUND_AMOUNT];
		for(int i = 0; i < ROUND_AMOUNT; i++)
		{
			questions[i] = questionPool.getRandomQuestion();
		}
		
	}
	public String displayQuestion()
	{
		return questions[currentQuestion].getDescription();
	}
	public boolean answerQuestion(int number)
	{
		return questions[currentQuestion].isRightAnswer(number);
	}
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
