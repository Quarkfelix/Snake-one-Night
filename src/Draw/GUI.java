package Draw;

import javax.swing.JFrame;

import IO.KeyHandler;

public class GUI extends JFrame{
	JFrame jf; 
	DrawThread drawT;
	
	public GUI() {
		jf = new JFrame();
		drawT = new DrawThread();
		jf.setSize(1200, 800);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.addKeyListener(new KeyHandler());
		jf.add(drawT.draw);
		jf.setVisible(true);
	}
}
