package gui.view.console;

import java.util.Scanner;

import gui.view.MainPageView;

public class MainPageViewConsole extends MainPageView {

	@Override
	public void show() {
		System.out.println("Welcome!");
		System.out.println("Would you like to start?");
		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		if (input.equals("yes")) {
			actionNewGame.actionPerformed(null);
		}

		sc.close();
	}

}
