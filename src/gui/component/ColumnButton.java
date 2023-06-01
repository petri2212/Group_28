package gui.component;

import javax.swing.JButton;
/*+
 * This class extends JButton and it is used for the graphic. 
 */
public class ColumnButton extends JButton {

	private static final long serialVersionUID = 7761064743097750289L;

	private int colIndex;

	public ColumnButton(int colIndex) {
		this.colIndex = colIndex;
	}

	public int getColIndex() {
		return colIndex;
	}
}
