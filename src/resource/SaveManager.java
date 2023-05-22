package resource;

import java.io.*;

public class SaveManager {
	
	String File="./resources/game_saves/save.txt";
	
	
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
