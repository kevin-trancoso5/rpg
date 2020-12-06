package rpg;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Enemy;
import entity.Obstacle;
import entity.Player;
import map.Map;
import shop.Shop;

public class RPG {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Map m = new Map(8);
		Shop s = new Shop();
		ArrayList<Enemy> enemies = Generation.generateMonsters(m);
		ArrayList<Obstacle> obstacles = Generation.generateObstacles(m);
		Player p = CharacterCreation.create();
		m.addEntity(p);
		while (!enemies.get(enemies.size() - 1).isDead() && !p.isDead()) {

			System.out.println(p);
			m.showMap();
			p.move();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

			for (int i = 0; i < enemies.size(); i++) {
				if ((p.pos.x == enemies.get(i).pos.x) && (p.pos.y == enemies.get(i).pos.y)) {
					Fight.startFightVsEnemy(p, enemies.get(i));
				}
			}
			for (int i = 0; i < obstacles.size(); i++) {
				if ((p.pos.x == obstacles.get(i).pos.x) && (p.pos.y == obstacles.get(i).pos.y)) {
					Fight.startFightVsObs(p, obstacles.get(i));
				}
			}
			if (p.pos.x == 1 && p.pos.y == 2) {
				p.buyWeapon(s);
			}
			if (p.pos.x == 8 && p.pos.y == 1) {
				p.regen();
			}
		}
		if (p.isDead()) {
			System.out.println("Game over");
		}
		if (enemies.get(enemies.size() - 1).isDead()) {
			System.out.println("Vous avez triomphé de Gillou, féliciations!");
		}

	}

}
