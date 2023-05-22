package resource;

import java.io.*;

public class SaveManager {
	
	
	
	
	
	
	
	
	
	public void loadfile() throws NumberFormatException, IOException {
		
		String File="./resources/game_saves/save.txt";
		int n=1;					//n: is used in the the method readfile  to read n rows of the file 
		FileReader reader = new FileReader(File);
		BufferedReader br = new BufferedReader(reader);
		
		n=Integer.parseInt(readfile(br,n));    //now n indicate the number of playe
		
												//P.S. aggiungere controllo su num max player
		
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
