package gui;

/**
 * Abstract class for the creation of View classes of the MVC design patter.
 * When creating a new View class, the type of controller must be specified to allows the View
 * to call the correct methods of the Controller.
 * No business logic should be implemented in the concrete implementations of this class.
 *
 * @param <T>	is the instance of the Controller class to use
 */
public abstract class View <T extends Controller> {

	protected T controller;

	/**
	 * To construct this class a not-null Controller reference must be provided.
	 * Null Controller will cause the constructor to throw a MVCNoControllerException.
	 *
	 * @param controller	is the reference to a generic Controller instance
	 */
	public View (T controller) {
		if (controller == null) {
			throw new MVCNoControllerException();
		}

		this.controller = controller;
	}

	/**
	 * This method must be implemented specifically for every View, allowing to manage different
	 * types of input-output models.
	 */
	public abstract void show();

}
