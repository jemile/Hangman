import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Frame extends JFrame {
	/**
	 * 
	 */
	
	
	Words word;
	String chosenWord;
	Hangman hangman;
	
	JPanel panel;
	
	boolean checkGuess;
	
	private static final long serialVersionUID = 6440790967486081245L;
	
	public void startGame()
	{
		// https://pastebin.com/jTWsUbsK
		// random 854 items
		
		word = new Words(new Random().nextInt(853));
		chosenWord = word.getWord();
		hangman = new Hangman(chosenWord, chosenWord.length());
        clearPanel();
        this.add(printWord());
	}
	
	public JLabel winDisplay()
	{
		JLabel wins = new JLabel();
		wins.setFont(new Font("Times New Roman", Font.BOLD, 25));
		wins.setAlignmentY(JFrame.BOTTOM_ALIGNMENT);
		wins.setText("wins:" + Integer.toString(hangman.getWins()));
		
		return wins;
	}
	
	public JLabel wordToLabel()
	{
		JLabel word = new JLabel();
		word.setFont(new Font("Times New Roman", Font.BOLD, 35));
		String wordFromString = "";
		for (int i = 0; i < hangman.getWordSize(); i++)
		{
			wordFromString += hangman.returnChar(i);
			wordFromString += " ";
		}
		
		System.out.println(wordFromString);
		
		word.setText(wordFromString);
		
		return word;
	}
	
	public JPanel printWord()
	{
        if (panel == null) {
			panel = new JPanel();
			panel.setBounds(30, 10, 400, 75);
			panel.setBackground(Color.lightGray);
        }
		
		JLabel word = wordToLabel();
        panel.removeAll(); // Clear the old label
		panel.add(word);
		panel.add(winDisplay());
	    panel.revalidate();
	    panel.repaint();
		
		return panel;
	}
	
	public void clearPanel()
	{
        if (panel != null) {
		    panel.removeAll();
		    panel.revalidate();
		    panel.repaint();
        }
	}
	
	public void createGame()
	{
		String guess = JOptionPane.showInputDialog("Guess:");
		if (guess == null || guess.isEmpty() || guess.length() > chosenWord.length()) {
	        JOptionPane.showMessageDialog(panel, "Please enter a valid item.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		checkGuess = hangman.checkGuess(guess);
		clearPanel();
		this.add(printWord());
		
		if (checkGuess)
		{
			hangman.setWins(hangman.getWins() + 1);
	        startGame();
		} 
	}
	
	Frame() {
		int width = 500;
		int height = 600;
		this.setTitle("Hangman Game - github.com/@jemile");
		this.setResizable(false);	
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(20, 50, 150));
		
		ImageIcon icon = new ImageIcon("calc.png");
		this.setIconImage(icon.getImage());
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 10, 470, 75);
		panel.setBackground(new Color(25, 75, 150, 180));
		panel.setVisible(true);
		
		startGame();
	
		JButton makeGuess = new JButton();
		makeGuess.setVisible(true);
		makeGuess.setFocusPainted(false);
		makeGuess.setBounds(240, 110, 250, 125);
		makeGuess.setText("Take Guess");
		makeGuess.addActionListener(e -> createGame());
				
		this.add(makeGuess);
	}
}