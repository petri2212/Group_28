package myshelfie;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public enum ResourceImage implements Resource<Image> {
	PERSONAL_GOAL_1("resources/personal_goal_cards/Personal_Goals.png"),
	PERSONAL_GOAL_2("resources/personal_goal_cards/Personal_Goals2.png"),
	PERSONAL_GOAL_3("resources/personal_goal_cards/Personal_Goals3.png"),
	PERSONAL_GOAL_4("resources/personal_goal_cards/Personal_Goals4.png"),
	PERSONAL_GOAL_5("resources/personal_goal_cards/Personal_Goals5.png"),
	PERSONAL_GOAL_6("resources/personal_goal_cards/Personal_Goals6.png"),
	PERSONAL_GOAL_7("resources/personal_goal_cards/Personal_Goals7.png"),
	PERSONAL_GOAL_8("resources/personal_goal_cards/Personal_Goals8.png"),
	PERSONAL_GOAL_9("resources/personal_goal_cards/Personal_Goals9.png"),
	PERSONAL_GOAL_10("resources/personal_goal_cards/Personal_Goals10.png"),
	PERSONAL_GOAL_11("resources/personal_goal_cards/Personal_Goals11.png"),
	PERSONAL_GOAL_12("resources/personal_goal_cards/Personal_Goals12.png"),

	COMMON_GOAL_TWO_FOUR_BY_FOUR_SQUARES("resources/common_goal_cards/TwoFourByFourSquares.jpg"),
	COMMON_GOAL_TWO_COLUMNS_SIX_DIFFERENT_OBJ("resources/common_goal_cards/TwoColumsSixDiffrentObj.jpg"),
	COMMON_GOAL_CORNERS("resources/common_goal_cards/Corners.jpg"),
	COMMON_GOAL_DIAGOONAL("resources/common_goal_cards/Diagonal.jpg"),
	COMMON_GOAL_EIGHT_EQUAL("resources/common_goal_cards/EightEqual.jpg"),
	COMMON_GOAL_FIVE_X("resources/common_goal_cards/FiveX.jpg"),
	COMMON_GOAL_FOUR_LINES_THREE_DIFFERENT_OBJ("resources/common_goal_cards/FourLinesThreeDiffrentObj.jpg"),
	COMMON_GOAL_FOUR_VERTICAL("resources/common_goal_cards/FourVertical.jpg"),
	COMMON_GOAL_SIX_SEPARATE_GROUPS_OF_TWO_OBJ("resources/common_goal_cards/SixSeparateGroupsOfTwoObj.jpg"),
	COMMON_GOAL_STAIRS("resources/common_goal_cards/Stairs.jpg"),
	COMMON_GOAL_THREE_COLUMNS("resources/common_goal_cards/ThreeColumns.jpg"),
	COMMON_GOAL_TWO_LINES_DIFFERENT_OBJ("resources/common_goal_cards/TwoLinesDiffrentObj.jpg"),

	PUBLISHER_MATERIAL_DISPLAY_1("resources/publisher_material/Display_1.jpg");

	private String path;

	private ResourceImage(String path) {
		this.path = path;
	}

	@Override
	public Image load() {
		URL url = getClass().getClassLoader().getResource(path);

		try {
			return ImageIO.read(url);
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
