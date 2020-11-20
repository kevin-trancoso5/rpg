package rpg;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Enemy;
import entity.Entity;
import entity.Mage;
import entity.Player;
import entity.Warrior;
import entity.monsters.*;
import map.Map;
import map.Position;
import shop.Shop;

public class RPG {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Map m = new Map(8);
		Shop s = new Shop();
		ArrayList<Enemy> enemies = generateMonsters(m);
		Player p = createCharacter();
		m.addEntity(p);
		while (!enemies.get(enemies.size() - 1).isDead() && !p.isDead()) {

			System.out.println(p);
			m.showMap();
			p.move();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

			for (int i = 0; i < enemies.size(); i++) {
				if ((p.pos.x == enemies.get(i).pos.x) && (p.pos.y == enemies.get(i).pos.y)) {
					startFight(p, enemies.get(i));
				}
			}
			if (p.pos.x == 1 && p.pos.y == 2) {
				p.buyWeapon(s);
			}
			if (p.pos.x == 8 && p.pos.y == 1) {
				p.regen();
			}
		}
		if(p.isDead()) {
			System.out.println("Game over");
		}
		if(enemies.get(enemies.size() - 1).isDead()) {
			System.out.println("Vous avez triomphé de Gillou, féliciations!");
		}

	}

	private static void startFight(Player p, Enemy e) {
		int n = 1;
		System.out.println("Combat enclenché entre "+p.name+" et "+e.name);
		while (!p.isDead() && !e.isDead()) {
			if (n % 2 == 1) {
				
				System.out.println("Tour n°" + (((n - n % 2) / 2) + 1));
				System.out.println("\nQue souhaitez-vous faire?");
				System.out.println("1.Attaquer | 2.Lancer un sort | 3.Changer d'arme");
				int action = in.nextInt();
				while (action < 1 || action > 3) {
					System.out.println("Erreur de saisie.");
					action = in.nextInt();
				}
				switch (action) {
				case 1:
					p.useWeapon(e);
					break;
				case 2:
					p.castSpell(e);
					break;
				case 3:
					p.chooseWeapon();
					break;
				}
				n++;
			} else if (n % 2 == 0) {
				System.out.println();
				System.out.println(e.getClass().getSimpleName() + " vous attaque.");
				e.attack(p);
				System.out.println();
				n++;
			}
		}
		if (e.isDead()) {
			e.loot(p);
			e.pos.dead();
		}
	}

	static Player createCharacter() {
		System.out.println("Veuillez créer votre personnage, tout d'abord quel est votre nom?");
		String name = in.nextLine();
		System.out.println("Veuillez choisir votre classe désormais, vous êtes plutot:\n1.Mage\n2.Guerrier");
		int choix = in.nextInt();
		while(choix!=1 && choix !=2) {
			System.out.println("Erreur de saisie");
			choix = in.nextInt();
		}
		System.out.println(name+", je compte sur vous pour battre la terrible menace qu'est Gillou, situé au sud-est de notre belle contrée.");
		System.out.println("Contrée qui aujourd'hui est assaillie par diverses créatures qui sont représentées par des lettres");
		System.out.println("Vous pourrez vous soigner sur le +, et acheter de nouvelles armes au $");
		System.out.println("Bonne chance aventurier, lorsque vous êtes prêt saisissez n'importe quelle touche.");
		in.next();
		switch (choix) {
		case 1:
			return new Mage(name);
		case 2:
			return new Warrior(name);
		default:
			return new Mage(name);
		}

	}

	static ArrayList<Enemy> generateMonsters(Map m) {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		Goblin g1 = new Goblin(new Position(5, 3));
		m.addEntity(g1);
		enemies.add(g1);
		Goblin g2 = new Goblin(new Position(3, 2));
		m.addEntity(g2);
		enemies.add(g2);
		Goblin g3 = new Goblin(new Position(4, 1));
		m.addEntity(g3);
		enemies.add(g3);
		Goblin g4 = new Goblin(new Position(2, 6));
		m.addEntity(g4);
		enemies.add(g4);
		Ogre o1 = new Ogre(new Position(4, 6));
		m.addEntity(o1);
		enemies.add(o1);
		Ogre o2 = new Ogre(new Position(8, 2));
		m.addEntity(o2);
		enemies.add(o2);
		Ogre o3 = new Ogre(new Position(9, 4));
		m.addEntity(o3);
		enemies.add(o3);
		Cyclop c1 = new Cyclop(new Position(12, 5));
		m.addEntity(c1);
		enemies.add(c1);
		Cyclop c2 = new Cyclop(new Position(14, 7));
		m.addEntity(c2);
		enemies.add(c2);
		Cyclop c3 = new Cyclop(new Position(14, 6));
		m.addEntity(c3);
		enemies.add(c3);
		Cyclop c4 = new Cyclop(new Position(15, 6));
		m.addEntity(c4);
		enemies.add(c4);
		Gillou j = new Gillou(new Position(15, 7));
		m.addEntity(j);
		enemies.add(j);
		return enemies;
	}

}
