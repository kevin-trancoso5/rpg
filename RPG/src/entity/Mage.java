package entity;

public class Mage extends Player {
	
	public Mage(String name) {
		super(name, 80);
	}

	@Override
	public void castSpell(Entity e) {
		System.out.println("Vous lancez une boule de feu sur "+e.getClass().getSimpleName());
		useSpell(e,(10*level));
	}

}
