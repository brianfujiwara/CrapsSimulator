//brian's craps game
//sideshooter committ testing
public class MainCraps {
	
	
	
	static String done = "good";
	static int bankroll = 300; ////<---- ENTER BANKROLL YOU WISH TO START WITH
		
	static int six= 30; /// <-----Choose Place bets for 6 and 8
	
	static int five = 10; //// <-----Choose Place bets for 5 and 9
	

		public static void comeout() {
			
			System.out.println("new shooter coming out");
			System.out.println("bankrool is at " + bankroll);
			
			int dice;  
			
			
			while(!done.equals("crap") || bankroll>70) {

				System.out.println("Dice Are Out");
				
				dice = roll();
		      
		      if (dice == 2 || dice == 3 || dice == 12) {
		          System.out.println(dice + " Crap!");
		          
		       }
		       else if (dice == 7 || dice == 11) {
		          System.out.println("Immediate win with: " + dice);
		          
		       }else {
		    	   
		    	   System.out.println(dice +" mark it up");
		    	   pointset(dice);
		       }
			}
		      
		}
		
		public static String sayings(int point) {
			
			String callout;
			
			switch (point) {
			
			case 7:
				callout = "SEVEN OUT";
				break;
			case 4:
				callout = "Fooooourr";
				break;
			case 10:
				callout = "TEN, EASY TEN";
				break;
			case 5:
				callout = "FIVE NO FIELD FIVE";
				break;
			case 6:
				callout ="SIX HARD SIX";
				break;
			case 8:
				callout ="EIGHT!!!!!!";
				break;
			case 9:
				callout ="NINE CENTER FIELD NINE";
				break;
			case 3:
			case 12:
			case 2:
				callout = point + "CRAP";
				break;
			default:
				callout = "NO ROLL DICE OUT";
				
			
			}
			
			return callout;
				
			
			
		}
		
		public static void pointset(int point) {
			
		
			while(true) {
				
				int num = roll();
				pay(num);
				
				if(num == 7 ) {
					
					System.out.println(sayings(num));
					//System.out.println(num);
					//System.out.println("7 out!!!!!");
					System.out.println("Your Final Bankroll is "+ bankroll);
					done="crap";
					break;
				}else if (num==point) {
					
					System.out.println(sayings(num));
					System.out.println(num+ " point made nice job");
					
					break;
				}else {
					
					System.out.println(sayings(num));
				}
				
				
				
			}
		}
		
		public static int roll() {
			int dice;  
		      dice = (int)(6.0*Math.random() + 1.0) +
		             (int)(6.0*Math.random() + 1.0);
		      
		      return dice;
			
		}
		
		public static void pay(int num) {
			
			int payout = 0 ;
			
			if (num==7) {
				
				bankroll = bankroll - 80;
			}else if (num == 6 || num ==8) {  
				//System.out.println("+36");
				payout = (six*6)/5; // <--- Pay out is 6 to 5 odds on 6 and 8
				
				bankroll =  bankroll + payout;
			}else if (num == 5 || num == 9) {
				//System.out.println("+15");
				payout = (five*3)/2;  //// <--- Pay out is 3 to 2 odds for 5 and 9
				bankroll = bankroll + 15;
			}
			
			
		}
		
		public static void main(String[] args ) {
			
			comeout();
		}
		


}

