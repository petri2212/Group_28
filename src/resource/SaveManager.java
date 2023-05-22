package resource;

import java.io.*;

public class SaveManager {
	
	
	
	
	
	
	
	
	
	public void loadfile() throws NumberFormatException, IOException {
		
		String File="./resources/game_saves/save.txt";
		int nplayers;
		int rounds; 

		FileReader reader = new FileReader(File);
		BufferedReader br = new BufferedReader(reader);
		
		nplayers=Integer.parseInt(readfile(br,1));  	  //assignment of nplayers 
																		//P.S. aggiungere controllo su num max player
		rounds=Integer.parseInt(readfile(br,1)); 		  //assignment of round
		
	}
	
	/*
	 * method used to read the file
	 */
	public static String readfile(BufferedReader br, int n) throws IOException {
		String line="";
		
		for(int i=0;i<n;i++) {
			try {
				line=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(line==null)
				break;
		}
		return line;
}
	
}
