package Excepciones;

/**
 * Clase EmptyPriorityQueueException que extiende a Exception.
 * @author Catalina Simonovich y Valentina Beron.
 */
public class EmptyPriorityQueueException extends Exception{
	/**
	 * Crea una excepcion con el mensaje pasado por parametro.
	 * @param msg Mensaje del error.
	 */
	public EmptyPriorityQueueException(String msg) {
		super(msg);
	}
}
