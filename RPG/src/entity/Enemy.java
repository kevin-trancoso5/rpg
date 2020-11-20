package entity;

import map.Position;

public abstract class Enemy extends Entity {

	int damage;
	int expGiven;
	int goldGiven;
	public Enemy(String name,int hp, int damage, int expGiven, int goldGiven, Position pos) {
		super(name,hp,pos);
		this.damage=damage;
		this.expGiven=expGiven;
		this.goldGiven=goldGiven;
	}
	
	public void attack(Entity e) {
		e.getAttacked(damage);
	}
	
	public boolean isDead() {
		return !isAlive;
	}
	
	public void loot(Player p) {
		p.getXp(expGiven);
		p.getGold(goldGiven);
	}
	
}
