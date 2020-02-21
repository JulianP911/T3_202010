package controller;

import java.util.Scanner;

import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	/**
	 * Metodo run que corre el sistema
	 */
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin )
		{
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				int tamanio = modelo.darTamanoComparendos();
				view.printMessage("El total de comparendos es de: " + tamanio);
				view.printMessage("El primer comparendo es: " + modelo.darDatos(tamanio-1));
				view.printMessage("El ultimo comparendo es: " + modelo.darDatos(0) + "\n");
				break;

			case 2:
				int tamanioArreglo = modelo.copiarComparendosArreglo().length;
				view.printMessage("El total de comparendos en el arreglo Comparable<Comparendo>: " + tamanioArreglo);
				view.printMessage("\n");
				break;

			case 3:
				Comparable<Comparendo> copia_Comparendos1 [ ] = modelo.copiarComparendosArreglo();
				long startTime = System.currentTimeMillis();
				Modelo.shellSort(copia_Comparendos1);
				long endTime = System.currentTimeMillis();
				long duration = endTime - startTime;
				view.printMessage("Tiempo de ordenamiento: " + duration + " en milisegundos \n");
               
				view.printMessage("Los 10 primeros comparendos organizados por fecha_hora: \n" );
				Comparendo nuevo2 = null;
				for(int i = 0; i < 9; i++)
                {
					nuevo2 = (Comparendo) copia_Comparendos1[i];
                	view.printMessage(nuevo2.getObjective() + ", " + nuevo2.getFecha_hora() + ", " + nuevo2.getInfraccion() + ", " + nuevo2.getClase_vehi() + ", " + nuevo2.getTipo_servi() + ", " + nuevo2.getLocalidad());
                }
				
				view.printMessage("\n");
				view.printMessage("Los 10 ulimos comparendos organizados por fecha_hora: \n" );
				Comparendo nuevo3 = null;
				for(int i = copia_Comparendos1.length - 10 ; i < copia_Comparendos1.length; i++)
                {
					nuevo3 = (Comparendo) copia_Comparendos1[i];
                	view.printMessage(nuevo3.getObjective() + ", " + nuevo3.getFecha_hora() + ", " + nuevo3.getInfraccion() + ", " + nuevo3.getClase_vehi() + ", " + nuevo3.getTipo_servi() + ", " + nuevo3.getLocalidad());
                }
				view.printMessage("\n");
				break;
				
			case 4:
				Comparable<Comparendo> copia_Comparendos2 [ ] = modelo.copiarComparendosArreglo();
				long startTime1 = System.currentTimeMillis();
				Modelo.sort(copia_Comparendos2);
				Modelo.MergeSort(copia_Comparendos2, copia_Comparendos2, 0, copia_Comparendos2.length-1);
				long endTime1 = System.currentTimeMillis();
				long duration1 = endTime1 - startTime1;
				view.printMessage("Tiempo de ordenamiento: " + duration1 + " en milisegundos \n");
               
				view.printMessage("Los 10 primeros comparendos organizados por fecha_hora: \n" );
				Comparendo nuevo4 = null;
				for(int i = 0; i < 9; i++)
                {
					nuevo4 = (Comparendo) copia_Comparendos2[i];
                	view.printMessage(nuevo4.getObjective() + ", " + nuevo4.getFecha_hora() + ", " + nuevo4.getInfraccion() + ", " + nuevo4.getClase_vehi() + ", " + nuevo4.getTipo_servi() + ", " + nuevo4.getLocalidad());
                }
				
				view.printMessage("\n");
				view.printMessage("Los 10 ulimos comparendos organizados por fecha_hora: \n" );
				Comparendo nuevo5 = null;
				for(int i = copia_Comparendos2.length - 10 ; i < copia_Comparendos2.length; i++)
                {
					nuevo5 = (Comparendo) copia_Comparendos2[i];
                	view.printMessage(nuevo5.getObjective() + ", " + nuevo5.getFecha_hora() + ", " + nuevo5.getInfraccion() + ", " + nuevo5.getClase_vehi() + ", " + nuevo5.getTipo_servi() + ", " + nuevo5.getLocalidad());
                }
				view.printMessage("\n");
				break;
				
			case 5:
				Comparable<Comparendo> copia_Comparendos3 [ ] = modelo.copiarComparendosArreglo();
				long startTime2 = System.currentTimeMillis();
				Modelo.quickSort(copia_Comparendos3, 0, copia_Comparendos3.length - 1);
				long endTime2 = System.currentTimeMillis();
				long duration2 = endTime2 - startTime2;
				view.printMessage("Tiempo de ordenamiento: " + duration2 + " en milisegundos \n");
               
				view.printMessage("Los 10 primeros comparendos organizados por fecha_hora: \n" );
				Comparendo nuevo6 = null;
				for(int i = 0; i < 9; i++)
                {
					nuevo6 = (Comparendo) copia_Comparendos3[i];
                	view.printMessage(nuevo6.getObjective() + ", " + nuevo6.getFecha_hora() + ", " + nuevo6.getInfraccion() + ", " + nuevo6.getClase_vehi() + ", " + nuevo6.getTipo_servi() + ", " + nuevo6.getLocalidad());
                }
				
				view.printMessage("\n");
				view.printMessage("Los 10 ulimos comparendos organizados por fecha_hora: \n" );
				Comparendo nuevo7 = null;
				for(int i = copia_Comparendos3.length - 10 ; i < copia_Comparendos3.length; i++)
                {
					nuevo7 = (Comparendo) copia_Comparendos3[i];
                	view.printMessage(nuevo7.getObjective() + ", " + nuevo7.getFecha_hora() + ", " + nuevo7.getInfraccion() + ", " + nuevo7.getClase_vehi() + ", " + nuevo7.getTipo_servi() + ", " + nuevo7.getLocalidad());
                }
				view.printMessage("\n");
				break;

			case 6:
				view.printMessage("Hasta pronto"); 
				lector.close();
				fin = true;
				break;

			default: 
				view.printMessage("Opcion Invalida !!");
				break;
			}	
		}
	}	
}
