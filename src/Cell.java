import java.awt.*;

public class Cell {
	
	private int side, row, col;
	private Color color;
	private boolean isAlive;
	
	public Cell(int myrow, int mycol, boolean myIsAlive)
	{
		side = 10;
		row = myrow;
		col = mycol;
		isAlive = myIsAlive;
		if(isAlive){
			color = Color.BLACK;
		}
		else{
			color = Color.WHITE;
		}
	}
	
	public int getCountAround()
	{
		boolean[][] map = ConwaysGameOfLife.getMap();
		int countAround = 0;
		

		if (row != 0 && map[row-1][col])	//left
			countAround++;
		if (row != 0 && col != 0 && map[row-1][col-1])	//top left corner
			countAround++;
		if (col != 0 && map[row][col-1])	//bottom
			countAround++;
		if (col != 0 && row != 68 && map[row+1][col-1])	//top right corner
			countAround++;
		if (col != 68 && row != 68 && map[row+1][col+1])	//bottom right corner
			countAround++;
		if (row != 68 && map[row+1][col])	//right
			countAround++;
		if (row != 0 && col !=68 && map[row-1][col+1])	//bottom left corner
			countAround++;
		if (col != 68 && map[row][col+1])	//top
			countAround++;

		return countAround;
		
	}
	
	public boolean willLive()
	{
		if (getCountAround() < 2 || getCountAround() > 3)
			return false;
		return true;
	}
	
	public boolean canHaveNew()
	{
		if (getCountAround() == 2 || getCountAround() == 3)
			return false;
		return true;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(row * 10, col * 10, side, side);
	}
	
}
