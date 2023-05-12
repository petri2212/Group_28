package myshelfie;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum ResourceImage implements Resource<Image> {
	PERSONAL_GOAL_1("./resourcespersonal_goal_cards/Personal_Goals.png"),
	PERSONAL_GOAL_2("./resourcespersonal_goal_cards/Personal_Goals2.png"),
	PERSONAL_GOAL_3("./resourcespersonal_goal_cards/Personal_Goals3.png"),
	PERSONAL_GOAL_4("./resourcespersonal_goal_cards/Personal_Goals4.png"),
	PERSONAL_GOAL_5("./resourcespersonal_goal_cards/Personal_Goals5.png"),
	PERSONAL_GOAL_6("./resourcespersonal_goal_cards/Personal_Goals6.png"),
	PERSONAL_GOAL_7("./resourcespersonal_goal_cards/Personal_Goals7.png"),
	PERSONAL_GOAL_8("./resourcespersonal_goal_cards/Personal_Goals8.png"),
	PERSONAL_GOAL_9("./resourcespersonal_goal_cards/Personal_Goals9.png"),
	PERSONAL_GOAL_10("./resourcespersonal_goal_cards/Personal_Goals10.png"),
	PERSONAL_GOAL_11("./resourcespersonal_goal_cards/Personal_Goals11.png"),
	PERSONAL_GOAL_12("./resourcespersonal_goal_cards/Personal_Goals12.png"),

	COMMON_GOAL_TWO_FOUR_BY_FOUR_SQUARES("./resourcescommon_goal_cards/TwoFourByFourSquares.jpg"),
	COMMON_GOAL_TWO_COLUMNS_SIX_DIFFERENT_OBJ("./resourcescommon_goal_cards/TwoColumsSixDiffrentObj.jpg"),
	COMMON_GOAL_CORNERS("./resourcescommon_goal_cards/Corners.jpg"),
	COMMON_GOAL_DIAGOONAL("./resourcescommon_goal_cards/Diagonal.jpg"),
	COMMON_GOAL_EIGHT_EQUAL("./resourcescommon_goal_cards/EightEqual.jpg"),
	COMMON_GOAL_FIVE_X("./resourcescommon_goal_cards/FiveX.jpg"),
	COMMON_GOAL_FOUR_LINES_THREE_DIFFERENT_OBJ("./resourcescommon_goal_cards/FourLinesThreeDiffrentObj.jpg"),
	COMMON_GOAL_FOUR_VERTICAL("./resourcescommon_goal_cards/FourVertical.jpg"),
	COMMON_GOAL_SIX_SEPARATE_GROUPS_OF_TWO_OBJ("./resourcescommon_goal_cards/SixSeparateGroupsOfTwoObj.jpg"),
	COMMON_GOAL_STAIRS("./resourcescommon_goal_cards/Stairs.jpg"),
	COMMON_GOAL_THREE_COLUMNS("./resourcescommon_goal_cards/ThreeColumns.jpg"),
	COMMON_GOAL_TWO_LINES_DIFFERENT_OBJ("./resources/common_goal_cards/TwoLinesDiffrentObj.jpg"),

	PUBLISHER_MATERIAL_DISPLAY_1("./resources/publisher_material/Display_1.jpg");

	private String path;

	private ResourceImage(String path) {
		this.path = path;
	}

	@Override
	public Image load() {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
