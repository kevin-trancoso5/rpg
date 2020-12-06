package shop;

import java.util.Scanner;

import weapons.*;

public class Shop {
	static Weapon[] weapons = {new Sword(),new Axe(), new Bow()};
	
	public void showShop() {
		System.out.println("Name | Damage | Price");
		for (int i=0;i<weapons.length;i++) {
			System.out.println((i+1)+"."+ weapons[i].getName()+" | "+weapons[i].getDamage()+" | "+weapons[i].getPrice());
		}
	}
	
	public Weapon getChoice() {
		Scanner in = new Scanner(System.in);
		System.out.println("Choisissez une arme à acheter");
		int choice = in.nextInt();
		while(choice<1 || choice>weapons.length)
		{
			System.out.println("Erreur de saisie");
			choice = in.nextInt();
		}
		return weapons[choice-1];
	}
}
