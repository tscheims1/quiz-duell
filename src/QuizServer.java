import java.util.ArrayList;

	
public class QuizServer {
	ArrayList<Player> availablePlayers;
	QuestionPool questionPool;
	
	QuizServer()
	{
		questionPool = new QuestionPool();
		questionPool.readQuestions();
	}
	public Player getPlayer(String name)
	{
		for(Player p : availablePlayers)
		{
			if(p.getName() == name)
				return p;
		}
		
		return this.CreatePlayer(name);
	}
	private Player CreatePlayer(String name)
	{
		Player p = new Player(name);
		availablePlayers.add(p);
		return p;
	}
}
