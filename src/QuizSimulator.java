import java.util.HashMap;
import java.util.Scanner;


public class QuizSimulator {
	
	/*
	 * Set the sates of the simulator
	 */
	private static final int LOGGED_OUT  =0;
	private static final int  LOGGED_IN =1;
	private static final int IN_GAME = 3;
	private static final int  QUIT = 2;
	
	private HashMap<String,Integer> keyMap;
	
	
	public static void main(String [] args)
	{
		QuizSimulator qs = new QuizSimulator();
	}
	QuizSimulator()
	{
		
		QuizServer quizServer = new QuizServer();
		int currentState = LOGGED_OUT;
		Player currentPlayer = null;
		Quiz currentQuiz = null;
		
		keyMap = new HashMap();
		keyMap.put("a", 0);
		keyMap.put("b", 1);
		keyMap.put("c", 2);
		keyMap.put("d", 3);
		
		while(currentState != QUIT)
		{
			this.drawMenu();
			Scanner s  = new Scanner(System.in);
			String input = s.next();
			
			
			
			if(input.toLowerCase().equals("i"))
			{
				if(currentState == LOGGED_IN)
				{
					System.out.println("Sie sind bereits eingeloggt");
				}
				else
				{
					currentState = LOGGED_IN;
					System.out.println("Geben Sie den Usernamen ein");
					input = s.next();
					
					currentPlayer = quizServer.getPlayer(input);
				}
			}
			if(input.toLowerCase().equals("n"))
			{
				if(currentState != LOGGED_IN)
				{
					System.out.println("Sie müssen sich zuerst einloggen");
				}
				else
				{
					
						
					System.out.println(quizServer.getAvailablePlayers(currentPlayer));
					
					input = s.next();
					/*
					 * TODO: Check this input
					 */
					currentQuiz = quizServer.createQuiz(currentPlayer, input);
					if(currentQuiz == null)
					{
						System.out.println("Fehler beim Anlegen des Quizes");
					}
					else
					{	
						currentState = IN_GAME;
					
					}
				}
			}
			if(input.toLowerCase().equals("c"))
			{
				if(currentState != LOGGED_IN)
				{
					System.out.println("Sie müssen sich zuerst einloggen");
				}
				else
				{
					System.out.println(quizServer.getAvailableQuizes(currentPlayer));
					input = s.next();
					input = input.toLowerCase();
					
					currentQuiz = quizServer.getQuiz(currentPlayer, Integer.parseInt(input));
					if(currentQuiz == null)
					{
						System.out.println("Wrong Quiznumber");
					}
					{
						currentState = IN_GAME;
					}
				}
			}
			if(input.toLowerCase().equals("d"))
			{
				if(currentState != LOGGED_IN)
				{
					System.out.println("Sie müssen sich zuerst einloggen");
				}
				else
				{
					System.out.println(quizServer.getAvailableQuizes(currentPlayer));
				}
			}
			if(input.toLowerCase().equals("o"))
			{
				if(currentState == LOGGED_OUT)
				{
					System.out.println("Sie sind bereits ausgeloggt");
				}
				else
				{
					currentState = LOGGED_OUT;
				}
			}
			if(input.toLowerCase().equals("q"))
			{
				currentState = QUIT;
				s.close();
				
			}
			while(currentState == IN_GAME)
			{
				if(!currentQuiz.isFinished() && currentQuiz.getCurrentPlayer().getName().equals(currentPlayer.getName()))
				{
					System.out.println(currentQuiz.displayQuestion());
					input = s.next();
					input = input.toLowerCase();
					if(keyMap.containsKey(input))
					{
					
						System.out.println(currentQuiz.answerQuestion(keyMap.get(input)));
						System.out.println(currentQuiz.getCurrentPlayer().getName());
					}
				}
				else
				{
					currentState = LOGGED_IN;
				}
				
			
			}
			
		}
		
	}
	private void drawMenu()
	{
		System.out.println("Log (i)n (n)ew duell (c)ontinue duell (d)isplay duells log (o)ut (q)uit");
	}
	private void ingameLogic()
	{
		
	}
}
