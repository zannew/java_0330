package ex;
//Car 클래스
public class Car {
	
	public static void main(String[] args) {
		//객체 생성
	HybridWaterCar hwc = new HybridWaterCar(100, 20, 15);
	
	hwc.showCurrentGauge();
	
	}
	
	//iv선언
	int gasolinegauge;
	//생성자
	public Car(int gasolinegauge) {
		//입력받은 매개변수 gasolinegauge로 iv초기화
		this.gasolinegauge=gasolinegauge;
	}
}

//HybridCar클래스(Car클래스 상속받음)
class HybridCar extends Car {
	//iv추가
	int electronicGauge;
	
	//생성자
	HybridCar(int gasolinegauge,int electronicGauge){
		//상위클래스 생성자호출(매개변수)
		super(gasolinegauge);
		//입력받은 매개변수 electronicGauge로 iv초기화
		this.electronicGauge=electronicGauge;
		
	}

}
//HybridWaterCar 클래스(HybridCar클래스 상속받음)
	class HybridWaterCar extends HybridCar {
		//iv추가
		int waterGauge;
	
	//생성자 	
	HybridWaterCar(int gasolinegauge,int electronicGauge,int waterGauge){
		//상위클래스 생성자 호출
		super(gasolinegauge, electronicGauge);
		//매개변수 받아 iv초기화
		this.waterGauge=waterGauge;
	}
	
	//상속받은 모든 iv를 출력하는 메서드
	public void showCurrentGauge() {
	System.out.println("잔여 가솔린 : " + gasolinegauge);
	System.out.println("잔여 가솔린 : " + electronicGauge);
	System.out.println("잔여 가솔린 : " + waterGauge);
	}
	}