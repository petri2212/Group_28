package gui;

import myshelfie.GameManager;

/**
 * Abstract class for the creation of Controller classes of the MVC design patter.
 * The Controller holds a reference to the model. The model is the GameManager that contains the
 * data that will be manipulated by the Controller.
 * The View can also access the model data using its Controller.
 */
public abstract class Controller {

	public GameManager model;

	/**
	 * To construct this class a not-null model reference must be provided.
	 * Null model will cause the constructor to throw a MVCNoModelException.
	 *
	 * @param model	is the reference to the GameManager instance
	 */
	public Controller(GameManager model) {
		if (model == null) {
			throw new MVCNoModelException();
		}

		this.model = model;
	}

}
