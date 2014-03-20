import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class QuestionPool {
	
	private ArrayList<Question>questions;
	private static QuestionPool instance;
	private QuestionPool()
	{
		
	}
	
	public static QuestionPool  getInstance()
	{
		if(instance == null)
		{
			instance = new QuestionPool();
		}
		return instance;
	}

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
				System.out.println(s);
				String [] answers = s.split("\",\"");
				ArrayList<Answer> answerList = new ArrayList<Answer>();
				for(int i = 0; i < answers.length;i++)
				{
					
					answers[i] = answers[i].replaceAll("\"","");
					System.out.println(answers[i]);
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
	public Question getRandomQuestion()
	{
		Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(questions.size());
        
		return questions.get(index);
	}
}
