package test;

public class Service {

	// Service 클래스는 Dao클래스에 의존한다.(순행제어)
	//Dao dao = new Dao();

	Dao dao;

	// 주입
	// 완성된 클래스가 없음에도 다형성으로 Dao 인스턴스 사용 가능 : 의존성 낮춤
	public void setDao(Dao dao) {
		this.dao=dao;
		
	}
	
	public void print() {
		dao.print();
		
	}
	
	
}
