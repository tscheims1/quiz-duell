import java.util.ArrayList;

	
public class QuizServer {
	ArrayList<Player> availablePlayers;
	QuestionPool questionPool;
	ArrayList<Quiz> allDuells;
	
	QuizServer()
	{
		allDuells = new ArrayList<Quiz>();
		availablePlayers = new ArrayList<Player>();
		questionPool = new QuestionPool();
		questionPool.readQuestions();
	}
	public Player getPlayer(String name)
	{
		for(Player p : availablePlayers)
		{
			if(p.getName().equals(name))
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
	public String getAvailablePlayers(Player currentPlayer)
	{
		String s = "available Opponents\n";
		for(Player p: availablePlayers)
		{
			if(!currentPlayer.getName().equals(p.getName()))
			{
				s+= p.getName()+"\n";
			}
		}
		return s;
	}
	public Quiz getQuiz(Player currentPlayer,int number)
	{
		Quiz duell = allDuells.get(number);
			
		if(duell == null)
			return null;
		/*
		 * is the current Player in this duell
		 */
		if(duell.getPlayers()[0].getName().equals(currentPlayer.getName()) ||
		 duell.getPlayers()[1].getName().equals(currentPlayer.getName()))
		 	return duell;
		return null;
	}
	public Quiz createQuiz(Player currentPlayer,String opponent)
	{
		Quiz q = new Quiz(currentPlayer,getPlayer(opponent));
		allDuells.add(q);
		return q;
	}
}
