package setList;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Concert {
	
	Map<String, ArrayList<String>> list;
	Map<String, ArrayList<String>> sortedList;
	Scanner scan = new Scanner(System.in);
	
	public Concert(){
		list = new TreeMap<String, ArrayList<String>>();
		System.out.println("How many songs in the concert?");
		int numOfSongs = scan.nextInt();
		//scan.nextLine();
		for(int i = 0; i<numOfSongs; i++){
			scan.nextLine();
			addSong((i+1));
		}
		System.out.println(toString());
	}
	
	@SuppressWarnings("null")
	private void addSong(int songNum){
		System.out.println("IN SONG " + songNum);
		String songName = "";
		ArrayList<String> dancers = new ArrayList<String>();
		System.out.println("Enter song #"+songNum+" name:");
		songName = scan.nextLine();
		System.out.println("How many dancers in the song?");
		int numOfDancers = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i<numOfDancers; i++){
			System.out.println("Name of dancer #"+(i+1)+": ");
			String temp = scan.nextLine();
			dancers.add(temp);
		}
		list.put(songName, dancers);
	}
	
	public String toString(){
		String t = "";
		
		//19 Across
		t+="-- Concert Order --\n";
		t+="****** ***** ******\n";
		for(String song: list.keySet()){
			t+="Song: \""+ song + "\"\n";
			t+="Dancers: ";
			for(String dancer: list.get(song)){
				t+=dancer+", ";
			}
			t = t.substring(0, t.length()-2);
			t+="\n****** ***** ******\n";
		}
		t+="-------------------";
		
		return t;
	}
	
}
