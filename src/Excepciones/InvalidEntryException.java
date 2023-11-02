package Excepciones;

/**
 * Clase InvalidEntryException que extiende a Exception
 * @author Catalina Simonovich y Valentina Beron
 */
public class InvalidEntryException extends Exception {
	/**
	 * Crea una excepcion con el mensaje pasado por parametro.
	 * @param msg Mensaje del error.
	 */
	public InvalidEntryException(String msg) {
		super(msg);
	}

}
