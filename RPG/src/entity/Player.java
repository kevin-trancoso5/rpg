package entity;

import java.util.ArrayList;
import java.util.Scanner;

import map.Position;
import shop.Shop;
import weapons.*;

public abstract class Player extends Entity {
	protected Weapon weapon;
	ArrayList<Weapon> weapons;
	int xp;
	int level;
	int gold;


	
	public Player(String name, int hp) {
		super(name,hp,new Position(0,0));
		this.weapon = new WoodStick();
		weapons=new ArrayList<Weapon>();
		weapons.add(weapon);
		this.xp=0;
		this.level=1;
		this.gold=0;
	}
	
	public void chooseWeapon() {
		Scanner in = new Scanner(System.in);
		System.out.println("Vous avez actuellement équipé "+weapon);
		System.out.println("Voici votre inventaire, entrez le chiffre correspondant à l'arme que vous souhaitez");
		for(int i=0;i<weapons.size();i++) {
			System.out.println((i+1)+") "+weapons.get(i));
		}
		int choice = in.nextInt();
		if ((choice-1) < weapons.size() && (choice-1) >= 0) {
			weapon=weapons.get(choice-1);
		}
		else {
			System.out.println("Vous n'avez pas changé d'arme");
		}
	}
	public void buyWeapon(Shop s) {
		s.showShop();
		Weapon wpnToBuy = s.getChoice();
		if (gold>=wpnToBuy.getPrice()) {
			gold-=wpnToBuy.getPrice();
			System.out.println("Vous avez bien acheté "+wpnToBuy.getName());
			weapons.add(wpnToBuy);
			chooseWeapon();
		}
		else {
			System.out.println("Vous n'avez pas assez d'argent.");
		}
	}
	
	public abstract void castSpell(Entity e);
	
	public void useWeapon(Entity e) {
		e.getAttacked(weapon.getDamage());
	}
	void useSpell(Entity e,int dmg) {
		e.getAttacked(dmg);
	}
	
	public boolean isDead() {
		return !isAlive;
	}
	
	public void move() {
		Scanner in = new Scanner(System.in);
		System.out.println("Haut = Z | Gauche= Q | Droite = D | Bas=S");
		String key = in.next();
		switch(key) {
			case "z": pos.moveUp();break;
			case "q": pos.moveLeft();break;
			case "s": pos.moveDown();break;
			case "d": pos.moveRight();break;
			default: break;
		}
	}
	
	public void getXp(int nb) {
		this.xp+=nb;
		if (xp>=5 && level ==1) {
			levelUp();
		}
		if (xp>=13 && level ==2) {
			levelUp();
		}
		if (xp>=34 && level ==3) {
			levelUp();
		}
		if (xp>=89 && level ==4) {
			levelUp();
		}
	}
	
	public void levelUp() {
		level++;
		maxHp+=15;
	}
	
	public void getGold(int nb) {
		this.gold+=nb;
	}
	
	public void regen() {
		hp=maxHp;
	}

	@Override
	public String toString() {
		int xpNeeded = 0;
		switch(level) {
		case 1: xpNeeded = 5;break;
		case 2: xpNeeded = 13;break;
		case 3: xpNeeded = 34;break;
		case 4: xpNeeded = 89;break;
		case 5: xpNeeded = 200;break;
		}
		return this.name + " | " + this.getClass().getSimpleName() + " | Hp: " +hp+"/"+maxHp+ " | Exp: " +xp+"/"+xpNeeded+" | Lvl: "+level+ " | Gold: "+gold +" | Weapon: "+weapon.getName();
	}
	
	

}
