import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class speechAnalyzer {
	
	ArrayList<String> pos;
	ArrayList<String> neg;
	ArrayList<String> dict;
	Map<String, Integer> textFreq;
	Map<String, String> posNeg;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		speechAnalyzer app = new speechAnalyzer();
		app.loadWords();
		app.loadSpeech();
		app.printFile();
	}
	
	public speechAnalyzer()
	{
		//nothing
	}
	
	private void loadWords() throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("positive.txt")).useDelimiter("\\s+");
		pos = new ArrayList<>();
		neg = new ArrayList<>();
		dict = new ArrayList<>();
		
		while(scan.hasNext())
		{
			pos.add(scan.next());
		}
		
		scan = new Scanner(new File("negative.txt")).useDelimiter("\\s+");
		
		while(scan.hasNext())
		{
			neg.add(scan.next());
		}
		scan.close();
		
		scan = new Scanner(new File("dictionary.txt")).useDelimiter("\\s+");
		
		while(scan.hasNext())
		{
			dict.add(scan.next());
		}
		scan.close();
		
	}
	
	private void loadSpeech() throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("speech.txt")).useDelimiter("(\\p{javaWhitespace}|\\.|,)+");
		textFreq = new HashMap<>();
		posNeg = new HashMap<>();
		
		String temp = "";
		int freq = 0;
		
		while(scan.hasNext())
		{
			temp = scan.next().toLowerCase();

			if(!textFreq.containsKey(temp))
			{
				if(pos.contains(temp))
				{
					textFreq.put(temp, 1);
					posNeg.put(temp, "positive");
				}
				else if(neg.contains(temp))
				{
					textFreq.put(temp, 1);
					posNeg.put(temp, "negative");
				}
				else if(dict.contains(temp))
				{
					textFreq.put(temp, 1);
					posNeg.put(temp, "neutral");
				}
					
			}
			else
			{
				freq = textFreq.get(temp);
				freq++;
				textFreq.put(temp, freq);
			}
				
		}
		
		scan.close();
	}
	
	private void printFile()
	{
		System.out.println("word,id,connotation,frequency,wordlen");
		int i = 0;
		for(String temp : textFreq.keySet())
		{
			System.out.println(temp + "," + i++ + "," + posNeg.get(temp) + "," + textFreq.get(temp) + "," + temp.length());
		}
	}
	
	
	

}
