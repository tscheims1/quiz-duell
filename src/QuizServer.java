import java.util.ArrayList;

	
public class QuizServer {
	ArrayList<Player> availablePlayers;
	QuestionPool questionPool;
	
	QuizServer()
	{
		questionPool = new QuestionPool();
		questionPool.readQuestions();
	}
}
