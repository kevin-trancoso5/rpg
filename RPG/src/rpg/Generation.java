package rpg;

import java.util.ArrayList;

import entity.Enemy;
import entity.Obstacle;
import entity.monsters.Cyclop;
import entity.monsters.Gillou;
import entity.monsters.Goblin;
import entity.monsters.Ogre;
import entity.obstacles.Tree;
import map.Map;
import map.Position;

public class Generation {
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

	static ArrayList<Obstacle> generateObstacles(Map m) {
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		Tree t1 = new Tree(new Position(2, 1));
		m.addEntity(t1);
		obstacles.add(t1);

		return obstacles;
	}
}
