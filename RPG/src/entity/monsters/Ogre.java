package entity.monsters;

import entity.*;
import map.Position;

public class Ogre extends Enemy{
	private static final String NAME = "Ogre";
	private static final int HP = 51;	
	private static final int DAMAGE = 8;
	private static final int XP_GIVEN = 14;
	private static final int GOLD_GIVEN = 15;
	public Ogre(Position pos) {
		super(NAME,HP,DAMAGE,XP_GIVEN,GOLD_GIVEN,pos);
	}
}
