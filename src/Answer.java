/**
 * This class represents an simple answer
 * 
 *
 */
public class Answer {
	/**
	 * the answer text
	 */
	private String text;
	/**
	 * True means: Answer is correct
	 */
	boolean isCorrect;
	
	/**
	 * Constructor
	 * @param text
	 * @param isCorrect
	 */
	Answer(String text, boolean isCorrect)
	{
		this.text = text;
		this.isCorrect = isCorrect;
	}
	
	/**
	 * get the answer text
	 * @return
	 */
	public String getText()
	{
		return this.text;
	}
	/**
	 * check if this answer is correcrt
	 * @return boolean
	 */
	public boolean isAnswerCorrect()
	{
		return this.isCorrect;
	}
}
