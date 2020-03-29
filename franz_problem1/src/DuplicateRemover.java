import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover
{
	HashSet<String> uniqueWords = new HashSet<>();
	
	public void remove(String dataFile)
	{
		try
		{
			Scanner in = new Scanner(new File(dataFile));

			while (in.hasNext())
				uniqueWords.add(in.next().toLowerCase());
			
			in.close();
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("File not found in remove method! Please check your filepath and try again");
			System.exit(0);
		}
	}
	
	public void write(String outputFile)
	{
		try
		{
			PrintWriter writer = new PrintWriter(new File(outputFile));
			
			for (String s : uniqueWords)
			{
				writer.println(s);
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