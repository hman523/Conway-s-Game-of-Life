
public class Repainter implements Runnable {

	private Gamepanel panel = ConwaysGameOfLife.getPanel();
	
	@Override
	public void run() {
		 while (true) {
             try {
                 Thread.sleep(10);
             } catch (InterruptedException ex) {
             }
             panel.paintImmediately(0,0,900,700);
             
         }
		
	}

}
