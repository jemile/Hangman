// https://www.youtube.com/watch?v=f4T3uirbJqA
// we will be using this tutorial to find out how to scrape text files from the web
// in order to use them for a hang man game

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class Words 
{
	// https://pastebin.com/raw/jTWsUbsK 
	// words to be scraped
	private String chosenWord;
	private int count;
	
	Words(int index)
	{
		count = index;
		try
		{
			String fileUrl = "https://pastebin.com/raw/jTWsUbsK";
			URL url = new URL(fileUrl);
			try (InputStream is = url.openStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(is)))
			{
				while (count != 0)
				{
					String line = reader.readLine();
					chosenWord = line;
					count--;
				}
			}
		} catch (Exception e)
		{
			// in case of error print it out
			e.printStackTrace();
		}
	}
	
	public String getWord()
	{
		return chosenWord;
	}
}