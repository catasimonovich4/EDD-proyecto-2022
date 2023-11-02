package TDALista;

/**
 * Interface Position
 * @author Catalina Simonovich y Valentina Beron.
 * @param E Parametro generico
 */
public interface Position<E> {
	/**
	 * Consulta el elemento almacenado en una posicion.
	 * @return Elemento almacenado.
	 */
	public E element();
}