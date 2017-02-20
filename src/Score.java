import java.awt.*;

public class Score {

	private int generations;
	
	public Score()
	{
		generations = 1;
	}
	
	public int getGenerations()
	{
		return generations;
	}
	
	public void increment()
	{
		generations++;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		g.drawString("Generations: " + generations, 700, 20);
	}
	
	public void resetScore()
	{
		generations = 1;
	}
}
