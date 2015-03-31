package plinko;

public class Layer {

	int[] order;
	int w;
	boolean s;
	String print;

	// 0 = moving to the right
	// 1 = moving to the left

	public Layer(boolean sides, int numOfM){
		w = numOfM;
		s = sides;
		if(sides){
			int pegs = 5;
			order = new int[pegs];
			order[0] = 1;
			for(int i = 1; i<pegs-1; i++){
				if((int)(Math.random()*2)==0){
					order[i] = -1;
				}else{
					order[i] = 1;
				}
			}
			order[pegs-1] = -1;
		}else{
			int pegs = 5;
			order = new int[pegs];
			for(int i = 0; i<pegs; i++){
				if((int)(Math.random()*2)==0){
					order[i] = -1;
				}else{
					order[i] = 1;
				}
			}
		}
		setPrint();
	}

	public void placeX(int pos){
		if(s){
			//3 positions
			if(pos==1)
				print = "|X  /\\  /|\n";
			if(pos==5)
				print = "|\\  /\\  X|\n";
			if(pos==3){
				print = "|\\  ><  /|\n";
			}
		}else{
			//2 positions
			if(pos==2){
				print = "| ><  /\\ |\n";
			}else{
				print = "| /\\  >< |\n";
			}
		}
	}
	
	public void setPrint(){
		String x ="";
		//0123456789
		//|        |
		{x += "|";
		if (s) {
			x += "\\ ";

			for (int i = 0; i < w; i++) {
				x += " /\\";
			}
		} else {
			for (int i = 0; i < w + 1; i++) {
				x += " /\\ "; 
			}
		}
		if (s) {
			x += " ";
		}
		if (s) {
			x += " /";
		}
		x += "|\n";
		}
		print = x;
	}
	
	public int getDirection(int location) {
		return order[location-1];
	}

}
