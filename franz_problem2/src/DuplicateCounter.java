import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter
{
	HashMap<String, Integer> wordCounter = new HashMap<>();
	
	public void count(String dataFile)
	{
		try
		{
			Scanner in = new Scanner(new File(dataFile));

			while (in.hasNext())
			{
				String s = in.next().toLowerCase();
				
				if (!wordCounter.containsKey(s))
				{
					wordCounter.put(s, 1);
				}
				else
				{
					int temp = wordCounter.remove(s);
					wordCounter.put(s, temp + 1);
				}
			}
			
			in.close();
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("File not found in count method! Please check your filepath and try again");
			System.exit(0);
		}
	}
	
	public void write(String outputFile)
	{
		try
		{
			PrintWriter writer = new PrintWriter(new File(outputFile));
			
			for (String s : wordCounter.keySet())
			{
				writer.println(s + ": " + wordCounter.get(s) + " occurence" + (wordCounter.get(s) != 1 ? "s" : ""));
			}
			
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error writing to file in write method! Please check your filepath and try again");
			System.exit(0);
		}
	}
}