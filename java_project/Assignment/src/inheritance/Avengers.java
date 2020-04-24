package inheritance;

public class Avengers {

	String name;
	
	Avengers(String heroName){
		this.name=heroName;
		
	}
	
	void appear() {
		System.out.println(this.name+"이(가) 등장했습니다.");
	
	}
}

class IronMan extends Avengers{
	
	
	IronMan(String heroName, String action){
		super(heroName);
//		super.appear();
	}
	
}

class CaptainAmerica extends Avengers{

	CaptainAmerica(String heroName, String action) {
		super(heroName);
	}
	
}


