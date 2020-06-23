package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameField extends Thread{
	public static Snake snake;
	private Food food;
	
	public int x,y,width,height;
	private int tickspeed = 100;
	
	public GameField() {
		x = 25;
		y = 15;
		width = 800;
		height = 720;
		
		snake = new Snake();
		food  = new Food();
		super.start();
	}
	
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(tickspeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!borderCollision() && !snakeCollision()) {
				snake.move();
			}
			
			if(snake.eaten(food)) {
				food.spawnNewFood();
			}
		
		}
	}
	
	private boolean snakeCollision() {
		int x = snake.head.getX();
		int y = snake.head.getY();
		
		for (Bodypart bodypart : snake.body) {
			if (bodypart.getX() == x && bodypart.getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	private boolean borderCollision() {
		if(snake.head.getX() >= 21 || snake.head.getX() <= 0) {
			return true;
		} else if(snake.head.getY() >= 19 || snake.head.getY() <= 0) {
			return true;
		}
		
		return false;
	}
	
	
	
	public void setupDraw(Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, width, height);
		
		snake.draw(g);
		food.draw(g);
		
		g.setColor(Color.BLACK);

		for (int i = 40; i < width; i += 40) {
			g.drawLine(x+i, y, x+i, y+height);
		}
		
		for (int i = 40; i < height; i += 40) {
			g.drawLine(x, y+i, x+width, y+i);
		}
		
		g.drawRect(x, y, width, height);
		
		
//		for (int x = 0; x < 800; x += 40) {
//			if (g.getColor() == Color.LIGHT_GRAY) {
//				g.setColor(Color.DARK_GRAY);
//			} else {
//				g.setColor(Color.LIGHT_GRAY);
//			}
//			g.fillRect(x, 0, 40, 600);
//			
//		}
//		
//		for (int y = 0; y < 600; y += 40) {
//			if (g.getColor() == Color.LIGHT_GRAY) {
//				g.setColor(Color.DARK_GRAY);
//			} else {
//				g.setColor(Color.LIGHT_GRAY);
//			}
//			g.fillRect(0, y, 800, 40);
//		}
	}
}
