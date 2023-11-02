package Programa;

/**
 * Clase Par 
 * @author Catalina Simonovich y Valentina Beron.
 */
public class Par<K,V> {   
	/**
	 * Numero de LU del alumno.
	 */
	protected K LU;     
	/**
	 * Nota numerica obtenida. 
	 */
	protected V nota;	 
	
	/**
	 * Crea un par inicializando los atributos de instancia con los datos pasados por parametro.
	 * @param LU Numero de LU del alumno
	 * @param nota Nota numerica obtenida.
	 */
	public Par(K LU, V nota) {
		this.LU = LU;
		this.nota = nota;
	}
	
	/**
	 * Consulta el LU del alumno.
	 * @return Numero de LU del alumno.
	 */
	public K getLU() {
		return LU;
	}
	/** 
	 * Consulta la nota del alumno.
	 * @return Nota numerica obtenida.
	 */
	public V getNota() {
		return nota;
	}
	/**
	 * Concatena el numero de LU con la nota numerica obtenida.
	 * @return Concatenacion de LU y nota.
	 */
	public String toString() {
		return "[" + getLU() + "," + getNota() + "]";	
 	}
}
