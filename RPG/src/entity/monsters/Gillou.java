package entity.monsters;

import entity.*;
import map.Position;

public class Gillou extends Enemy{
	private static final String NAME = "Gillou";
	private static final int HP = 260;	
	private static final int DAMAGE = 17;
	private static final int XP_GIVEN = 50;
	private static final int GOLD_GIVEN = 1000;
	public Gillou(Position pos) {
		super(NAME,HP,DAMAGE,XP_GIVEN,GOLD_GIVEN,pos);
	}
}
