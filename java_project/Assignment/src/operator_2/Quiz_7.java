package operator_2;

public class Quiz_7 {
	public static void main(String[] args) {
		
		int fahrenheit =200;

		float celcius = ((int)((5/9f * (fahrenheit-32))*1000)%10 > 5
			    ? (int)(((5/9f * (fahrenheit-32))*1000)/10)/100f + 0.01f 
			    : (int)(((5/9f * (fahrenheit-32))*1000)/10)/100f);


		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
		
		
	}
}
