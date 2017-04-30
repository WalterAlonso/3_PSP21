package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe;

import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.utilidades.UtilidadCalculo;

/**
 * Clase que engloba el comportamiento y propiedades comunes en un metodo Probe A y B
 * @author WALONSO
 *
 */
public class MetodoProbe {
	
	/**
	 * Lista del tamaño o plan estimado.
	 */
	protected ArrayList<Double> listaTamanioOPlanEstimado;
	
	/**
	 * Lista del tamaño o tiempo actual.
	 */
	protected ArrayList<Double> listaTamanioOTiempoActual;
	
	/**
	 * Estimado proxy Xk.
	 */
	protected int estimadoProxyXk;
		
	/**
	 * Ctor MetodoProbe
	 */
	public MetodoProbe() {
		
	}
	
	/**
	 * Calcula el parametro de regresion B0
	 * @return el parametro de regresion B0
	 * @throws Exception al calcular B1 se puede encontrar division por 0, se propaga excepcion
	 */
	public double darParametroRegresionB0() throws Exception {
		double promedioTamanioOTiempoActual = UtilidadCalculo.darPromedio(listaTamanioOTiempoActual);
		double promedioTamanioOPlanEstimado = UtilidadCalculo.darPromedio(listaTamanioOPlanEstimado);
		double b1 = darParametroRegresionB1();
		return promedioTamanioOTiempoActual - (b1*promedioTamanioOPlanEstimado);
	}
	
	/**
	 * Calcula el parametro de regresion B1
	 * @return el parametro de regresion B1
	 * @throws Exception : cuando el valor del dividendo sea 0
	 */
	public double darParametroRegresionB1() throws Exception {
		double sumatoriaMultXY = UtilidadCalculo.darSumatoriaFactores
				(listaTamanioOPlanEstimado, listaTamanioOTiempoActual);
		double promEstimadoX = UtilidadCalculo.darPromedio(listaTamanioOPlanEstimado);
		double promActualY = UtilidadCalculo.darPromedio(listaTamanioOTiempoActual);
		double divisor =   sumatoriaMultXY - 
				(darCantidadEnLista()*promEstimadoX*promActualY);
		double sumEstimadoXCuadrado = UtilidadCalculo.darSumatoriaCuadrada(listaTamanioOPlanEstimado);
		double promEstimadoXCuadrado = Math.pow(promEstimadoX, 2);
		double dividendo = sumEstimadoXCuadrado - (darCantidadEnLista()*promEstimadoXCuadrado);
		
		if (dividendo == 0) {
			throw new Exception("darParametroReresionB1() - Dividendo en 0"); 
		}
		
		return divisor / dividendo;
	}
	
	/**
	 * Calcula el coeficiente de correlacion R
	 * @return el coeficiente de correlacion R
	 * @throws Exception propaga posible dision por 0
	 */
	public double darCoeficienteCorrelacionR() throws Exception {
		int cantidadN = darCantidadEnLista();
		double sumaMultiPlicacionXY = 
				UtilidadCalculo.darSumatoriaFactores(listaTamanioOPlanEstimado, listaTamanioOTiempoActual);
		double sumaEstimadoX = UtilidadCalculo.darSumatoria(listaTamanioOPlanEstimado);
		double sumaActualY = UtilidadCalculo.darSumatoria(listaTamanioOTiempoActual);
		double divisor = (cantidadN*sumaMultiPlicacionXY) - (sumaEstimadoX*sumaActualY);
		
		double sumaEstimadoXCuadrado = UtilidadCalculo.darSumatoriaCuadrada(listaTamanioOPlanEstimado);
		double sumaActualYCuadrado = UtilidadCalculo.darSumatoriaCuadrada(listaTamanioOTiempoActual);
		double primerFactor = (cantidadN * sumaEstimadoXCuadrado) -  Math.pow(sumaEstimadoX, 2);
		double segudoFactor = (cantidadN * sumaActualYCuadrado) - Math.pow(sumaActualY, 2);
		double dividendo = Math.sqrt(primerFactor*segudoFactor);
		
		if(dividendo == 0) {
			throw new Exception("darCoeficienteCorrelacionR() - Dividendo en 0"); 
		}
		
		return divisor / dividendo;
	}
	
	/**
	 * devuelve la estimacion mejorada YK
	 * @return la estimacion YK
	 * @throws Exception algunos calculos como division por cero pueden ser encontrados
	 */
	protected double darEstimacionMejoradaYk() throws Exception {
		double b0 = darParametroRegresionB0();
		double b1 = darParametroRegresionB1();		
		return b0 + (b1*estimadoProxyXk);
	}
	
	/**
	 * Da el tamanio estimado
	 * @return el tamanio estimado segun el metodo
	 * @throws Exception algunos calculos como division por cero pueden ser encontrados
	 */
	protected double darTamanioEstimado() throws Exception {
		return darEstimacionMejoradaYk();
	}
	
	/**
	 * da el tiempo estimado
	 * @return el tiempo estimado
	 * @throws Exception algunos calculos como division por cero pueden ser encontrados
	 */
	protected double darTiempoEstimado() throws Exception {
		return darEstimacionMejoradaYk();
	}
	
	private int darCantidadEnLista() {
		return listaTamanioOPlanEstimado.size();
	}

	/**
	 * da el numero del estimado proxy con el que se esta calculando el metodo.
	 * @return el numero del estimado proxy con el que se esta calculando el metodo.
	 */
	public int darEstimadoProxy() {
		return estimadoProxyXk;
	}
	
	/**
	 * Da la lista del acumulado de tamaño o plan estimado.
	 * @return la lista del acumulado de tamaño o plan estimado.
	 */
	public ArrayList<Double> darListaTamanioOPlanEstimado() {
		return listaTamanioOPlanEstimado;
	}

	/**
	 * Da la lista del tamaño o tiempo actual.
	 * @return la lista del tamaño o tiempo actual.
	 */
	public ArrayList<Double> darListaTamanioOTiempoActual() {
		return listaTamanioOTiempoActual;
	}
}
