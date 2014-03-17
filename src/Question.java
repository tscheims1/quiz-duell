import java.util.ArrayList;
import java.util.Collections;


public class Question {
	private ArrayList<Answer> answers;
	private String questionString;
	
	public Question()
	{
		answers = new ArrayList<Answer>();
		
		Collections.shuffle(answers);
	}
	
	public String getDescription()
	{
		String s = "";
		s += questionString;
		
		for(Answer a : answers)
		{
			s += a;
		}
		return s;
		
	}
	public boolean isRightAnswer(int number)
	{
		return false;
	}
	
	
}
