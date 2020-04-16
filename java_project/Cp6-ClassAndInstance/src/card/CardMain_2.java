package card;

public class CardMain_2 {
	public static void main(String[] args) {
		
//		Card c1=new Card();
//			c1.kind = "Heart";
//			c1.number = 1;
//			for(;c1.number<=13;c1.number++) {
//				if(c1.number==11) {
//					c1.number = 'J';
//				}else if(c1.number==12){
//					c1.number = 'Q';
//				}else if{
//					c1.number = 'K';
//				}else {
//					
//				System.out.println("첫번째 카드는 "+c1.kind+" "+c1.number+"카드의 높이는 "+c1.height+"이고 폭은 "+c1.width+"입니다.");
//				}
//			}
//		
//		
//		Card c2=new Card();
//		c2.kind = "Spade";
//		c1.number = 1;
//		
//		Card c3=new Card();
//		c3.kind = "Clover";
//		c1.number = 1;
//		
//		Card c4=new Card();
//		c4.kind = "Diamond";
//		c1.number = 1;
		
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 14; j++) {
				
				String kind = "";
				
				switch(i) {
				
				case 0:
					kind="Spade";
					break;
				case 1:
					kind="Clover";
					break;
				case 2:
					kind="Heart";
					break;
				case 3:
					kind="Spade";
					break;
				
				
				}
				
				Card c = new Card();
				c.kind = kind;
				c.number = j;
			}
		}
		
		
	}
}
