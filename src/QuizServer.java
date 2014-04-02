import java.util.ArrayList;

/**
 * this class provides all necessary methods for the quizSimulator class
 * (e.g. add players, createQuizes, getAllAvailablePlayer)	
 * @author James
 *
 */
public class QuizServer {
	
	/**
	 * all players are stored in this variable
	 */
	ArrayList<Player> availablePlayers;
	
	/**
	 * a reference to the questionpool
	 */
	QuestionPool questionPool;
	/**
	 * all duells are stored here
	 */
	ArrayList<Quiz> allDuells;
	/**
	 * the constructor
	 */
	QuizServer()
	{
		allDuells = new ArrayList<Quiz>();
		availablePlayers = new ArrayList<Player>();
		questionPool = QuestionPool.getInstance();
		questionPool.readQuestions();
	}
	/**
	 * get a player, if the player dosent exists 
	 * a new player is created
	 * @param name
	 * @return Player
	 */
	public Player getPlayer(String name)
	{
		for(Player p : availablePlayers)
		{
			if(p.getName().equals(name))
				return p;
		}
		
		return this.CreatePlayer(name);
	}
	/**
	 * create a new player
	 * @param name
	 * @return Player
	 */
	private Player CreatePlayer(String name)
	{
		Player p = new Player(name);
		availablePlayers.add(p);
		return p;
	}
	/**
	 * display  all available Players
	 * @param currentPlayer
	 * @return String
	 */
	public String getAvailablePlayers(Player currentPlayer)
	{
		String s =  "";
		for(Player p: availablePlayers)
		{
			if(!currentPlayer.getName().equals(p.getName()))
			{
				s+= p.getName()+"\n";
			}
		}
		return s;
	}
	/**
	 * display all available Quizes
	 * @param currentPlayer
	 * @param finishedQuizes
	 * @return String
	 */
	public String getAvailableQuizes(Player currentPlayer,boolean finishedQuizes)
	{
		String s = "";
		for(Quiz q : allDuells)
		{
			if(q.isFinished() == finishedQuizes && q.getPlayers()[0].getName().equals(currentPlayer.getName()) || 
					q.getPlayers()[1].getName().equals(currentPlayer.getName()) && q.isFinished() == finishedQuizes)
			s += q.getDescription()+"\n";
		
		}
		return s;
	}
	/**
	 * get a Quiz reference, return null if the quiz doesnt exists
	 * @param currentPlayer
	 * @param number
	 * @return Quiz
	 */
	public Quiz getQuiz(Player currentPlayer,int number)
	{
		if ( number >= allDuells.size() || number < 0)
			return null;
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
	/**
	 * create a new quiz and return this quiz instance
	 * @param currentPlayer
	 * @param opponent
	 * @return Quiz
	 */
	public Quiz createQuiz(Player currentPlayer,String opponent)
	{
		boolean correctOpponent = false;
		for(Player p : availablePlayers)
		{
			if(p.getName().equals(opponent))
			{
				correctOpponent = true;
				break;
			}
		}
		
		if(!correctOpponent)return null;
		
		Quiz q = new Quiz(new Player(currentPlayer.getName()),new Player(opponent));
		allDuells.add(q);
		return q;
	}
}