package plinko;

public class LayerList {

	int width; // How many pegs (not counting sides) do you want on the first
			   // layer
	Layer[] list;
	int pos;
	boolean done = false;

	public LayerList(int w, int l, int startPos) {
		pos = startPos;
		list = new Layer[l];
		width = w;
		for (int i = 0; i < l; i += 2) {
			addLayer(i);
		}
	}

	private void addLayer(int pos) {
		list[pos] = new Layer(true, width);
		list[pos + 1] = new Layer(false, width);
	}

	public int runLayer(int whichLayer){
		if(whichLayer>0){
			list[whichLayer-1].setPrint();
		}
		list[whichLayer].placeX(pos);
		System.out.println(toString());
		int t = list[whichLayer].getDirection(pos);
		pos+=t;
		if(whichLayer==list.length-1){
			done = true;
			list[whichLayer].setPrint();
		}
		try {
		    Thread.sleep(0);           
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return pos;
	}

	public String toString() {
		String x = "\n";
		x+="|        |\n";
		for (Layer a : list) {
			x+=a.print;
		}
		x+=End(pos);
		x+="----------";
		return x;
	}
	
	public String End(int finale){
		if(!done){
			return "|  |  |  |\n";
		}else{
			String t = "|";
			if(pos==1){
				t+="><|  |  |\n";
			}
			if(pos==3){
				t+="  |><|  |\n";
			}
			if(pos==5){
				t+="  |  |><|\n";
			}
			return t;
		}
	}
	
}
