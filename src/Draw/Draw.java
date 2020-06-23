package Draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Inrastructure.Main;

public class Draw extends JPanel{
	
	public void paint(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1200, 800);
		
		Main.gf.setupDraw(g);
		casedraw(g);
	}
	
	public void casedraw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 25, 800);
		g.fillRect(0, 0, 1200, 15);
		g.fillRect(0, 736, 1200, 40);
		g.fillRect(826, 0, 40, 800);
	}
}




class DrawThread extends Thread {
	public Draw draw;
	
	public DrawThread() {
		draw = new Draw();
		super.start();
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			draw.repaint();
		}
	}
}
