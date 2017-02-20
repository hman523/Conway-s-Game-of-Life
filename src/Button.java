import java.awt.*;
import javax.swing.*;

public class Button {

	private int x, y, width, height;
	private Color color;
	private String content;
	
	public Button(int myx, int myy, int mywidth, int myheight, Color mycolor, String mycontent)
	{
		x = myx;
		y = myy;
		width = mywidth;
		height = myheight;
		color = mycolor;
		content = mycontent;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawString(content, x + 5, y + 15);
	}
	
	public boolean isPressed(int mouseX, int mouseY) 
	{
		if ((mouseX > getX() && mouseX < getX() + getWidth()) && mouseY > getY() && mouseY < getY() + getHeight())
		{
			return true;
		}
		return false;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
