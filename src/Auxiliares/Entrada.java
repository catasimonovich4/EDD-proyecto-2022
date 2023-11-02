package Auxiliares;

/**
 * Clase Entrada que implementa la interfaz Entry.
 * @author Catalina Simonovich y Valentina Beron.
 */
public class Entrada<K, V> implements Entry<K,V>{
	/**
	 * Clave del par generico de la clase.
	 */
	private K clave;	
	/**
	 * Valor del par generico de la clase.
	 */
	private V valor;
	
	/**
	 * Constructor de clase que inicializa los atributos de instancia con los valores ingresados por parametro.
	 * @param key Valor a inicializar el atributo de instancia clave.
	 * @param value Valor a inicializar el atributo de instancia valor.
	 */
	public Entrada(K key, V value) {
		clave = key;
		valor = value;
	}
	
	/**
	 * Consulta el valor de la clave de la entrada.
	 * @return Valor del atributo de instania clave.  
	 */
	public K getKey(){
		return clave;
	}
	
	/**
	 * Consulta el valor del atributo de instancia valor de la entrada.
	 * @return Valor del atributo de instancia valor.  
	 */
	public V getValue() {
		return valor;
	}
	
	/**
	 * Determina un nuevo valor pasado por parametro para el atributo de instancia clave.
	 * @param key Nuevo valor a determinar en el atributo de instancia clave.
	 */
	public void setKey(K key) {
		clave = key;
	}
	
	/**
	 * Determina un nuevo valor pasado por parametro para el atributo de instancia valor.
	 * @param value Nuevo valor a determinar en el atributo de instancia valor.
	 */
	public void setValue(V value) {
		valor = value;
	}
	
	/**
	 * Concatena los valores de los atributos de intancia clave y valor de la entrada.
	 * @return Entrada concatenada.
	 */
	public String toString() {
		return "(" + getKey() + " " + getValue() + ")"; 
	}
	
}
