package gui.view.console;

import java.util.Scanner;

import gui.View;
import gui.controller.MainPageController;

public class MainPageView extends View <MainPageController> {

	public MainPageView(MainPageController controller) {
		super(controller);
	}

	@Override
	public void show() {
		System.out.println("Welcome!");
		System.out.println("Would you like to start?");
		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		if (input.equals("yes")) {
			controller.actionNewGame();
		}

		sc.close();
	}

}
