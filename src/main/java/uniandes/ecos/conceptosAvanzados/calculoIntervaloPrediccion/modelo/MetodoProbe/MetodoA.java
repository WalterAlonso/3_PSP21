package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe;

import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewArchivoIntervaloPrediccion;

/**
 * Maneja el metodo A del metodo Probe
 * @author WALONSO
 *
 */
public class MetodoA extends MetodoProbe implements IMetodoProbe {
	
	/**
	 * El tipo de estimación sea LOC o Tiempo.
	 */
	private TipoEstimacion tipoEstimacion;
	
	/**
	 * Constructor del metodoA de Probe
	 * Precondicion: parejaDato llega con minimo una pareja
	 * @param archivoIntervaloPrediccion: contiene el conjunto de datos
	 * @param tipoEstimacion: indica ual es el tipo de estimacion a calcular
	 * @param estimadoProxy: el tamanio estimado del proxy
	 */
	public MetodoA(ArrayList<ModelViewArchivoIntervaloPrediccion> archivoIntervaloPrediccion, TipoEstimacion tipoEstimacion, int estimadoProxy) {
		this.estimadoProxyXk = estimadoProxy;
		this.listaTamanioOPlanEstimado = new ArrayList<Double>();
		this.listaTamanioOTiempoActual = new ArrayList<Double>();
		this.tipoEstimacion = tipoEstimacion;
		
		transformarEntradasMetodo(archivoIntervaloPrediccion);
	}
	
	/**
	 * retorna el nombre del metodo y el tipo que se esta calculando
	 * @return el nombre del metodo y el tipo que se esta calculando
	 */
	public String toString() {
		return "Metodo A , tipo " + tipoEstimacion.toString();
	}
	
	/**
	 * Retorna la estimacion teniendo en cuenta el tipo de estimacion
	 * @return el valor de la estimacion
	 */
	public double darEstimacion() throws Exception {		
		if (tipoEstimacion == TipoEstimacion.EstimacionLOC) {
			return darTamanioEstimado();
		}
		return darTiempoEstimado();
	}	
	
	/**
	 * Transforma el conjunto de datos en ParejaDato a listas indepedientes.
	 * @param archivoIntervaloPrediccion: el conjunto de datos cargado por el usuario.
	 */
	protected void transformarEntradasMetodo(ArrayList<ModelViewArchivoIntervaloPrediccion> archivoIntervaloPrediccion) {
		
		if (archivoIntervaloPrediccion != null) {			
			if (this.tipoEstimacion == TipoEstimacion.EstimacionLOC) {
				llenarEstimacionLoc(archivoIntervaloPrediccion);
			}
			
			if (this.tipoEstimacion == TipoEstimacion.EstimacionTiempoDesarrollo) {
				llenarEstimacionTiempo(archivoIntervaloPrediccion);
			}			
		}		
	}
	
	/**
	 * Asigna a las listas los valores para calcular el tamaño aproximado, según la información de los programas.
	 * @param archivoIntervaloPrediccion : la lista de los programas.
	 */
	private void llenarEstimacionLoc(ArrayList<ModelViewArchivoIntervaloPrediccion> archivoIntervaloPrediccion) {
		for (int indice = 0; indice < archivoIntervaloPrediccion.size(); indice ++) {
			double datoProxy = archivoIntervaloPrediccion.get(indice).darEstimatedProxySize();
			double datoActual = archivoIntervaloPrediccion.get(indice).darActualAddedAndModifiedSize();
			this.listaTamanioOPlanEstimado.add(datoProxy);
			this.listaTamanioOTiempoActual.add(datoActual);
		}
	}
	
	/**
	 * Asigna a las listas los valores para calcular el tiempo aproximado, según la información de los programas.
	 * @param archivoIntervaloPrediccion : la lista de los programas.
	 */
	private void llenarEstimacionTiempo(ArrayList<ModelViewArchivoIntervaloPrediccion> archivoIntervaloPrediccion) {
		for (int indice = 0; indice < archivoIntervaloPrediccion.size(); indice ++) {
			double datoProxy = archivoIntervaloPrediccion.get(indice).darEstimatedProxySize();
			double datoActual = archivoIntervaloPrediccion.get(indice).darActualDevelopmentHours();
			this.listaTamanioOPlanEstimado.add(datoProxy);
			this.listaTamanioOTiempoActual.add(datoActual);
		}
	}	
}
