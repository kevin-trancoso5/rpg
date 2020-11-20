package entity;

public class Warrior extends Player {
	
	public Warrior(String name) {
		super(name, 150);
	}

	@Override
	public void castSpell(Entity e) {
		System.out.println("Vous chargez "+e.getClass().getSimpleName());
		useSpell(e,(7*level));
	}

}
