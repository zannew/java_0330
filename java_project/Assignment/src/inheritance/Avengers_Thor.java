package inheritance;

public class Avengers_Thor extends Avengers {

	String weapon;
	
	public Avengers_Thor(String heroName, String nameOfSkill, int hpEnergy, int mpEnergy, String weapon) {
		super(heroName, nameOfSkill, hpEnergy, mpEnergy);
		this.weapon=weapon;
		
	}

	@Override
	void showDetail() {
		showIntro();
	}
	
}
