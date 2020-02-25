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
	
	private LinkedList<Double> lista2;

	
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
	
	public void setupEscenarioAleatorio( )
	{
		lista2 = new LinkedList<Double>();
		
		lista2.addNodeLast( 7.0 );
		lista2.addNodeLast( 5.0 );
		lista2.addNodeLast( 4.0 );
		lista2.addNodeLast( 3.0 );
		lista2.addNodeLast( 2.0 );


		for (int i = 0; i < 90; i++)
		{
			lista2.addNodeLast( Math.random() );
		}
		
		lista2.addNodeLast( -1.0 );
		lista2.addNodeLast( -2.0 );
		lista2.addNodeLast( -3.0 );
		lista2.addNodeLast( -4.0 );
		lista2.addNodeLast( -5.0 );


	}
	
	public void setupEscenarioAsc( )
	{
		lista1 = new LinkedList<Integer>();
		
		for (int i = 0; i < 100; i++)
		{
			lista1.addNodeLast( i );
		}

	}
	
	public void setupEscenarioDes( )
	{
		lista1 = new LinkedList<Integer>();
		
		for (int i = 100; i > 0; i--)
		{
			lista1.addNodeLast( i );
		}

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
		setupEscenarioAleatorio();
		
		
		assertEquals(100, lista2.getSize());

		assertEquals(-5, lista2.getFirst().getItem() );
		assertEquals(-4, lista2.getFirst().getItem() );
		assertEquals(-3, lista2.getFirst().getItem() );
		assertEquals(-2, lista2.getFirst().getItem() );
		assertEquals(-1, lista2.getFirst().getItem() );
		
		for (int i = 0; i < 90; i++)
		{
			lista2.getFirst();
		}
		
		assertEquals(2, lista2.getFirst().getItem() );
		assertEquals(3, lista2.getFirst().getItem() );
		assertEquals(4, lista2.getFirst().getItem() );
		assertEquals(5, lista2.getFirst().getItem() );
		assertEquals(7, lista2.getFirst().getItem() );

		
		
		
		setupEscenarioAsc();
		
		assertEquals(100, lista1.getSize());
		
		for (int i = 0; i < 100; i++)
		{
			assertEquals(i, lista1.getFirst().getItem() );
		}
		
		
		
		
		setupEscenarioDes();
		
		assertEquals(100, lista1.getSize());
		
		for (int i = 100; i > 0; i--)
		{
			assertEquals(i, lista1.getFirst().getItem() );
		}

	}

	@Test
	void testQuickSort() 
	{
		setupEscenarioAleatorio();
		
		
		assertEquals(100, lista2.getSize());

		assertEquals(-5, lista2.getFirst().getItem() );
		assertEquals(-4, lista2.getFirst().getItem() );
		assertEquals(-3, lista2.getFirst().getItem() );
		assertEquals(-2, lista2.getFirst().getItem() );
		assertEquals(-1, lista2.getFirst().getItem() );
		
		for (int i = 0; i < 90; i++)
		{
			lista2.getFirst();
		}
		
		assertEquals(2, lista2.getFirst().getItem() );
		assertEquals(3, lista2.getFirst().getItem() );
		assertEquals(4, lista2.getFirst().getItem() );
		assertEquals(5, lista2.getFirst().getItem() );
		assertEquals(7, lista2.getFirst().getItem() );

		
		
		
		setupEscenarioAsc();
		
		assertEquals(100, lista1.getSize());
		
		for (int i = 0; i < 100; i++)
		{
			assertEquals(i, lista1.getFirst().getItem() );
		}
		
		
		
		
		setupEscenarioDes();
		
		assertEquals(100, lista1.getSize());
		
		for (int i = 100; i > 0; i--)
		{
			assertEquals(i, lista1.getFirst().getItem() );
		}

	}


	@Test
	void testMerge() 
	{
		setupEscenarioAleatorio();
		
		
		assertEquals(100, lista2.getSize());

		assertEquals(-5, lista2.getFirst().getItem() );
		assertEquals(-4, lista2.getFirst().getItem() );
		assertEquals(-3, lista2.getFirst().getItem() );
		assertEquals(-2, lista2.getFirst().getItem() );
		assertEquals(-1, lista2.getFirst().getItem() );
		
		for (int i = 0; i < 90; i++)
		{
			lista2.getFirst();
		}
		
		assertEquals(2, lista2.getFirst().getItem() );
		assertEquals(3, lista2.getFirst().getItem() );
		assertEquals(4, lista2.getFirst().getItem() );
		assertEquals(5, lista2.getFirst().getItem() );
		assertEquals(7, lista2.getFirst().getItem() );

		
		
		
		setupEscenarioAsc();
		
		assertEquals(100, lista1.getSize());
		
		for (int i = 0; i < 100; i++)
		{
			assertEquals(i, lista1.getFirst().getItem() );
		}
		
		
		
		
		setupEscenarioDes();
		
		assertEquals(100, lista1.getSize());
		
		for (int i = 100; i > 0; i--)
		{
			assertEquals(i, lista1.getFirst().getItem() );
		}

	}


}
