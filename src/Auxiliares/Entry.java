package Auxiliares;

/**
 * Interface Entry
 * @author Catalina Simonovich y Valentina Beron.
 */
public interface Entry<K, V> {
	/**
	 * Consulta el valor de key.
	 * @return Valor de key.
	 */
	public K getKey();
	
	/**
	 * Consulta el valor de value.
	 * @return Valor de value.
	 */
	public V getValue();
}
