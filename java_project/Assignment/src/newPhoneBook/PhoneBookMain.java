package newPhoneBook;

import java.util.Scanner;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		PhoneInfo_Control c = new PhoneInfo_Control();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		
		Menu.showMenu();
		
		int choice=sc.nextInt();

		switch(choice) {
		
		case 1:
			c.save_Info();
			break;
		case 2:
			c.searchInfo();
			break;
		case 3:
			c.deleteInfo();
			break;
		case 4:
			c.show_AllInfo();
			break;
		case 5:
			return;
		
		
		}
		
		
		
		
		
		
		
		
		
			
			
			
			
	
		}
	
	
	}
	
	
	
	
}
