package weapons;

public class Bow extends Weapon{
	private static final String NAME = "Bow";
	private static final int DAMAGE = 60;
	private static final int PRICE = 100;
	public Bow() {
		super(NAME,DAMAGE,PRICE);
	}
}
