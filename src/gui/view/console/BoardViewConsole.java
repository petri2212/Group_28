package gui.view.console;

import java.util.Scanner;

import gui.view.BoardView;

public class BoardViewConsole extends BoardView{

	@Override
	public void show() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("benvenuto nella boar");
		System.out.println("se vuoi tornare alla mainpage premi rm");
		String input = sc.nextLine();

		if(input.equalsIgnoreCase(input)){
			actionReturnMainPage.actionPerformed(null);				
		}
	}

}
