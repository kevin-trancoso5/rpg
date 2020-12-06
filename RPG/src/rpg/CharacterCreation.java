package rpg;

import java.util.InputMismatchException;
import java.util.Scanner;

import entity.Mage;
import entity.Player;
import entity.Warrior;

public class CharacterCreation {
	
	static Scanner in = new Scanner(System.in);
	
	static Player create() {
		
		
		System.out.println("Veuillez cr�er votre personnage, tout d'abord quel est votre nom?");
		String name = in.nextLine();
		System.out.println("Veuillez choisir votre classe d�sormais, vous �tes plutot:\n1.Mage\n2.Guerrier");
		boolean error;
		int choice = 0;
		do {
			error = false;
			try {
				choice = in.nextInt();
				if (choice != 1 && choice != 2) {
					error = true;
					System.out.println("Erreur de saisie");
				}
			} catch (InputMismatchException e) {
				System.out.println("Erreur de saisie");
				in.next();
				error = true;
			}
		} while (error);
		System.out.println(name
				+ ", je compte sur vous pour battre la terrible menace qu'est Gillou, situ� au sud-est de notre belle contr�e.");
		System.out.println(
				"Contr�e qui aujourd'hui est assaillie par diverses cr�atures qui sont repr�sent�es par des lettres");
		System.out.println("Vous pourrez vous soigner sur le +, et acheter de nouvelles armes au $");
		System.out.println("Bonne chance aventurier, lorsque vous �tes pr�t saisissez n'importe quelle touche.");
		in.next();
		switch (choice) {
		case 1:
			return new Mage(name);
		case 2:
			return new Warrior(name);
		default:
			return new Mage(name);
		}

	}
}
