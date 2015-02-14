package coin;

import java.util.Scanner;

public class Coin {

	static String x;
	static String result;
	static int score;
	
	public static void main(String[] args) {
		System.out.println("===== HEADS OR TAILS =====");
		System.out.println("You will enter either Heads\nor Tails. If your guess is\ncorrect you gain a point.\nMore points means better!");
		Scanner scan = new Scanner(System.in);
		game();
		System.out.println("Goodbye");
		scan.close();
		

	}
	
	public static void game(){
		score = -1;
		Scanner scan = new Scanner(System.in);
		do{
			score++;
			System.out.println("Heads or Tails?");
			x = scan.next();
			result = "Heads";
			if((int)(Math.random()*2)==0){
				result = "Tails";
			}
		}while(x.equalsIgnoreCase(result));
		
		System.out.println("Game Over!\tScore: " + score);
		System.out.println("Would you like to play again? (y/n)");
		if(scan.next().equalsIgnoreCase("y")){
			game();
		}
		scan.close();
	}
}
