/*
 * George Tangen
 * "Mold" Infection System
 * 
 * Creates a grid of blank spaces, the center of which is infected by mold.
 * Each "turn" the mold systematically chances to infect the spaces adjacent.
 * The goal is to make unique shapes each time.
 * 
 */


//import java.util.Scanner;

public class GeneratedGrid {

	
	public static void main(String[] args) {
		
		final int SIZE = 30;
		Builder bob = new Builder(SIZE);

		String[][] mold = new String[SIZE][SIZE];
		boolean[][] checked = new boolean[SIZE][SIZE];

		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				mold[x][y] = " ";
				checked[x][y] = false;
			}
		}
		//printMold(mold, SIZE);
		bob.updateScreen(mold);
		waitHere();

		mold[SIZE / 2][SIZE / 2] = ("X");

		//printMold(mold, SIZE);
		bob.updateScreen(mold);
		waitHere();
		waitHere();
		waitHere();
		waitHere();

		boolean proceed = true;
		//Scanner scan = new Scanner(System.in);
		while (proceed) {

			/*
			 * for (int x = 0; x < SIZE; x++) { for (int y = 0; y < SIZE; y++) {
			 * checked[x][y] = false; } }
			 */

			for (int x = 1; x < SIZE - 1; x++) {
				for (int y = 1; y < SIZE - 1; y++) {

					if (mold[x][y].equals("X") && checked[x][y] != true) {
						
						/* Checks clockwise around any "mold" and has a %50 chance to "infect"
						 * the blocks adjacent. 
						 * Turns them to 0's first as to not mess with the checks.
						 * Later, the 0's will be turned into X's
						 */
						
						// Check up
						if (mold[x][y - 1].equals(" ")
								&& (int) (Math.random() * 2) <= 0) {
							mold[x][y - 1] = "0";
						}

						// Check right
						if (mold[x + 1][y].equals(" ")
								&& (int) (Math.random() * 2) <= 0) {
							mold[x + 1][y] = "0";
						}

						// Check down
						if (mold[x][y + 1].equals(" ")
								&& (int) (Math.random() * 2) <= 0) {
							mold[x][y + 1] = "0";
						}

						// Check left
						if (mold[x - 1][y].equals(" ")
								&& (int) (Math.random() * 2) <= 0) {
							mold[x - 1][y] = "0";
						}

						checked[x][y] = true;
					}

				}
			}
			
			//Turning the 0's into X's and checking to see if it can grow again
			int count = 0;
			for (int x = 0; x < SIZE; x++) {
				for (int y = 0; y < SIZE; y++) {
					if (mold[x][y].equals("0")) {
						mold[x][y] = "X";
						count++;
					}
				}
			}
			
			//Checks if any more spaces can grow
			if (count == 0) {
				//System.out.println("No more growth possible!");
				bob.updateScreen2("No more growth possible!");
				proceed = false;
			}

			//If more can grow, it will give the option to allow it to grow again
			if (proceed) {
				//printMold(mold, SIZE);
				bob.updateScreen(mold);
				waitHere();
				/*System.out.println("Would you like another growth?");
				if (!scan.next().equalsIgnoreCase("yes") && proceed == true) {
					proceed = false;
				}*/
			}

		}
		
		for(int i = 0; i<10; i++){
			waitHere();
		}
		
		
	}

	public static void printMold(String[][] a, int SIZE) {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				System.out.print(a[x][y]);
			}
			System.out.println();
		}
	}

	private static void waitHere() {
		try {
			Thread.sleep(100); // 1000 milliseconds is one second.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
