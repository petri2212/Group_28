package gui.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;

import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class BookshelfObjectButton extends JButton {

	private static final long serialVersionUID = -725489561743165796L;
	private Image background;
	private BookshelfObject object;
	private MatrixCoords coords;

	public BookshelfObjectButton() {
	}

	public BookshelfObjectButton(BookshelfObject object, MatrixCoords coords) {
		setBackground(object.getImage());
		this.object = object;
		this.coords = coords;
	}

	public void setBackground(Image background) {
		this.background = background;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(background.getWidth(this), background.getHeight(this));
	}

	public void setObject(BookshelfObject object) {
		this.object = object;
	}

	public BookshelfObject getObject() {
		return object;
	}

	public void setCoords(MatrixCoords coords) {
		this.coords = coords;
	}

	public MatrixCoords getCoords() {
		return coords;
	}
}
