package Programa;
import java.util.Iterator;

import javax.swing.JOptionPane;

import TDALista.*;
import TDAColaCP.*;
import TDADiccionario.*;
import Excepciones.*;
import Auxiliares.*;

/**
 * Clase Programa
 * @author Catalina Simonovich y Valentina Beron.
 */
public class Programa {
	/**
	 *  Nombre de la materia.
	 */
	private String materia;
	/**
	 *  Lista de pares que contendra LU y la nota obtenida por el alumno.
	 */
	private PositionList<Par<Integer,Integer>> listaPares;
	
	/**
	 * Constructor de la clase.
	 * @param materia Nombre de la materia.
	 * @param l Lista de Pares.
	 */
	public Programa() {
		listaPares = new ListaDoblementeEnlazada<Par<Integer, Integer>>();
	}
	
	/**
	 * Consulta si hay alumnos cargados en el sistema.
	 * @return Verdadero si la lista esta vacia, falso en caso contrario.
	 */
	public boolean isEmpty() {
		return listaPares.isEmpty();
	}
	
	/**
	 * Almacena el nombre de la materia que se ingresa como parametro en 
	 * el atributo de instancia materia.
	 * @param materia Nombre de la materia a almacenar.
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	/**
	 * Consulta el nombre de la materia almacenado.
	 * @return El nombre de la materia.
	 */
	public String getMateria() {
		return materia;
	} 
	
	/**
	 * Almacena el par de entrada que contiene el numero de LU y la nota del alumno
	 * que se ingresa como parametro.
	 * @param LU Numero de LU del alumno.
	 * @param nota Nota obtenida por el alumno.
	 * @return Verdadero si los datos fueron almacenados correctamente y falso en caso contrario.
	 */
	public boolean setListaPares(int LU, int nota) {
		Par<Integer, Integer> newPar;
		boolean ok = true;
		if (exist(LU)) {
			ok = false;
		} else {
				newPar = new Par<Integer, Integer>(LU, nota);
				listaPares.addLast(newPar);
		}
		return ok; 
	}
	
	/**
	 * Consulta la nota correspondiente al numero de LU ingresado por parametro.
	 * @param LU Numero de LU del alumno del que se quiere obtener la nota.
	 * @return Nota correspondiente al LU ingresado y 0 en el caso que no se encuentren datos
	 * registrados o el LU ingresado como parametro no este almacenado en la lista.
	 * @throws EmptyListException si no hay datos registrados.
	 */
	public int notaDeLU(int LU) throws EmptyListException{
		int nota = 0;
		if (listaPares.isEmpty()) 
			throw new EmptyListException("notaDeLU(): no hay datos registrados");
		else {
			if (!exist(LU)) 
				nota = -1;
			else {
				boolean encontre = false;;
				Iterator<Par<Integer, Integer>> pares = listaPares.iterator();
				while (pares.hasNext() && !encontre) {
					Par<Integer, Integer> entry = pares.next();
					if (entry.getLU().equals(LU)) {
						nota = entry.getNota();
						encontre = true;
					}
				}
			}
		}
		return nota;
	}
	
	/**
	 * Elimina los datos correspondientes al LU ingresado por parametro.
	 * @param LU Numero de LU del alumno que se desean eliminar datos.
	 * @return Verdadero si se han eliminado correctamente los datos y falso en caso contrario.
	 * @throws EmptyListException si no hay datos registrados.
	 */
	public boolean remove(int LU) throws EmptyListException {
		boolean ok = false;
		try { 	
				if (listaPares.isEmpty()) 
					throw new EmptyListException("remove(): no hay datos");
					//JOptionPane.showMessageDialog(null, "No existen datos registrados.");
				else {
						if (exist(LU)) {
							boolean encontre = false;
							Iterable<Position<Par<Integer, Integer>>> paresPos = listaPares.positions();
							Iterator<Position<Par<Integer, Integer>>> paresIt = paresPos.iterator();
							while (!encontre && paresIt.hasNext()) {
								Position<Par<Integer, Integer>> next = paresIt.next();
								if (next.element().getLU().equals(LU)) {
									encontre = true;
									listaPares.remove(next);
								}
							}
							ok = true;
						}
				}
			
		} catch (InvalidPositionException e ) {
			System.out.println("Error: " + e.getMessage());
		}
		return ok;
	}
	
	/**
	 * Calcula el promedio de todas las notas almacenadas.
	 * @return Promedio de notas.
	 * @throws EmptyListException si no hay datos registrados.
	 */
	public float promedioTotal() throws EmptyListException {
		float promedio = 0;
		if (listaPares.isEmpty()) 
			throw new EmptyListException("promedioTotal(): no hay datos");
		else {
				Iterator<Par<Integer, Integer>> notas = listaPares.iterator();
				int contador = 0;
				for (int i = 0; i < listaPares.size(); i++) {
					Par<Integer, Integer> next = notas.next();
					contador += next.getNota();
				}
				promedio = (float) contador / listaPares.size();
		}
		return promedio;  
	}
	
	/**
	 * Consulta la menor nota almacenada.
	 * @return Nota minima y 0 si no existen datos almacenados.
	 * @throws EmptyListException si no hay datos registrados.
	 */
	public int minNota() throws EmptyListException {
		int notaMin = 0;
		if (listaPares.isEmpty()) 
			throw new EmptyListException("minNota(): no hay datos"); 
		else {
			Heap<Integer, Integer> cp = new Heap<Integer, Integer>(new Comparador<Integer>());
			for (Par<Integer, Integer> entries: listaPares) {
				try {
					cp.insert(entries.getNota(), entries.getLU());
					
				} catch (InvalidKeyException e) {
					System.out.println("Error: " + e.getMessage());
				}
				
				try {
						notaMin = cp.min().getKey();
				} catch (EmptyPriorityQueueException e) {
					System.out.println("Error: " + e.getMessage());
				}
			
			}
		} 
		return notaMin;
	}
	
	/**
	 * Ordena los datos por sus notas de mayor a menor.
	 * @return Lista iterable de pares de entradas ordenada por las notas de mayor a menor.
	 * @throws EmptyListException si no hay datos registrados.
	 */
	public Iterable<Entry<Integer, Integer>> ordenar() throws EmptyListException {
		PositionList<Entry<Integer, Integer>> orderedList = new ListaDoblementeEnlazada<Entry<Integer,Integer>>();
		if (listaPares.isEmpty()) 
			throw new EmptyListException("ordenar(): no hay datos");
		else {
				Comparador<Integer> comp = new ComparadorMax<Integer>();
				PriorityQueue<Integer,Integer> colaNotas = new Heap<Integer,Integer>(comp);
				for (Par<Integer,Integer> par: listaPares) {
					try {
						colaNotas.insert(par.getNota(), par.getLU());
					} catch (InvalidKeyException e) {
						System.out.println("Error: " + e.getMessage());
					}
				}
				while (!colaNotas.isEmpty()) {
					try {
						orderedList.addLast(colaNotas.min());
						colaNotas.removeMin();
					} catch (EmptyPriorityQueueException e) {
						System.out.println("Error: " + e.getMessage());
					}
				}
		}
		return orderedList;
	}
	
	/**
	 * Consulta aquellos alumnos que obtuvieron la nota numerica pasada como parametro.
	 * @param nota Nota numerica obtenida por los alumnos.
	 * @return Lista iterable de pares de entradas de aquellos alumnos que obtuvieron 
	 * la nota pasada por parametro.
	 */
	public Iterable<Entry<Integer,Integer>> searchByNota(int nota) {
		Iterable<Entry<Integer,Integer>> LUList = null;
		DictHashAbierto<Integer,Integer> dictionary = new DictHashAbierto<Integer,Integer>();
		for (Par<Integer,Integer> entry: listaPares) {
			try {
				dictionary.insert(entry.getNota(), entry.getLU());
			} catch (InvalidKeyException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		
		try {					
			LUList = dictionary.findAll(nota);
		} catch (InvalidKeyException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return LUList;
	}
	
	/**
	 * Metodo utilizado para visualizar todos los datos almacenados.
	 * @return Lista iterable de pares de entradas de todos los datos almacenados.
	 */
	public Iterable<Par<Integer,Integer>> showAll() {
		return listaPares;
	}
	
	/**
	 * Metodo utilizado para visualizar los alumnos aprobados.
	 * @return Lista iterable de pares de entrada de aquellos alumnos aprobados.
	 * @throws EmptyListException si no hay datos registrados.
	 */
	public Iterable<Par<Integer,Integer>> showApproved() throws EmptyListException {
		PositionList<Par<Integer,Integer>> approvedList = new ListaDoblementeEnlazada<Par<Integer,Integer>>();
		if (listaPares.isEmpty()) 
			throw new EmptyListException("showApproved(): no hay datos");
		else {
				for (Par<Integer,Integer> entry: listaPares) {
					if (entry.getNota() >= 6) 
						approvedList.addLast(entry);
				}
		}
		return approvedList;
	}
	
	/**
	 * Metodo utilizado para visualizar los alumnos desaprobados.
	 * @return Lista iterable de pares de entrada de aquellos alumnos desaprobados.
	 * @throws EmptyListException si no hay datos registrados.
	 */
	public Iterable<Par<Integer,Integer>> showNotApproved() throws EmptyListException {
		PositionList<Par<Integer,Integer>> notApprovedList = new ListaDoblementeEnlazada<Par<Integer,Integer>>();
		if (listaPares.isEmpty()) 
			throw new EmptyListException("showNotApproved(): no hay datos");
		else {
				for (Par<Integer,Integer> entry: listaPares) {
					if (entry.getNota() < 6) 
						notApprovedList.addLast(entry);
				}
		}
		return notApprovedList;
	}
	
	//----------------------------Metodos privados-----------------------------------------
	/**
	 * Determina si el LU ingresado por parametro se encuentra almacenado.
	 * @param LU Numero de LU del alumno a consultar si existe.
	 * @return Verdadero si el LU ingresado esta almacenado en la lista y falso en caso contrario.
	 */
	private boolean exist(int LU) {
		boolean exist = false;
		Iterator<Par<Integer, Integer>> pares = listaPares.iterator();
		while (!exist && pares.hasNext()) {
			Par<Integer, Integer> next = pares.next();
			if (next.getLU().equals(LU)) {
				exist = true;
			}
		}
		return exist;
	
	}

}