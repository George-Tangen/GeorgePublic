package chargeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FieldCharge {

	static Scanner scan = new Scanner(System.in);
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JTextArea text = new JTextArea();

	public static void main(String[] args) {

		

		final Field battleground = new Field();
		int score = 0;
		double time = 0;
		
		battleground.setField();
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setVisible(true);
		frame.add(panel);
		text.setVisible(true);
		text.setEditable(false);
		text.setSize(400, 400);
		panel.add(text);
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 12);
		text.setFont(font); 
		
		
		do {
			battleground.advanceTroops();
			battleground.addTroop((int)(Math.random()*6));
			battleground.addTroop((int)(Math.random()*6));
			score -= battleground.fire();
			score += (battleground.score())*5;
			battleground.reinforcements();
			text.setText(battleground.printField(score, time));
			try {
				Thread.sleep(250); // 1000 milliseconds is one second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			time += 250;
		} while (score<100);
	}

}
