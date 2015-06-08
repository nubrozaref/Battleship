import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

//HOW TO USE: Copy the format below, the addScore method contains a name first and then a score. If the score is higher than the
//last score on the list, it isn't put on it. The file named "High Scores" must be in final project folder (the one containing src).
//public static void main(String[] args) throws FileNotFoundException
//{
//	HighScores a = new HighScores();
//	int score = 15;
//	if (a.isOnList(score))
//	{
//		a.addScore("Max", score);
//	}
//}
public class HighScores {
	ArrayList<String> scoreFile = new ArrayList<String>();
	ArrayList<Integer> scores = new ArrayList<Integer>();
	public HighScores() throws FileNotFoundException
	{
//		Example list that the file is initialized as, stored here for resetting the file.
//		15 | Kanye West 
//		17 | Gucci Mane
//		18 | Chief Keef
//		20 | Juicy J
//		21 | Waka Flocka Flame
//		24 | Fetty Wap
//		27 | Cashy Kesh
//		29 | Lil Boosie 
//		30 | Young Thug
//		31 | Stitches
		File file = new File("High Scores");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) // Adds the scores to an array list in order.
		{
			scoreFile.add(scanner.nextLine());
		}
		Scanner scan = new Scanner(file);
        scan.nextLine();
        while (scan.hasNextInt())
        {
        	scores.add(scan.nextInt());
        	scan.nextLine();
        }
	}
	// Adds a score to the file.
	public void addScore(String name, int score)
	{
		BufferedWriter writer = null;
		try {
            File logFile = new File("High Scores");
            int indexOfScores = -1;
            while (indexOfScores == -1)
            {
            	for (int k = 0; k < scores.size(); k++)
                {
                	if (score <= scores.get(k) && indexOfScores == -1)
                	{
                		indexOfScores = k;
                	}
                }
            }
            scoreFile.add(indexOfScores + 1, score + " | " + name);
            writer = new BufferedWriter(new FileWriter(logFile));
            String newLine = System.getProperty("line.separator");
            for (int i = 0; i < 10; i++)
            {
            	writer.write(scoreFile.get(i) + newLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
	}
	public boolean isOnList(int score)
	{
		if (score > scores.get(scores.size() - 1))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
