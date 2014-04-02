import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * this class represent a single question
 * @author James
 *
 */
public class Question {
	/**
	 * all answers are stored here
	 */
	private ArrayList<Answer> answers;
	/**
	 * the question as a string
	 */
	private String questionString;
	/**
	 * all allowed answerletters 
	 */
	private final String[] ANSWER_LETTER = {"A","B","C","D"};
	
	/**
	 * Constructor
	 * @param question
	 * @param answers
	 */
	public Question(String question,ArrayList<Answer> answers)
	{
		this.answers = answers;
		questionString = question;

		 
	}
	/**
	 * get the questions and all answers in a ramdon order
	 * @return String
	 */
	public String getDescription()
	{
		long seed = System.nanoTime();
		Collections.shuffle(this.answers,new Random(seed));
		
		String s = "";
		s += questionString+"\n";
		int count = 0;
		for(Answer a : answers)
		{
			s += ANSWER_LETTER[count++]+": "+a.getText()+"\n";
		}
		return s;
		
	}
	/**
	 * check if the given answer is correct
	 * @param number
	 * @return
	 */
	public boolean isRightAnswer(int number)
	{
		return answers.get(number).isAnswerCorrect();
	}
	/**
	 * get the correct answers as a string.
	 * @return String
	 */
	public String getCorrectAnswer()
	{
		for(int i = 0; i < answers.size(); i++)
		{
			if(answers.get(i).isAnswerCorrect())
			{
				return "The correct Answer was "+ANSWER_LETTER[i];
			}
		}
		return "";
	}
	
	
}