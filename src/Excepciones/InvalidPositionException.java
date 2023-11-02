package Excepciones;

/**
 * Clase InvalidPositionException que extiende a Exception
 * @author Catalina Simonovich y Valentina Beron
 */
public class InvalidPositionException extends Exception{
	/**
	 * Crea una excepcion con el mensaje pasado por parametro.
	 * @param msg Mensaje del error.
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}
}
