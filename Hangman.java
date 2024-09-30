import java.util.ArrayList;

public class Hangman {
	private String input;
	private ArrayList<Character> words = new ArrayList<>();
	private boolean removePart = false;
	
	Hangman(String input, int stringSize)
	{
		// find out the word
		this.input = input;
		// erase previous game
		words.clear();
		for (int i = 0; i < stringSize; i++)
		{
			// add the letters not found
			words.add('_');
		}
	}
	
	public String returnChar(int index)
	{
		return words.get(index).toString();
	}
	
	public String returnWord()
	{
		return input;
	}
	
	public void checker(boolean check)
	{
		if (!check)
		{
			removePart = Boolean.TRUE;
		}
	}
	
	public Boolean getChecker()
	{
		return removePart;
	}
	
	public void setChecker()
	{
		removePart = Boolean.FALSE;
	}
	
	public boolean checkGuess(String guess)
	{
		ArrayList<Character> newWords = words;
		
		for (int i = 0; i < guess.length(); i++)
		{
			char letter = guess.charAt(i);
			if (letter == input.charAt(i))
			{
				words.set(i, letter);
			}
		}
		
		if (words.equals(newWords))
			checker(false);
		else
			checker(true);
		
		if (!words.contains('_'))
		{
			return true;
		}
		
		if (words.equals(newWords))
			checker(false);
		else
			checker(true);
		
		return false;	
	}
	
	public int getWordSize()
	{
		return input.length();
	}
	
	
	
	
}