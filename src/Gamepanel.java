import java.awt.*;
import javax.swing.*;

public class Gamepanel extends JPanel{
	
	static Button clear, fillRandom, plus, minus, next, play, pause;
	static int numForRand = 700;
	public Gamepanel()
	{
		setBackground(Color.white);
		
	}
	
	public void paintComponent(Graphics g)
	{
		boolean[][] map = ConwaysGameOfLife.getMap();
		super.paintComponent(g);
		for (int k = 0; k < 69; k++)
		{
			for (int m = 0; m < 69; m++)
			{
				if(map[k][m])
				{
					Cell cell = new Cell(k,m, true);
					cell.draw(g);
				}
				else{
					Cell cell = new Cell(k,m, false);
					cell.draw(g);
				}
			}
		}
		Color buttonColor = new Color(250, 40, 80);
		Line grid = new Line();
		grid.draw(g);
		clear = new Button(750, 100, 60, 20, buttonColor, "Clear");
		clear.draw(g);
		fillRandom = new Button(750, 150, 90, 20, buttonColor, "Fill Randomly");
		fillRandom.draw(g);
		Score score = ConwaysGameOfLife.getScore();
		score.draw(g);
		minus = new Button(760, 175, 15, 20,buttonColor, "-");
		minus.draw(g);
		plus = new Button(810, 175, 15, 20, buttonColor, "+");
		plus.draw(g);
		next = new Button(750, 200, 60, 20, buttonColor, "Next");
		next.draw(g);
		
		play = new Button(750, 240, 60, 20, buttonColor, "Play");
		play.draw(g);
		pause = new Button(750, 280, 60, 20, buttonColor, "Pause");
		pause.draw(g);
		
		
		g.drawString("" + numForRand, 780, 190);
		g.drawString("Population: " + ConwaysGameOfLife.getPopulation(), 700, 35);
		
	}
	
	public void update()
	{
		this.repaint();
	}
	
	public static Button getClear()
	{
		return clear;
	}
	
	public static Button getFillRandom()
	{
		return fillRandom;
	}
	
	public static Button getPlus()
	{
		return plus;
	}
	
	public static Button getMinus()
	{
		return minus;
	}
	
	public static void upNumForRand()
	{
		if(numForRand < 4900)
			numForRand+=100;
	}
	
	public static void downNumForRand()
	{
		if(numForRand > 0)
			numForRand-=100;
	}
	
	public static int getNumForRand()
	{
		return numForRand;
	}
	
	public static Button getPlay()
	{
		return play;
	}
	
	public static Button getPause()
	{
		return pause;
	}
	
	public static Button getNext()
	{
		return next;
	}
}
