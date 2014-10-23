import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Builder {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea();
	JTextArea text2 = new JTextArea();
	
	public Builder(int SIZE) {
		structure(SIZE);
	}
	
	public void structure(int SIZE){
		frame.setTitle("Mold Infection System");
		frame.setSize(399+(SIZE*5),400+(SIZE*5));
		frame.setVisible(true);
		frame.add(panel);
		panel.add(text);
		text.setEditable(false);
		text.setVisible(true);
		panel.setBackground(Color.LIGHT_GRAY);
		text.setBackground(Color.LIGHT_GRAY);
		text2.setEditable(false);
		text2.setVisible(true);
		text2.setBackground(Color.LIGHT_GRAY);
	}
	
	public void updateScreen(String[][] a){
		String s = " ";
		for(int i = 0; i<(a.length); i++){
			for(int j = 0; j<(a.length); j++){
				s+=(a[i][j]);
			}
			s+=("\n");
		}
		
		text.setText(s);
		
	}
	
	public void updateScreen2(String a){
		frame.setSize(frame.getWidth()+100, frame.getHeight());
		panel.add(text2);
		String s = "";
		
		s = a;
		
		text2.setText(s);
		
	}

	
}
