package GrowthSpawn;

import java.util.Scanner;

public class DecimalConverter {

	static int x;
	static boolean first0s = true;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(1==1){
		System.out.println("Enter the base 10 number.");
		x = scan.nextInt();
		while(x>262144){
			x--;
		}
		System.out.print(x + " in binary is: ");
		decider(131072);
		first0s = true;
		System.out.println("\nWould you like to enter another? (y/n)");
		if(scan.next().equalsIgnoreCase("n")){
			break;
		}
		}
	}
	
	private static void decider(int y) {
		if (y < 1) {
			System.out.print(" ");
		} else if ((x / y) < 1) {
			if(first0s == false)
				System.out.print("0");
			decider(y / 2);
		} else {
			first0s = false;
			System.out.print("1");
			x-=y;
			decider(y/2);
		}
	}
}
