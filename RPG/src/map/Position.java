package map;

public class Position {
	
	public int x;
	public int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveUp() {
		if(y>0){ 
			y--;
		}
	}
	
	public void moveLeft() {
		if(x>0){ 
			x--;
		}
	}
	
	public void moveRight() {
		if(x<15){ 
			x++;
		}
	}
	
	public void moveDown() {
		if(y<7){ 
			y++;
		}
	}
	
	public void dead() {
		y=100;
		x=100;
	}
}
