package weapons;

public abstract class Weapon {
	protected String name;
	protected int damage;
	protected int price;
	public Weapon (String name, int damage, int price) {
		this.name = name;
		this.damage = damage;
		this.price = price;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name+" | "+this.damage;
	}
}
