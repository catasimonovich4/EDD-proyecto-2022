package Excepciones;

/**
 * Clase InvalidKeyException que extiende a Exception
 * @author Catalina Simonovich y Valentina Beron
 */
public class InvalidKeyException extends Exception{
	/**
	 * Crea una excepcion con el mensaje pasado por parametro.
	 * @param msg Mensaje del error.
	 */
	public InvalidKeyException(String msg) {
		super(msg);
	}

}
