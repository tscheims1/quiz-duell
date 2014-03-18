
public class Answer {
	private String text;
	boolean isCorrect;
	
	Answer(String text, boolean isCorrect)
	{
		this.text = text;
		this.isCorrect = isCorrect;
	}
	
	public String getText()
	{
		return this.text;
	}
	public boolean isAnswerCorrect()
	{
		return this.isCorrect;
	}
}
