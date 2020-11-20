package entity;

import map.Position;

public abstract class Obstacle extends Entity {

	public Obstacle(String name,int hp,Position pos) {
		super(name,hp,pos);
	}
	
}
