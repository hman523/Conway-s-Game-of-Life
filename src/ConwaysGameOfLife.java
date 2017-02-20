import java.awt.*;
import javax.swing.*;

public class ConwaysGameOfLife {
	
	private static Gamepanel panel;
	private static boolean[][] map;
	private static Score score;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Conway's Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		score = new Score();
		panel = new Gamepanel();
		panel.addMouseListener(new Click());
		frame.getContentPane().add(panel);
		frame.setSize(900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		map = new boolean[69][69];
	}
	
	public static boolean[][] getMap()
	{
		return map;
	}
	
	public static void alterMap(int row, int col, boolean isAlive)
	{
		map[row][col] = isAlive;
	}
	
	public static void fillMapRandomly()
	{
		
		for(int k = 0; k < panel.getNumForRand(); k++)
		{
			int rand1 = (int)(Math.random() * 69);
			int rand2 = (int)(Math.random() * 69);
			map[rand1][rand2] = true;
		}
		
	}

	public static void resetMap()
	{
		map = new boolean[69][69];
	}
	
	public static Gamepanel getPanel()
	{
		return panel;
	}
	
	public static void swapCell(int myX, int myY)
	{
		map[myX][myY] = !(map[myX][myY]);
	}
	
	public static void nextGeneration()
	{
		boolean[][] map2 = new boolean[69][69];
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map[0].length; y++){
				map2[x][y] = map[x][y];
			}
		}
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map[0].length; y++){
				if(map2[x][y]){
					if(willLive(x, y, map2)){
						map[x][y] = true;
					}
					else{
						map[x][y] = false;
					}
				}
				if(!map2[x][y] && canHaveNew(x, y, map2)){
					map[x][y] = true;
				}
			}
		}
		getScore().increment();
		
	}
	
	public static void printArray(boolean matrix[][]) {
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
	        	if (matrix[row][column])
	        		System.out.print("1" + "");
	        	else
	        		System.out.print("0" + "");
	        }
			System.out.println();
	    }
	}
	
	public static int getCountAround(int row, int col, boolean[][] matrix){
		boolean[][] grid = matrix;
		int countAround = 0;
		

		if (row != 0 && grid[row-1][col])	//left
			countAround++;
		if (row != 0 && col != 0 && grid[row-1][col-1])	//top left corner
			countAround++;
		if (col != 0 && grid[row][col-1])	//bottom
			countAround++;
		if (col != 0 && row != 68 && grid[row+1][col-1])	//top right corner
			countAround++;
		if (col != 68 && row != 68 && grid[row+1][col+1])	//bottom right corner
			countAround++;
		if (row != 68 && grid[row+1][col])	//right
			countAround++;
		if (row != 0 && col !=68 && grid[row-1][col+1])	//bottom left corner
			countAround++;
		if (col != 68 && grid[row][col+1])	//top
			countAround++;

		return countAround;
	}
	
	public static boolean willLive(int row, int col, boolean[][] matrix)
	{
		if (getCountAround(row, col, matrix) == 2 || getCountAround(row, col, matrix) == 3)
			return true;
		return false;
	}
	
	public static boolean canHaveNew(int row, int col, boolean[][] matrix)
	{
		if (getCountAround(row, col, matrix) == 3)
			return true;
		return false;
	}
	
	public static Score getScore(){
		return score;
	}
	
	public static boolean mapIsEmpty(){
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map[0].length; y++){
				if (map[x][y]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static int getPopulation(){
		int count = 0;
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map[0].length; y++){
				if (map[x][y]){
					count++;
				}
			}
		}
		return count;
	}
	
	public static void startSimulation(int count){
		System.out.println("Loop num: " + count);
		nextGeneration();
		panel.update();
		try{
			Thread.sleep(100);
		}
		catch(Exception e){
		}
		
		if(count > 0){
			startSimulation(count-1);
		}
		
	}
}
