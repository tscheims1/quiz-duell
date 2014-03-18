import java.util.ArrayList;
import java.util.Collections;


public class Question {
	private ArrayList<Answer> answers;
	private String questionString;
	private final String[] ANSWER_LETTER = {"A","B","C","D"};
	
	public Question(String question,ArrayList<Answer> answers)
	{
		this.answers = answers;
		questionString = question;

		
		Collections.shuffle(this.answers);
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
	
	
}
