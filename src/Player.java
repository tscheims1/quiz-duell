/**
 * 
 * @author James
 *
 */
public class Player {
	
	/**
	 * Players name
	 */
	private String name;
	/**
	 * the actual scorepoints
	 */
	int score;
	
	/**
	 * Constructor
	 * @param name
	 */
	Player(String name)
	{
		this.name = name;
		this.score = 0;
	}
	/**
	 * getter method for the player name
	 * @return string
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * increase the players score
	 */
	public void addScore()
	{
		score++;
	}
	/**
	 * get the actual players score
	 * @return int
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * get the player description (Score and his name)
	 * @return String
	 */
	public String getDescription()
	{
		return this.name+ " - "+this.score;
	}
}
