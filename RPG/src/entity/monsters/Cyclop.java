package entity.monsters;

import entity.*;
import map.Position;

public class Cyclop extends Enemy{
	private static final String NAME = "Cyclop";
	private static final int HP = 81;	
	private static final int DAMAGE = 12;
	private static final int XP_GIVEN = 21;
	private static final int GOLD_GIVEN = 25;
	public Cyclop(Position pos) {
		super(NAME,HP,DAMAGE,XP_GIVEN,GOLD_GIVEN,pos);
	}
}
