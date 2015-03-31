package plinko;

import java.util.Scanner;

public class Plinko {

	public static void main(String[] args) {

		int StartPos = 3;
		Scanner scan = new Scanner(System.in);
		boolean go = true;
		while (go) {
			int L = 0;
			int C = 0;
			int R = 0;
			System.out
					.println("Enter how many times you would like to run the Plinko.");
			int o = scan.nextInt();
			System.out
					.println("Enter where you would like the ball to start. (L)eft, (C)enter, (R)ight");
			String start = scan.next();
			if (start.equalsIgnoreCase("L"))
				StartPos = 1;
			if (start.equalsIgnoreCase("C"))
				StartPos = 3;
			if (start.equalsIgnoreCase("R"))
				StartPos = 5;

			for (int y = 0; y < o; y++) {
				int width = 1;
				int length = 4;
				int pos = StartPos;
				LayerList machine = new LayerList(width, length, pos);
				int endpoint = 0;
				for (int i = 0; i < length; i++) {
					endpoint = machine.runLayer(i);
				}
				if (endpoint == 1)
					L++;
				if (endpoint == 3)
					C++;
				if (endpoint == 5)
					R++;
				System.out.println(machine.toString());
			}
			System.out.println("Final Count:\n");
			System.out.println("Left: " + L);
			System.out.println("Center: " + C);
			System.out.println("Right: " + R);
			System.out.println("Again? (y/n)");
			if (scan.next().equalsIgnoreCase("y")) {
				go = true;
			} else {
				go = false;
			}
		}
		System.out.println("Goodbye.");
	}

}
