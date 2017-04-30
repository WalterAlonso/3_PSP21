package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo;


import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.utilidades.Archivo;

/**
 * Representa el archivo de Intevalo de predicción.
 * @author WALONSO
 *
 */
public class ArchivoIntervaloPrediccion extends Archivo {
	
	/**
	 * cantidad de columnas permitidas.
	 */
	private static int cantidadColumnas = 5;
	
	/**
	 * Ctor que inicializa el archivo de intervalo de predicción con la ruta y nombre e indicando la cantidad de columnas permitidas.
	 * @param rutaArchivo: la ruta y nombre del archivo a cargar.
	 */
	public ArchivoIntervaloPrediccion(String rutaArchivo) {
		super(rutaArchivo, cantidadColumnas);
	}
	
	/**
	 * Retorna los datos del archivo
	 * @return Retorna los datos del archivo
	 * @throws Exception : si no tiene el tipo de dato entero, decimal y si nos es mayor a 0 el dof y rango final. 
	 */
	public ArrayList<ModelViewArchivoIntervaloPrediccion> darDatos() throws Exception {	
		ArrayList<ModelViewArchivoIntervaloPrediccion> modelo = new ArrayList<ModelViewArchivoIntervaloPrediccion>();		
		for (int indice = 0; indice < contenidoArchivo.size(); indice ++) {
			String linea = contenidoArchivo.get(indice);
			ModelViewArchivoIntervaloPrediccion model = darModeloSimpson(linea);
			modelo.add(model);
		}
		return modelo;
	}
	
	/**
	 * devuelve el modelo Intervalo predicción de la cadena dada.
	 * @param linea : la linea que se está analizando.
	 * @return el modelo con lo datos obtenidos.
	 * @throws Exception si no cumple con los tipos de datos esperados.
	 */
	private ModelViewArchivoIntervaloPrediccion darModeloSimpson(String linea) throws Exception {
		ModelViewArchivoIntervaloPrediccion model = null;
		String[] divisionValores = linea.split(",");
		int numeroPrograma =  darValorEntero(divisionValores[0].trim());
		int estimadoProxy =  darValorEntero(divisionValores[1].trim());
		int tamanioAgregadoModificadoPlaneado =  darValorEntero(divisionValores[2].trim());
		int tamanioAgregadoModificadoActual =  darValorEntero(divisionValores[3].trim());
		double tiempoHorasDesarrollo = darValorReal(divisionValores[4].trim());
				
		if (this.esMayorCero(numeroPrograma) && this.esMayorCero(estimadoProxy)){
			model = new ModelViewArchivoIntervaloPrediccion();
			model.asignarNumeroPrograma(numeroPrograma);
			model.asignarEstimatedProxySize(estimadoProxy);
			model.asignarPlanAddedAndModifiedSize(tamanioAgregadoModificadoPlaneado);
			model.asignarActualAddedAndModifiedSize(tamanioAgregadoModificadoActual);
			model.asignarActualDevelopmentHours(tiempoHorasDesarrollo);
		}
		return model;
	}
	
	/**
	 * Indica si el valor que tiene es numerico y entero.
	 * @param valor: el valor a ser validado.
	 * @return true si es valido, false si no lo es.
	 * @throws Exception si el valor no es numerico arroja excepción.
	 */
	public int darValorEntero(String valor) throws Exception {
		try {
			return Integer.parseInt(valor);
		}
		catch(Exception ex) {
			throw new Exception("Hay un valor que no es numero entero.");
		}
	}

	/**
	 * Indica si el valor que tiene es numerico y real.
	 * @param valor: el valor a ser validado.
	 * @return true si es valido, false si no lo es.
	 * @throws Exception si el valor no es numerico arroja excepción.
	 */
	public double darValorReal(String valor) throws Exception {
		try {
			return Double.parseDouble(valor);
		}
		catch(Exception ex) {
			throw new Exception("Hay un valor que no es numero real.");
		}
	}
	
	/**
	 * valida si el dato es mayor a cero.
	 * @param valor: el valor a ser validado.
	 * @return true si es mayor a cero, false si no lo es.
	 * @throws Exception se genéra si el valor no es mayor a cero.
	 */
	public boolean esMayorCero(double valor) throws Exception {
		if (valor <= 0) {
			throw new Exception("Hay valores menores o iguales a 0, los cuales deben ser mayores a 0, son el proxy y el número del programa.");
		}
		return true;
	}
}
