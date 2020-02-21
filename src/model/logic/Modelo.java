package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.google.gson.Gson;

import Infracciones.Example;
import model.data_structures.*;

/**
 * Definicion del modelo del mundo
 * Usamos metodos del Libro Algorithms 4 edition:
 * 1. shellSort, less, exch, quickSort y partition elaborados por los autores: Robert Sedgewick y Kevin Wayne.
 */
public class Modelo 
{
	/**
	 * Lista-pila de tipo Comparendos
	 */
	private LinkedList<Comparendo> datos1;

	/**
	 * Constructor del modelo del mundo
	 */
	public Modelo()
	{	
		Gson gson = new Gson();
		BufferedReader br = null;
		datos1 = new LinkedList<>();

		try
		{
			br = new BufferedReader(new FileReader("./data/comparendos_dei_2018_small.geojson"));
			Example result = gson.fromJson(br, Example.class);

			for(int  i = 0; i < result.getFeatures().size(); i ++)
			{
				int objective = result.getFeatures().get(i).getProperties().getOBJECTID();
				String fecha_hora = result.getFeatures().get(i).getProperties().getFECHAHORA();
				String medio_dete = result.getFeatures().get(i).getProperties().getMEDIODETE();
				String clase_vehi = result.getFeatures().get(i).getProperties().getCLASEVEHI();
				String tipo_servi = result.getFeatures().get(i).getProperties().getTIPOSERVI();
				String infraccion = result.getFeatures().get(i).getProperties().getINFRACCION();
				String des_infrac = result.getFeatures().get(i).getProperties().getDESINFRAC();
				String localidad = result.getFeatures().get(i).getProperties().getLOCALIDAD();
				double cordenada1 = result.getFeatures().get(i).getGeometry().getCoordinates().get(0);
				double cordenada2 = result.getFeatures().get(i).getGeometry().getCoordinates().get(1);

				Comparendo actual = new Comparendo(objective, fecha_hora, medio_dete, clase_vehi, tipo_servi, infraccion, des_infrac, localidad, cordenada1, cordenada2);
				datos1.addNodeFirst(actual);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		finally
		{
			if(br != null)
			{
				try 
				{
					br.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo de la pila
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoComparendos()
	{
		return datos1.getSize();
	}

	/**
	 * Metodo que retorna un string con la informacion basica del comparendo de acuerdo con la posicion
	 * @param pPosicion Posicion del objeto
	 * @return Retorna cadena de string con la informacion baica del comparendo
	 */
	public String darDatos(int pPosicion)
	{
		String informacion = datos1.seeObjetc(pPosicion).getObjective() + ", " + datos1.seeObjetc(pPosicion).getFecha_hora() + ", " + datos1.seeObjetc(pPosicion).getInfraccion() + ", " + 
				datos1.seeObjetc(pPosicion).getClase_vehi() + ", " + datos1.seeObjetc(pPosicion).getTipo_servi() + ", " + datos1.seeObjetc(pPosicion).getLocalidad();
		return informacion;
	}

	/**
	 * Crea un arreglo comparable de los comparendos para poder ser utilizado en los sorts
	 * @return Arreglo Comparable<Comparendos>
	 */
	public Comparable<Comparendo>[] copiarComparendosArreglo()
	{
		@SuppressWarnings("unchecked")
		Comparable<Comparendo>[] nuevo = (Comparable<Comparendo>[]) new Comparable[datos1.getSize()];

		Iterator<Comparendo> it = datos1.iterator();
		while(it.hasNext())
		{
			for(int i = 0; i < datos1.getSize(); i++)
			{
				Comparendo elementoActual = it.next();
				nuevo[i] = new Comparendo(elementoActual.getObjective(), elementoActual.getFecha_hora(), elementoActual.getMedio_dete(), elementoActual.getClase_vehi(), elementoActual.getTipo_servi(), elementoActual.getInfraccion(), elementoActual.getDes_infrac(), elementoActual.getLocalidad(), elementoActual.getCordenadas()[0], elementoActual.getCordenadas()[1]);
			}
		}

		return nuevo;
	}

	/**
	 * Este metodo se encarga de ordenar bajo el criterio de shellSort
	 * Funcion principal: Shell sort es un algoritmo que primero clasifica los elementos muy separados entre sí y sucesivamente reduce el intervalo entre los elementos a clasificar.
	 * @param a Comparendo de tipo compareble bajo el criterio de comparcion por fecha_hora, objectid depende del caso
	 */
	public static void shellSort(Comparable<Comparendo>[] a) 
	{
		int n = a.length;

		int h = 1;
		while (h < n/3) h = 3*h + 1; 

		while (h >= 1) 
		{
			for (int i = h; i < n; i++) 
			{
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) 
				{
					exch(a, j, j-h);
				}
			}
			h /= 3;
		}
	}

	/**
	 * Se encarga de determinar si el comparendo es menor
	 * @param v Comparendo1 de tipo coparable bajo el criterio de comparcion por fecha_hora, objectid depende del caso
	 * @param w Comparendo2 de tipo coparable bajo el criterio de comparcion por fecha_hora, objectid depende del caso
	 * @return True si es menor, false en el caso contrario
	 */
	private static boolean less(Comparable<Comparendo> v, Comparable<Comparendo> w) 
	{
		return v.compareTo((Comparendo) w) < 0;
	}

	/**
	 * Cambia el objeto de una posicion a otra
	 * @param a Objeto a intercambiar en el arreglo
	 * @param i Posicion en i
	 * @param j Posicion en j
	 */
	private static void exch(Object[] a, int i, int j) 
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * Este metodo se encarga de ordenar bajo el criterio de quickSort
	 * Es un algoritmo basado en la técnica de divide y vencerás, que permite, en promedio, ordenar n elementos en un tiempo proporcional a n log n.
	 * @param a Objeto a intercambiar en el arreglo
	 * @param lo Indice de la posicion inicial
	 * @param hi Indice de la posicion final
	 */
	public static void quickSort(Comparable<Comparendo>[] a, int lo, int hi) 
	{ 
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		quickSort(a, lo, j-1);
		quickSort(a, j+1, hi);
	}

	/**
	 * Parte el arreglo en sub arreglos para ordenar de manera mas facil
	 * @param a Objeto a intercambiar en el arreglo
	 * @param lo Indice de la posicion inicial
	 * @param hi Indice de la posicion final
	 * @return Indice donde se realizo el corte del arreglos
	 */
	private static int partition(Comparable<Comparendo>[] a, int lo, int hi)
	{
		int i = lo;
		int j = hi + 1;
		Comparable<Comparendo> v = a[lo];
		while (true) 
		{ 
			while (less(a[++i], v)) 
			{
				if (i == hi) break;
			}

			while (less(v, a[--j])) 
			{
				if (j == lo) break;      
			}

			if (i >= j) break;
			exch(a, i, j);
		}

		exch(a, lo, j);
		return j;
	}

	/**
	 * 
	 * @param a
	 * @param aux
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(Comparable<Comparendo>[] a, Comparable<Comparendo>[] aux, int lo, int mid, int hi) 
	{
		for (int k = lo; k <= hi; k++)
		{
			aux[k] = a[k]; 
		}

		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) 
		{
			if(i > mid)            
			{
				a[k] = aux[j++];
			}
			else if(j > hi)           
			{
				a[k] = aux[i++];
			}
			else if(less(aux[j], aux[i]))
			{
				a[k] = aux[j++];
			}
			else                          
			{
				a[k] = aux[i++];
			}
		}
	}
}
