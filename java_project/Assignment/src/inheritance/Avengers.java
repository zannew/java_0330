package inheritance;

public class Avengers {

	String name;
	String nameOfSkill;
	int hp;
	int mp;
	
	Avengers(String heroName, String nameOfSkill, int hpEnergy, int mpEnergy){
		this.name=heroName;
		this.nameOfSkill=nameOfSkill;
		this.hp=hpEnergy;
		this.mp=mpEnergy;
		
	}
	
	void showIntro() {
		System.out.println("게임을 시작합니다.");
		 System.out.println("히어로 : "+this.name);
		 System.out.println("스킬 : "+this.nameOfSkill);
		 System.out.println("hp : "+this.hp);
		 System.out.println("mp : "+this.mp);
	}
	
	void showDetail() {}
}




