package rpg;

import java.util.InputMismatchException;
import java.util.Scanner;

import entity.Enemy;
import entity.Obstacle;
import entity.Player;

public class Fight {
	
	static Scanner in = new Scanner(System.in);
	
	public static void startFightVsEnemy(Player p, Enemy e) {
		int n = 1;
		System.out.println("Combat enclenché entre " + p.name + " et " + e.name);
		while (!p.isDead() && !e.isDead()) {
			if (n % 2 == 1) {

				System.out.println("Tour n°" + (((n - n % 2) / 2) + 1));
				System.out.println("\nQue souhaitez-vous faire?");
				System.out.println("1.Attaquer | 2.Lancer un sort | 3.Changer d'arme");
				boolean error;
				int action = 0;
				do {
					error = false;
					try {
						action = in.nextInt();
						if (action < 1 || action > 3) {
							error = true;
							System.out.println("Erreur de saisie");
						}
					} catch (InputMismatchException exc) {
						System.out.println("Erreur de saisie");
						in.next();
						error = true;
					}
				} while (error);

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

	public static void startFightVsObs(Player p, Obstacle o) {
		int n = 1;
		System.out.println("Combat enclenché entre " + p.name + " et " + o.name);
		while (!p.isDead() && !o.isDead()) {

			System.out.println("Tour n°" + (((n - n % 2) / 2) + 1));
			System.out.println("\nQue souhaitez-vous faire?");
			System.out.println("1.Attaquer | 2.Lancer un sort | 3.Changer d'arme");
			boolean error;
			int action = 0;
			do {
				error = false;
				try {
					action = in.nextInt();
					if (action < 1 || action > 3) {
						error = true;
						System.out.println("Erreur de saisie");
					}
				} catch (InputMismatchException exc) {
					System.out.println("Erreur de saisie");
					in.next();
					error = true;
				}
			} while (error);

			switch (action) {
			case 1:
				p.useWeapon(o);
				break;
			case 2:
				p.castSpell(o);
				break;
			case 3:
				p.chooseWeapon();
				break;
			}
			n++;
			if (o.isDead()) {
				o.pos.dead();
			}
		}

	}
}
