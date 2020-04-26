package inheritance;

public class Avengers {

	String name;
	String nameOfWeapon;
	String action;
	int energy;
	
	Avengers(String heroName, String nameOfWeapon, String action){
		this.name=heroName;
		this.nameOfWeapon=nameOfWeapon;
		this.action=action;
	}
	
	void showIntro() {
		System.out.println("게임을 시작합니다.");
		 System.out.println("Name Of Hero : "+this.name);
		 System.out.println("Weapon : "+this.nameOfWeapon);
		 System.out.println("필살기 : "+this.action);
	}
	
	void showStatement() {}
}




