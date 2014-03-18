
public class Player {
	private String name;
	int score;
	
	Player(String name)
	{
		this.name = name;
		this.score = 0;
	}
	
	public String getName()
	{
		return name;
	}
	public void addScore()
	{
		score++;
	}
	public int getScore()
	{
		return score;
	}
	public String getDescription()
	{
		return this.name+ " - "+this.score;
	}
}
