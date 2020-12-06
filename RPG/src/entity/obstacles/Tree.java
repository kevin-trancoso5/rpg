package entity.obstacles;

import entity.Obstacle;
import map.Position;

public class Tree extends Obstacle{
	private static final String NAME = "Tree";
	private static final int HP = 8;	
	public Tree(Position pos) {
		super(NAME,HP,pos);
	}
}
