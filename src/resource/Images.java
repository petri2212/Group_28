package resource;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Images implements Resource<Image> {

	BOOKSHELF_OBJECT_FRAME_1("./resources/item_tiles/resized/Cornici1.1.png"),
	BOOKSHELF_OBJECT_FRAME_2("./resources/item_tiles/resized/Cornici1.2.png"),
	BOOKSHELF_OBJECT_FRAME_3("./resources/item_tiles/resized/Cornici1.3.png"),
	BOOKSHELF_OBJECT_CAT_1("./resources/item_tiles/resized/Gatti1.1.png"),
	BOOKSHELF_OBJECT_CAT_2("./resources/item_tiles/resized/Gatti1.2.png"),
	BOOKSHELF_OBJECT_CAT_3("./resources/item_tiles/resized/Gatti1.3.png"),
	BOOKSHELF_OBJECT_GAME_1("./resources/item_tiles/resized/Giochi1.1.png"),
	BOOKSHELF_OBJECT_GAME_2("./resources/item_tiles/resized/Giochi1.2.png"),
	BOOKSHELF_OBJECT_GAME_3("./resources/item_tiles/resized/Giochi1.3.png"),
	BOOKSHELF_OBJECT_BOOK_1("./resources/item_tiles/resized/Libri1.1.png"),
	BOOKSHELF_OBJECT_BOOK_2("./resources/item_tiles/resized/Libri1.2.png"),
	BOOKSHELF_OBJECT_BOOK_3("./resources/item_tiles/resized/Libri1.3.png"),
	BOOKSHELF_OBJECT_PLANT_1("./resources/item_tiles/resized/Piante1.1.png"),
	BOOKSHELF_OBJECT_PLANT_2("./resources/item_tiles/resized/Piante1.2.png"),
	BOOKSHELF_OBJECT_PLANT_3("./resources/item_tiles/resized/Piante1.3.png"),
	BOOKSHELF_OBJECT_TROPHY_1("./resources/item_tiles/resized/Trofei1.1.png"),
	BOOKSHELF_OBJECT_TROPHY_2("./resources/item_tiles/resized/Trofei1.2.png"),
	BOOKSHELF_OBJECT_TROPHY_3("./resources/item_tiles/resized/Trofei1.3.png"),
	
	PERSONAL_GOAL_1("./resources/personal_goal_cards/resized/Personal_Goals.png"),
	PERSONAL_GOAL_2("./resources/personal_goal_cards/resized/Personal_Goals2.png"),
	PERSONAL_GOAL_3("./resources/personal_goal_cards/resized/Personal_Goals3.png"),
	PERSONAL_GOAL_4("./resources/personal_goal_cards/resized/Personal_Goals4.png"),
	PERSONAL_GOAL_5("./resources/personal_goal_cards/resized/Personal_Goals5.png"),
	PERSONAL_GOAL_6("./resources/personal_goal_cards/resized/Personal_Goals6.png"),
	PERSONAL_GOAL_7("./resources/personal_goal_cards/resized/Personal_Goals7.png"),
	PERSONAL_GOAL_8("./resources/personal_goal_cards/resized/Personal_Goals8.png"),
	PERSONAL_GOAL_9("./resources/personal_goal_cards/resized/Personal_Goals9.png"),
	PERSONAL_GOAL_10("./resources/personal_goal_cards/resized/Personal_Goals10.png"),
	PERSONAL_GOAL_11("./resources/personal_goal_cards/resized/Personal_Goals11.png"),
	PERSONAL_GOAL_12("./resources/personal_goal_cards/resized/Personal_Goals12.png"),

	COMMON_GOAL_TWO_FOUR_BY_FOUR_SQUARES("./resources/common_goal_cards/resized/TwoFourByFourSquares.jpg"),
	COMMON_GOAL_TWO_COLUMNS_SIX_DIFFERENT_OBJ("./resources/common_goal_cards/resized/TwoColumsSixDiffrentObj.jpg"),
	COMMON_GOAL_CORNERS("./resources/common_goal_cards/resized/Corners.jpg"),
	COMMON_GOAL_DIAGOONAL("./resources/common_goal_cards/resized/Diagonal.jpg"),
	COMMON_GOAL_EIGHT_EQUAL("./resources/common_goal_cards/resized/EightEqual.jpg"),
	COMMON_GOAL_FIVE_X("./resources/common_goal_cards/resized/FiveX.jpg"),
	COMMON_GOAL_FOUR_LINES_THREE_DIFFERENT_OBJ("./resources/common_goal_cards/resized/FourLinesThreeDiffrentObj.jpg"),
	COMMON_GOAL_FOUR_VERTICAL("./resources/common_goal_cards/resized/FourVertical.jpg"),
	COMMON_GOAL_SIX_SEPARATE_GROUPS_OF_TWO_OBJ("./resources/common_goal_cards/resized/SixSeparateGroupsOfTwoObj.jpg"),
	COMMON_GOAL_STAIRS("./resources/common_goal_cards/resized/Stairs.jpg"),
	COMMON_GOAL_THREE_COLUMNS("./resources/common_goal_cards/resized/ThreeColumns.jpg"),
	COMMON_GOAL_TWO_LINES_DIFFERENT_OBJ("./resources/common_goal_cards/resized/TwoLinesDiffrentObj.jpg"),

	PUBLISHER_MATERIAL_DISPLAY_1("./resources/publisher_material/Display_1.jpg"),
	PUBLISHER_MATERIAL_DISPLAY_1_BLURRED("./resources/publisher_material/Display_1_Blurred.jpg"),
	ICON_MY_SHELFIE("./resources/publisher_material/Icon 50x50px.png"),
	PUBLISHER_MATERIAL_MAIN_PAGE("./resources/publisher_material/main_page.png");

	private String path;

	private Images(String path) {
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
