package Auxiliares;
import TDAColaCP.*;

/**
 * Clase ComparadorMax que implementa java.util.Comparator.
 * @author Catalina Simonovich y Valentina Beron.
 */
public class ComparadorMax<E> extends Comparador<E> implements java.util.Comparator<E> {
	/**
	 * Compara dos objetos ingresados por parametro.
	 * @param a Uno de los dos elementos a comparar.
	 * @param b Uno de los dos elementos a comparar.
	 * @return Retorna 0 si a es igual a b, un entero positivo si a
	 * es menor a b y un entero negativo si a es mayor a b.
	 */
	public int compare(E a, E b) {
		return (((Comparable<E>) a).compareTo(b))*(-1); 
	}
}
