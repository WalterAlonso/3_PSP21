package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe;

import java.util.ArrayList;

/**
 * Interfaz que contiene el comportamiento para calcular metodo Probe
 * @author WALONSO
 *
 */
public interface IMetodoProbe {
	/**
	 * Calcula el parametro de regresion B0
	 * @return el parametro de regresion B0
	 * @throws Exception por calculos de division con 0
	 */
	double darParametroRegresionB0() throws Exception;
	
	/**
	 * Calcula el parametro de regresion B1
	 * @return el parametro de regresion B1
	 * @throws Exception por calculos de division con 0
	 */
	double darParametroRegresionB1() throws Exception;
	
	/**
	 * Calcula el coeficiente de correlacion R
	 * @return el coeficiente de correlacion R
	 * @throws Exception por calculos de division con 0
	 */
	double darCoeficienteCorrelacionR() throws Exception;
	
	/**
	 * da la estimacion segun el tipo (tiempo o LOC)
	 * @return la estimacion segun el tipo (tiempo o LOC)
	 * @throws Exception por calculos de division con 0
	 */
	double darEstimacion() throws Exception;
	
	/**
	 * Da el estimado proxy
	 * @return el estimado proxy
	 */
	int darEstimadoProxy();
	
	/**
	 * Da la lista del tamaño o plan estimado, dentro de las operaciones es x.
	 * @return lista del tamaño o plan estimado. 
	 */
	ArrayList<Double> darListaTamanioOPlanEstimado();
	
	/**
	 * Da la lista del tamaño o tiempo actual, dentro de las operaciones es y.
	 * @return lista del tamaño o tiempo actual.
	 */
	ArrayList<Double> darListaTamanioOTiempoActual();
	
	/**
	 * Indica el metodo y tipo que se esta calculando
	 * @return cadena de texto con metodo y tipo del metodo calculando
	 */
	String toString();
}
