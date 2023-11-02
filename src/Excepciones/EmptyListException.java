package Excepciones;

/**
 * Clase EmptyListException que extiende a Exception
 * @author Catalina Simonovich y Valentina Beron
 */
public class EmptyListException extends Exception{
	/**
	 * Crea una excepcion con el mensaje pasado por parametro.
	 * @param msg Mensaje del error.
	 */
	public EmptyListException(String msg) {
		super(msg);
	}
}
