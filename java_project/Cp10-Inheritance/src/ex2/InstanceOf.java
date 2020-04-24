package ex2;

/*예제 InstanceOf.java를 instanceof 연산자를 사용하지 않는 형태로 변경하고자 한다. 
 * 즉 클래스의 상속관계를 그대로 유지하면서, instanceof 연산자를 사용하지 않고도 동일한 
 * 실행결과를 보일 수 있어야 한다.변경되어야 할 wrapBox 메소드를 아래에 제시.
Public static void wrapBox(Box box)
{
box.wrap();
}
HINT. 메소드 오버라이딩
예제*/

public class InstanceOf {

	public static void main(String[] args) {
		
		Box box1=new Box();
		Box box2=new PaperBox();
		Box box3=new GoldPaperBox();
		PaperBox box4=new PlasticBox();
		
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		wrapBox(box4);
		
	}
	
	
	
	public static void wrapBox(Box box) {
		
		
		box.wrap();
		
		
	}
	
}


class Box{
	
	public void simpleWrap(){System.out.println("simple wrap");}
	
	public void wrap(){
		System.out.println("simple wrap");
		}
}

class PaperBox extends Box{
	
	public void paperWrap() {System.out.println("paper wrap");}
	
	@Override
	public void wrap() {
		System.out.println("paper wrap");
		}
}

class GoldPaperBox extends PaperBox{
	
	public void goldWrap() {System.out.println("gold wrap");}
	
	@Override
	public void wrap() {
		System.out.println("gold wrap");
		}
}

class PlasticBox extends PaperBox{

	@Override
	public void wrap() {
		System.out.println("plastic wrap");
	}
	
	
}





