import java.util.Scanner;


public class QuizSimulator {
	
	/*
	 * Set the sates of the simulator
	 */
	private static final int LOGGED_OUT  =0;
	private static final int  LOGGED_IN =1;
	private static final int  QUIT = 2;
	
	
	public static void main(String [] args)
	{
		QuizSimulator qs = new QuizSimulator();
	}
	QuizSimulator()
	{
		QuizServer quizServer = new QuizServer();
		int currentState = LOGGED_OUT;
		while(true)
		{
			this.drawMenu();
			Scanner s  = new Scanner(System.in);
			String input = s.next();
			
			if(input.toLowerCase() == "i")
			{
				if(currentState == LOGGED_IN)
				{
					System.out.println("Sie sind bereits eingeloggt");
				}
				else
				{
					currentState = LOGGED_IN;
				}
			}
			if(input.toLowerCase() == "n")
			{
				if(currentState != LOGGED_IN)
				{
					System.out.println("Sie müssen sich zuerst einloggen");
				}
				else
				{
					
				}
			}
			if(input.toLowerCase() == "c")
			{
				if(currentState != LOGGED_IN)
				{
					System.out.println("Sie müssen sich zuerst einloggen");
				}
				else
				{
					
				}
			}
			if(input.toLowerCase() == "d")
			{
				if(currentState != LOGGED_IN)
				{
					System.out.println("Sie müssen sich zuerst einloggen");
				}
				else
				{
					
				}
			}
			if(input.toLowerCase() == "o")
			{
				if(currentState != LOGGED_OUT)
				{
					System.out.println("Sie sind bereits ausgeloggt");
				}
				else
				{
					currentState = LOGGED_OUT;
				}
			}
			if(input.toUpperCase() == "q")
			{
				currentState = QUIT;
				break;
			}
		}
	}
	private void drawMenu()
	{
		System.out.println("Log (i)n (n)ew duell (c)ontinue duell (d)isplay duells log (o)ut (q)uit");
	}
}
