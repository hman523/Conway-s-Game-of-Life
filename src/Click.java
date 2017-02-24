import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Click implements MouseListener
{

	static boolean pausePressed = false;
	
	
	public void mouseClicked(MouseEvent e) 
	{
		if(Gamepanel.getClear().isPressed(e.getX(), e.getY()))
		{
			ConwaysGameOfLife.resetMap();
			ConwaysGameOfLife.getScore().resetScore();
			//ConwaysGameOfLife.getPanel().update();
		}
		
		if(Gamepanel.getFillRandom().isPressed(e.getX(), e.getY()))
		{
			ConwaysGameOfLife.resetMap();
			ConwaysGameOfLife.fillMapRandomly();
			//ConwaysGameOfLife.getPanel().update();
			ConwaysGameOfLife.getScore().resetScore();
		}
		
		if(Gamepanel.getPlus().isPressed(e.getX(), e.getY()))
		{
			ConwaysGameOfLife.getPanel().upNumForRand();
			//ConwaysGameOfLife.getPanel().update();
		}
		
		if(Gamepanel.getMinus().isPressed(e.getX(), e.getY()))
		{
			ConwaysGameOfLife.getPanel().downNumForRand();
			//ConwaysGameOfLife.getPanel().update();
		}
		
		if(Gamepanel.getNext().isPressed(e.getX(), e.getY()))
		{
			ConwaysGameOfLife.nextGeneration();
			
			//System.out.println(ConwaysGameOfLife.getScore().getGenerations());
			//ConwaysGameOfLife.getPanel().update();

		}
		
		if(Gamepanel.getPlay().isPressed(e.getX(), e.getY()))
		{
			ConwaysGameOfLife.startSimulation();
		}
		
		if(Gamepanel.getPause().isPressed(e.getX(), e.getY())){
			pausePressed = true;
			
		}
		
		
	}

	public void mousePressed(MouseEvent e) 
	{
		
		if((e.getX() > 0 && e.getX() < 700 && e.getY() > 0 && e.getY() < 700))
		{
			int x = (e.getX()/10);
			int y = (e.getY()/10);
			ConwaysGameOfLife.swapCell(x, y);
			//ConwaysGameOfLife.getPanel().update();
		}
	}

	
	public void mouseReleased(MouseEvent e) 
	{
		
		
	}

	
	public void mouseEntered(MouseEvent e) 
	{
		
		
	}

	
	public void mouseExited(MouseEvent e) 
	{
		
		
	}
	
	public boolean getPausePressed(){
		return pausePressed;
	}

}
