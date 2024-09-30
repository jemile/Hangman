import java.util.ArrayList;
import javax.swing.JPanel;
// used to draw shapes
import java.awt.Graphics;

public class Figure {
	private ArrayList<Boolean> bodyParts = new ArrayList<>();
	private static int size = 6;
	private int count = 0;
	
	JPanel panel;
	
	Figure() {
		for (int i = 0; i < size; i++)
		{
			bodyParts.add(Boolean.TRUE);
		}
	}
	
	// need to learn how to make shapes
	
	// circle - head
	/*
	 * public Graphics head() { Graphics g = new Graphics(); int centerX = 150; int
	 * centerY = 150; int radius = 50; g.drawOval(centerX - radius, centerY -
	 * radius, 2 * radius, 2 * radius);
	 * 
	 * return g; }
	 */
	
	// neck - line
	
	// body - line
	
	// arms (2) - line
	
	// legs (2) - line
	
	
	public void removePanel()
	{
		if (panel != null) {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
		}
	}
	
	// remove by array list
	public void removePart()
	{
		bodyParts.set(count, Boolean.FALSE);
		// will need to reprint function after it, make sure to check each index of bodyparts to see if to print
		removePanel();		
		
		count++;
	}
	
	// reprint function
	// assuming we can add shapes into a JPanel
	// going to try to refrain from using pictures
	public JPanel printParts()
	{
		panel = new JPanel();
		
		
		return panel;
	}
	
	// function to return arraylist size
	public int bodySize()
	{
		return bodyParts.size();
	}
	
}