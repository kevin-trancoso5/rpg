package entity.monsters;

import entity.*;
import map.Position;

public class Goblin extends Enemy{
	private static final String NAME = "Goblin";
	private static final int HP = 20;	
	private static final int DAMAGE = 3;
	private static final int XP_GIVEN = 5;
	private static final int GOLD_GIVEN = 10;
	public Goblin(Position pos) {
		super(NAME,HP,DAMAGE,XP_GIVEN,GOLD_GIVEN,pos);
	}
}
