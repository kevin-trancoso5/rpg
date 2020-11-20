package weapons;

public class Sword extends Weapon{
	private static final String NAME = "Sword";
	private static final int DAMAGE = 30;
	private static final int PRICE = 30;
	public Sword() {
		super(NAME,DAMAGE,PRICE);
	}
}
