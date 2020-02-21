package model.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.data_structures.LinkedList;

class ModeloTest 
{
	/**
	 * Lista sencilla de tipo intger
	 */
	private LinkedList<Integer> lista1;
	
	/*
	 * Escenario 1: Crea una lista sencilla de tipo integer
	 */
	@Before
	public void setupEscenario1( )
	{
		lista1 = new LinkedList<Integer>();
		lista1.addNodeLast(1);
		lista1.addNodeLast(2);
		lista1.addNodeLast(3);
		lista1.addNodeLast(4);
	}
	
	/**
	 * Prueba 1: Verifica el tamaño de comparendos sea correcto
	 */
	@Test
	void testDarTamanoComparendos() 
	{
		setupEscenario1();
		assertEquals(4, lista1.getSize());
	}

	/**
	 * Prueba 2: Revisa que si este copiando el numero de elementos de la lista al arreglo
	 */
	@Test
	void testCopiarComparendosArreglo() 
	{
		setupEscenario1();
		
		@SuppressWarnings("unchecked")
		Comparable<Integer>[] nuevo = (Comparable<Integer>[]) new Comparable[lista1.getSize()];

		Iterator<Integer> it = lista1.iterator();
		while(it.hasNext())
		{
			for(int i = 0; i < lista1.getSize(); i++)
			{
				int elementoActual = it.next();
				nuevo[i] = elementoActual;
			}
		}
		
		assertEquals(4, nuevo.length);
	}

	@Test
	void testShellSort()
	{
		fail("Not yet implemented");
	}

	@Test
	void testQuickSort() {
		fail("Not yet implemented");
	}

	@Test
	void testMerge() {
		fail("Not yet implemented");
	}

}
