package gui.view.console;

import java.util.Scanner;

import gui.view.PointsPageView;

public class PointsPageViewConsole extends PointsPageView {

	private static final int TWO_PLAYERS = 2;
	private static final int THREE_PLAYERS = 3;
	private static final int FOUR_PLAYERS = 4;
	private boolean isWaiting;

	public void show() {

		System.out.println("Congratulations!!");
		System.out.println("This is the podium!!");

		printPodium(players.size());

		System.out.println("\n\nInsert" + " rm to return main page!!");
		Scanner sc = new Scanner(System.in);

		isWaiting = true;

		do {

			String input = sc.nextLine();

			if (input.isBlank()) {
				System.out.println("Il comando non può essere nullo");

			} else if (input.equalsIgnoreCase("rm")) {
				actionReturnMainPage.actionPerformed(null);
				isWaiting = false;
			}
			System.out.println("\n\nInsert rm to return main page!!");

		} while (isWaiting);

		sc.close();

	}

	public void printPodium(int playersNumber) {
		String topFirst = "|-------| 1°|-------|";
		String topSecond = "|-------| 2°|-------|";
		String topThird = "|-------| 2°|-------|";
		String topFourth = "|-------| 4°|-------|";
		String centerCard = "|                   |";
		String emptySpace = "                     ";
		String bottomCard = "---------------------";

		final int firstNumToStop = 0;
		final int secondNumToStop = 3;
		final int thirdNumToStop = 6;
		final int fourthNumToStop = 9;
		final int nameNumberToStop = 15;
		final int pointNumberToStop = 17;
		final int maxPodiumheigt = 20;

		switch (playersNumber) {

		case TWO_PLAYERS:

			for (int r = 0; r < maxPodiumheigt; r++) {

				if (r == firstNumToStop) {
					System.out.println(emptySpace + topFirst);
				} else if (r < secondNumToStop) {
					System.out.println(emptySpace + centerCard);
				}

				if (r == secondNumToStop) {
					System.out.println(topSecond + centerCard);
				} else if (r > thirdNumToStop && r > secondNumToStop) {
					System.out.println(centerCard + centerCard);
				}

				if (r == nameNumberToStop) {
					for (int i = 0; i < TWO_PLAYERS; i++) {
						if(i == 0) {
							i = 1;
							printName(players.get(i).getName());
							i = 0;
						}else if(i == 1) {
							i = 0;
							printName(players.get(i).getName());
							i = 1;
						}
						
					}
					System.out.println();
				} else if (r == pointNumberToStop) {
					for (int i = 0; i < TWO_PLAYERS; i++) {
						if(i == 0) {
							i = 1;
							printPoints(players.get(i).getPoints());
							i = 0;
						}else if(i == 1) {
							i = 0;
							printPoints(players.get(i).getPoints());
							i = 1;
						}
						
					}
					System.out.println();
				}

			}
			System.out.println(bottomCard+bottomCard);
			break;

		case THREE_PLAYERS:

			for (int r = 0; r < maxPodiumheigt; r++) {

				if (r == firstNumToStop) {
					System.out.println(emptySpace + topFirst);
				} else if (r < secondNumToStop) {
					System.out.println(emptySpace + centerCard);
				}

				if (r == secondNumToStop) {
					System.out.println(topSecond + centerCard);
				} else if (r < thirdNumToStop && r > secondNumToStop) {
					System.out.println(centerCard + centerCard);
				}

				if (r == fourthNumToStop) {
					System.out.println(centerCard + centerCard + topThird);
				} else if (r > fourthNumToStop && r > thirdNumToStop) {
					System.out.println(centerCard + centerCard + centerCard);
				}

				if (r == nameNumberToStop) {
					for (int i = 0; i < THREE_PLAYERS; i++) {
						if(i == 0) {
							i = 1;
							printName(players.get(i).getName());
							i = 0;
						}else if(i == 1) {
							i = 0;
							printName(players.get(i).getName());
							i = 1;
						}else {
							printName(players.get(i).getName());
						}
						
					}
					System.out.println();
				} else if (r == pointNumberToStop) {
					for (int i = 0; i < THREE_PLAYERS; i++) {
						if(i == 0) {
							i = 1;
							printPoints(players.get(i).getPoints());
							i = 0;
						}else if(i == 1) {
							i = 0;
							printPoints(players.get(i).getPoints());
							i = 1;
						}else {
							printPoints(players.get(i).getPoints());
						}
						
					}
					System.out.println();
				}

			}
			System.out.println(bottomCard+bottomCard+bottomCard);
			break;

		case FOUR_PLAYERS:

			for (int r = 0; r < maxPodiumheigt; r++) {

				if (r == firstNumToStop) {
					System.out.println(emptySpace + topFirst);
				} else if (r < secondNumToStop) {
					System.out.println(emptySpace + centerCard);
				}

				if (r == secondNumToStop) {
					System.out.println(topSecond + centerCard);
				} else if (r < thirdNumToStop && r > secondNumToStop) {
					System.out.println(centerCard + centerCard);
				}

				if (r == fourthNumToStop) {
					System.out.println(centerCard + centerCard + topThird);
				} else if (r < fourthNumToStop && r > thirdNumToStop) {
					System.out.println(centerCard + centerCard + centerCard);
				}

				if (r == fourthNumToStop) {
					System.out.println(centerCard + centerCard + centerCard + topFourth);
				} else if (r > fourthNumToStop) {
					System.out.println(centerCard + centerCard + centerCard + centerCard);
				}

				if (r == nameNumberToStop) {
					for (int i = 0; i < FOUR_PLAYERS; i++) {
						if(i == 0) {
							i = 1;
							printName(players.get(i).getName());
							i = 0;
						}else if(i == 1) {
							i = 0;
							printName(players.get(i).getName());
							i = 1;
						}else {
							printName(players.get(i).getName());
						}
						
					}
					System.out.println();
				} else if (r == pointNumberToStop) {
					for (int i = 0; i < FOUR_PLAYERS; i++) {
						if(i == 0) {
							i = 1;
							printPoints(players.get(i).getPoints());
							i = 0;
						}else if(i == 1) {
							i = 0;
							printPoints(players.get(i).getPoints());
							i = 1;
						}else {
							printPoints(players.get(i).getPoints());
						}
						
					}
					System.out.println();
					
				}

			}
			System.out.println(bottomCard+bottomCard+bottomCard+bottomCard);
			break;

		}

	}

	public static void printName(String name) {
		final int peaceLenght = 21;
		final int maxNameLenght = 12;
		String firstPeace = "| ";
		String lastPeace = " |";
		char[] longName = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

		if (name.length() > maxNameLenght) {

			for (int i = 0; i < maxNameLenght; i++) {
				longName[i] = name.charAt(i);
			}
			name = String.valueOf(longName);

		}

		System.out.print(firstPeace + name);
		int length = peaceLenght - (firstPeace.length() + lastPeace.length() + name.length());
		for (int i = 0; i < length; i++) {
			System.out.print(" ");
		}
		System.out.print(lastPeace);

	}

	public static void printPoints(int points) {

		final int peaceLenght = 21;
		String firstPeace = "| Points: ";
		String lastPeace = " |";

		String stringPoints = Integer.toString(points);

		System.out.print(firstPeace + points);
		int length = peaceLenght - (firstPeace.length() + lastPeace.length() + stringPoints.length());
		for (int i = 0; i < length; i++) {
			System.out.print(" ");
		}
		System.out.print(lastPeace);

	}

}
