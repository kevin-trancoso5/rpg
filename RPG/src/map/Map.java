package map;

import java.util.ArrayList;

import entity.Entity;

public class Map {

	int size;
	ArrayList<Position> positions;
	ArrayList<Entity> entities;

	public Map(int size) {
		this.size = size;
		this.positions = new ArrayList<Position>();
		this.entities = new ArrayList<Entity>();
	}

	public void showMap() {
		System.out.println("##################");
		for (int i = 0; i < size; i++) {
			System.out.print("#");
			for (int j = 0; j < size*2; j++) {
				System.out.print(getPrint(j, i));
			}
			System.out.println("#");
		}
		System.out.println("##################");
	}

	public void addEntity(Entity e) {
		entities.add(e);
		positions.add(e.pos);
	}

	String getPrint(int x, int y) {
		for (int i = 0; i < positions.size(); i++) {
			Position pos = positions.get(i);
			Entity e = entities.get(i);
			if (pos.x == x && pos.y == y) {
				if(e.getClass().getSimpleName().equals("Mage") || e.getClass().getSimpleName().equals("Warrior")) {
					return "P";
				}
				if(e.getClass().getSimpleName().equals("Goblin")) {
					return "G";
				}
				if(e.getClass().getSimpleName().equals("Ogre")) {
					return "O";
				}
				if(e.getClass().getSimpleName().equals("Cyclop")) {
					return "C";
				}
				if(e.getClass().getSimpleName().equals("Gillou")) {
					return "B";
				}
				if(e.getClass().getSimpleName().equals("Tree")) {
					return "T";
				}
			}
		}
		if(x==1 && y==2) {
			return "$";
		}
		if(x==8 && y==1) {
			return "+";
		}
		return " ";
	}

}
