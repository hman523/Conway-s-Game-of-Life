import java.awt.*;
import javax.swing.*;

public class Line {

	public Line()
	{
		
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		for(int x = 0; x < 70; x++)
		{
			g.drawLine(x*10, 0, x*10, 700);
		}
		for(int x = 0; x < 70; x++)
		{
			g.drawLine(0, x*10, 690, x*10);
		}
	}
}
