package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

import Inrastructure.Main;

public class Bodypart{
	private int x,y;
	
	public Bodypart() {
		//neues bodypart wird bei 500 500 gespawnt damit es nicht st�rt. beim n�chsten movement tick ist es dann automatisch dran.
		setX(500);
		setY(500);
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
	public void draw(Graphics2D g) {
		GameField gf = Main.gf;
		
		g.setColor(Color.GREEN);
		g.fillRect((x-1)*40 + gf.x, (y-1)*40 + gf.y, 40, 40);
	
	}
}
