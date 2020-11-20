package entity;

import map.Position;

abstract public class Entity{

	public String name;
	int hp;
	int maxHp;
	boolean isAlive;
	public Position pos;
	
	public Entity(String name, int hp, Position pos) {
		this.name=name;
		this.hp=hp;
		this.maxHp=hp;
		this.isAlive=true;
		this.pos=pos;
	}
	
	public void getAttacked(int dmg) {
		hp-=dmg;
		if (hp <=0) {
			System.out.println(name+" prend "+dmg+" de dommages");
			System.out.println(name+" est mort.");
			isAlive=false;
		}
		else {
			System.out.println(name+" prend "+dmg+" de dommages et a maintenant "+hp+"hp.");
		}
	}
	
}
