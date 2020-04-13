package operator_2;

public class Quiz_7 {
	public static void main(String[] args) {
		
		int fahrenheit =100;

//		float celcius = ((int)((5/9f * (fahrenheit-32))*1000)%10 > 5
//			    ? (int)(((5/9f * (fahrenheit-32))*1000)/10)/100f + 0.01f 
//			    : (int)(((5/9f * (fahrenheit-32))*1000)/10)/100f);
		float celcius = (int)((5/9f * (fahrenheit-32))*100 + 0.5) / 100f;
//절사, 자리수 (f/d) → (int)
//반올림  → 원하는 자리에 +5

		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
		
	}
}
