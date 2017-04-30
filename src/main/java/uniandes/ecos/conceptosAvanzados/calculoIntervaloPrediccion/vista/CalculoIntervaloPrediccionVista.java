package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.vista;

import java.util.Scanner;

import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewIntervaloPrediccion;

/**
 * Vista que muestra el calculo de Intervalo de predicción.
 * @author WALONSO
 *
 */
public class CalculoIntervaloPrediccionVista extends Vista {
	
	/**
	 * Propiedad que contiene el modelo de intervalo de predicción
	 */
	private ModelViewIntervaloPrediccion modelViewIntervaloPrediccion;
	
	/**
	 * Ctor de la vista 
	 */
	public CalculoIntervaloPrediccionVista() {		
	}
	
	/**
	 * Asigna el metodo calculado
	 * @param modelViewIntervaloPrediccion: el modelo de intervalo de predicción.
	 */
	public void asignarModelo(ModelViewIntervaloPrediccion modelViewIntervaloPrediccion) {
		this.modelViewIntervaloPrediccion = modelViewIntervaloPrediccion;
	}
	
	/**
	 * Obtiene del usuario el metodo probe deseado
	 * @return el valor entero del tipo de metodo deseado:
	 * 1 es Metodo A
	 * 2 es Metodo B
	 */
	@SuppressWarnings("resource")
	public int obtenerMetodoCrear() {
		Scanner teclado = new Scanner (System.in);
		while(true) {				
			System.out.println("Escoja el metodo Probe deseado : ");
			System.out.println("	1. Método A.");
			System.out.println("	2. Método B.");
			System.out.println("	3. Salir.");
				
			String valor = teclado.next();
			valor = valor.trim();
			switch (valor) {
				case "1":
					return 1;
				case "2":
					return 2;
				case "3":
					salir();
				default:
					System.out.println("---- Opción no encontrada, vuelva a intentarlo.----\n");
					break;
			}
		}		
	}

	/**
	 * Obtiene del usuario el tipo de metodo probe a aplicar
	 * @return el valor entero del tipo de metodo deseado:
	 * 1 es Estimacion tiempo
	 * 2 es Estimacion LOC
	 */
	@SuppressWarnings("resource")
	public int obtenerPlanEstimacion() {
		Scanner teclado = new Scanner (System.in);
		while(true) {				
			System.out.println("Escoja lo que desea calcular : ");
			System.out.println("	1. Plan de tamaño a agregar y modificar.");
			System.out.println("	2. Tiempo estimado.");
			System.out.println("	3. Salir.");
			
			String valor = teclado.next();
			valor = valor.trim();
			switch (valor) {
				case "1":
					return 1;
				case "2":
					return 2;
				case "3":
					salir();
				default:
					System.out.println("---- Opción no encontrada, vuelva a intentarlo.----\n");
					break;
			}
		}		
	}
	
	/**
	 * Obtiene del usuario el proxy estimado
	 * @return el valor entero del proxy estimado
	 * 
	 */
	@SuppressWarnings("resource")
	public int obtenerProxyEstimado() {
		Scanner teclado = new Scanner (System.in);
		while(true) {	
			System.out.println("Ingrese el tamaño del proxy estimado: ");				
			String valor = teclado.next();
			
			if (isNumeric(valor)) { 
				return Integer.parseInt(valor);
			}
			
			System.out.println("---- Valor no es entero, vuelva a ingresarlo.----\n");
		}		
	}
	
	private boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public void MotrarValoresError() {
		String valueNa = "n/a"; 
		mostrarDatos("r (x,y)", valueNa);
		mostrarDatos("r a la 2", valueNa);
		mostrarDatos("significancia", "");
		mostrarDatos("B0", valueNa);
		mostrarDatos("B1", valueNa);
		mostrarDatos("Yk", valueNa);
		mostrarDatos("Rango", valueNa);
		mostrarDatos("UPI (70%)", valueNa);
		mostrarDatos("LPI (70%)", valueNa);		
	}
	
	/**
	 * Salir de la aplicacion
	 */
	public void salir() {
		System.exit(0);
	}
	
	/**
	 * Muestra los valores de regresion, coeficientes y estimados segun el metodo escogido
	 * @throws Exception si algun calculo de regresion o coeficiente genera exepciones.
	 */
	public void MostrarValores() throws Exception {
		if (modelViewIntervaloPrediccion.darNoPosibleCalcular())
		{
			MotrarValoresError();
		}
		else 
		{
			mostrarDatos("r (x,y)",  Double.toString(modelViewIntervaloPrediccion.darRSubXY()));
			mostrarDatos("r a la 2",  Double.toString(modelViewIntervaloPrediccion.darRalCuadrado()));
			mostrarDatos("significancia",  Double.toString(modelViewIntervaloPrediccion.darSignificancia()));
			mostrarDatos("B0",  Double.toString(modelViewIntervaloPrediccion.darBSubCero()));
			mostrarDatos("B1",  Double.toString(modelViewIntervaloPrediccion.darBSubUno()));
			mostrarDatos("Yk",  Double.toString(modelViewIntervaloPrediccion.darYSubK()));
			mostrarDatos("Rango",  Double.toString(modelViewIntervaloPrediccion.darRango()));
			mostrarDatos("UPI (70%)",  Double.toString(modelViewIntervaloPrediccion.darUpi()));
			mostrarDatos("LPI (70%)",  Double.toString(modelViewIntervaloPrediccion.darLpi()));
		}
	}
	
	/**
	 * Pregunta al usuario si desea continuar con otra estimacion
	 * @return valor entero indicando si desea continuar realizando etimaciones.
	 * 1. Si
	 * 2. No
	 */
	@SuppressWarnings("resource")
	public int continuarOtraEstimacion() {
		Scanner teclado = new Scanner (System.in);
		while(true) {
			System.out.println("");
			System.out.println("");
			System.out.println("Desea continuar otra estimacion: ");
			System.out.println("	1. Si.");
			System.out.println("	2. No.");
				
			String valor = teclado.next();
			valor = valor.trim();
			switch (valor) {
				case "1":
					return 1;
				case "2":
					salir();
				default:
					System.out.println("---- Opcion no encontrada, vuelva a intentarlo.----\n");
					break;
			}
		}		
	}
	
	/**
	 * Muestra los errores.
	 * @param error: el error a mostrar al usuario.
	 */
	public void  mostrarError(String error) {
		System.out.println("Error = " + error);
	}
}
