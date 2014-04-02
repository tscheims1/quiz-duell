import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * this class represents the questionpool
 * in this pool all question are stored
 * @author James
 *
 */
public class QuestionPool {
	/**
	 * all questions are stored in this variable
	 */
	private ArrayList<Question>questions;
	/**
	 * static Object instance
	 */
	private static QuestionPool instance;
	/**
	 * Private Constructor
	 */
	private QuestionPool(){}
	/**
	 * get Singleton Instance
	 */
	public static QuestionPool  getInstance()
	{
		if(instance == null)
		{
			instance = new QuestionPool();
		}
		return instance;
	}
	/**
	 * this method read all questions from a csv file
	 */
	void readQuestions()
	{
		questions = new ArrayList<Question>();
		try {
			FileReader fr = new FileReader("questions.txt");
			
			Scanner scanner = new Scanner(fr);
			while(scanner.hasNext())
			{
				String s = scanner.nextLine();
				/*
				 * remove the "-tockens
				 */
				//System.out.println(s);
				String [] answers = s.split("\",\"");
				ArrayList<Answer> answerList = new ArrayList<Answer>();
				for(int i = 0; i < answers.length;i++)
				{
					
					answers[i] = answers[i].replaceAll("\"","");
					//System.out.println(answers[i]);
					if(i != 0)
					{
						if(i == 1)
							answerList.add(new Answer(answers[i],true));
						else
							answerList.add(new Answer(answers[i],false));
					}
				}
				
				questions.add(new Question(answers[0],answerList));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * get a random question
	 * @return Question
	 */
	public Question getRandomQuestion()
	{
		Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(questions.size());
        
		return questions.get(index);
	}
}