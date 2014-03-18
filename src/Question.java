import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Question {
	private ArrayList<Answer> answers;
	private String questionString;
	private final String[] ANSWER_LETTER = {"A","B","C","D"};
	
	public Question(String question,ArrayList<Answer> answers)
	{
		this.answers = answers;
		questionString = question;

		long seed = System.nanoTime();
		Collections.shuffle(this.answers,new Random(seed)); 
	}
	
	public String getDescription()
	{
		String s = "";
		s += questionString+"\n";
		int count = 0;
		for(Answer a : answers)
		{
			s += ANSWER_LETTER[count++]+": "+a.getText()+"\n";
		}
		return s;
		
	}
	public boolean isRightAnswer(int number)
	{
		return answers.get(number).isAnswerCorrect();
	}
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
