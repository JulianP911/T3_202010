package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Total de comparendos en el archivo, Primer Comparendo y Ultimo Comparendo");
			System.out.println("2. Numero de comparendos en el arreglo Comparable<Comparendo>");
			System.out.println("3. (ShellSort) El tiempo en milisegundos que tomó el algoritmo realizando el ordenamiento, los 10 primeros comparendos y los 10 últimos comparendos resultado del ordenamiento.");
			System.out.println("4. Cerrar la ejcucion del programa");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.println(modelo);
		}
}
