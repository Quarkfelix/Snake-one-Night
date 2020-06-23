package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

import Inrastructure.Main;

public class Head {
	private int x,y;
	
	public Head() {
		x = 5;
		y = 5;
	}

	
	public void incX() {
		x += 1;
	}
	
	public void decX() {
		x -= 1;
	}
	
	public void incY() {
		y += 1;
	}
	
	public void decY() {
		y -= 1;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
	
	
	
	
	
	public void draw(Graphics2D g) {
		GameField gf = Main.gf;
		
		g.setColor(Color.CYAN);
		g.fillRect((x-1)*40 + gf.x, (y-1)*40 + gf.y, 40, 40);
	
	}
}
