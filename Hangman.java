import java.util.ArrayList;

public class Hangman {
	private String input;
	private int winCount;
	private ArrayList<Character> words = new ArrayList<>();
	
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
	
	public boolean checkGuess(String guess)
	{
		boolean ifWon = false;
		
		for (int i = 0; i < guess.length(); i++)
		{
			char letter = guess.charAt(i);
			if (letter == input.charAt(i))
			{
				words.set(i, letter);
			}
		}
		
		if (!words.contains('_'))
		{
			ifWon = true;
		}
		
		return ifWon;	
	}
	
	public int getWins()
	{
		return winCount;
	}
	
	public void setWins(int wins)
	{
		winCount = wins;
	}
	
	public int getWordSize()
	{
		return input.length();
	}
	
	
	
	
}