package inheritance;

public class Avengers_IronMan extends Avengers {
	
	String weapon;
	

	public Avengers_IronMan(String heroName, String nameOfSkill, int hpEnergy, int mpEnergy, String weapon) {
		super(heroName, nameOfSkill, hpEnergy, mpEnergy);
		this.weapon=weapon;
	
	}

	@Override
	void showIntro() {
		showDetail();
	}
	
}
