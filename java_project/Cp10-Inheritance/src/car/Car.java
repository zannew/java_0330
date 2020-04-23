package car;

import car.FireEngine.Ambulance;

public class Car {

	String color;
	int door;
	
	
	void drive() {
		System.out.println("운전");
	}
	
	void stop() {
		System.out.println("멈춤");
	}
	
	public static void main(String[] args) {
		
		Car car = null;
		FireEngine fe1 = new FireEngine();
		FireEngine fe2 = null;
		Ambulance am = null;
		
		fe1.water();
		car = fe1;
//		car.water(); //사용불가
		fe2 = (FireEngine)car;	//명시적으로 형변환
		
		
		
		if(car instanceof Ambulance) {
			am = (Ambulance) car;
			am.siren();
		}
		
		
	}
	
	
}


class FireEngine extends Car {
	
	void water() {
		System.out.println("물 뿌리기");
	}
	
	
	
	
	
class Ambulance extends Car{
	
	void siren() {
		System.out.println("에엥~~");
	}
	
	
	
	
}	
	
	
	
	
	
}