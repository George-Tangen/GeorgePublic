package chargeGame;

import java.text.DecimalFormat;

public class Field {

	static char[][] field = new char[6][10];
	final static int WIDTH = 6;
	final static int HEIGHT = 10;
	int score2 = 0;
	double time2 = 0;
	
	public String printField(int score, double time){
		score2 = score;
		time2 = time;
		String s = "";
		s+="/------\\\n";
		System.out.println("/------\\");
		for (int i = 0; i < HEIGHT; i++) {
			s+="|";
			System.out.print("|");
			for (int j = 0; j < WIDTH; j++) {
				s+=field[j][i];
				System.out.print(field[j][i]);
			}
			s+="|\n";
			System.out.println("|");
		}
		s+="\\------/\n";
		System.out.println("\\------/");
		s+="Score: " + score + "\n";
		System.out.println("Score: " + score);
		DecimalFormat x = new DecimalFormat("#");
		String t = x.format(time/1000);
		s+="Time: " + (t);
		System.out.println("Time: " + t);
		return s;
	}
	
	public void setField(){
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if(i==0){
					field[j][i] = '!';
				}else{
					field[j][i]= ' ';
				}
			}
		}
	}
	
	public void addTroop(int loc){
		if(field[loc][HEIGHT-1]!=' '){
			System.out.println("Cannot place a troop there. Already Occupied.");
		}else{
			field[loc][HEIGHT-1] = '^';
		}
	}

	public void advanceTroops(){
		for (int i = 1; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if(field[j][i-1] == '!' && field[j][i]=='^'){
					if((int)(Math.random()*3)>0){
						field[j][i-1]=' ';
					}
					field[j][i] = ' ';
				}else if(field[j][i] == '^'){
					//System.out.println("Coords: " + i + ", " +j);
					field[j][i-1] = '^';
					field[j][i] = ' ';
				}
			}
		}
	}
	
	public int fire(){
		int count = 0;
		for(int i = 0; i<WIDTH; i++){
			if(field[i][0] == '!' && (int)(Math.random()*4)==0){
				int q = scanCol(i);
				if(q!=(-1)){
					field[i][q]=' ';
					count ++;
				}
			}
		}
		return count;
	}
	
	private int scanCol(int i){
		int num = -1;
		
		for(int j = 1; j<HEIGHT; j++){
			if(field[i][j] == '^'){
				num = j;
			}
		}
		
		return num;
	}
	
	public int score(){
		int count = 0;
		for(int i = 0; i<WIDTH; i++){
			if(field[i][0]=='^'){
				field[i][0] = ' ';
				count++;
			}
		}
		return count;
	}
	public void reinforcements() {
		for(int i = 0; i<WIDTH; i++){
			if(field[i][0]==' ' && (int)(Math.random()*5) == 0){
				field[i][0] = '!';
			}
		}
		
	}



}









