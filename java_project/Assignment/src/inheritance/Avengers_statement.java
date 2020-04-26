package inheritance;

import java.util.Scanner;

public class Avengers_statement extends Avengers{

	int hp;
	int mp;
	

	public Avengers_statement(String heroName, String nameOfWeapon, String action, int energy, int mp) {
		super(heroName, nameOfWeapon, action);
		this.hp=energy;
		this.mp=mp;
	
	}
	
	@Override
	void showStatement() {
		System.out.println("현재 생존에너지 : "+this.hp);
		System.out.println("현재 마법에너지 : "+this.mp);
	}
	
	
	
}
