package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo;

/**
 * Clase que contiene el esquema de los datos de los programas.
 * @author WALONSO
 *
 */
public class ModelViewArchivoIntervaloPrediccion {

	/**
	 * N�mero del programa.
	 */
	private int numeroPrograma;
	
	/**
	 * Tama�o del proxy estimado.
	 */
	private int estimatedProxySize;
	
	/**
	 * Paneaci�n de lo agregado y modificado en tama�o.
	 */
	private int planAddedAndModifiedSize;
	
	/**
	 * Actual agregado y tama�o modificado.
	 */
	private int actulAddedAndModifiedSize;
	
	/**
	 * Actual cantidad de horas de desarrollo.
	 */
	private double actualDevelopmentHours;
	
	/**
	 * Da el n�mero del programa.
	 * @return el n�mero del programa.
	 */
	public int darNumeroPrograma() {
		return numeroPrograma;
	}
	
	/**
	 * asigna el valor del n�mero del programa.
	 * @param numeroPrograma : el numero del programa a asignar. 
	 */
	public void asignarNumeroPrograma(int numeroPrograma) {
		this.numeroPrograma = numeroPrograma;
	}
	
	/**
	 * Da el valor del proxy.
	 * @return el valor del proxy.
	 */
	public int darEstimatedProxySize() {
		return estimatedProxySize;
	}
	
	/**
	 * Asigna el valor esimado del proxy.
	 * @param estimatedProxySize : el valor del proxy a asignar.
	 */
	public void asignarEstimatedProxySize(int estimatedProxySize) {
		this.estimatedProxySize = estimatedProxySize;
	}
	
	/**
	 * Da el tama�o planeado y modificado de lo planeado.
	 * @return el tama�o planeado y modificado de lo planeado.
	 */
	public int darPlanAddedAndModifiedSize() {
		return planAddedAndModifiedSize;
	}
	
	/**
	 * Asigna el tama�o planeado y modificado de lo planeado.
	 * @param planAddedAndModifiedSize : el tama�o planeado y modificado de lo planeado a asignar.
	 */
	public void asignarPlanAddedAndModifiedSize(int planAddedAndModifiedSize) {
		this.planAddedAndModifiedSize = planAddedAndModifiedSize;
	}
	
	/**
	 * Da el tama�o agregado y modificado de lo actual.
	 * @return el tama�o agregado y modificado de lo actual.
	 */
	public int darActualAddedAndModifiedSize() {
		return actulAddedAndModifiedSize;
	}
	
	/**
	 * Asigna el tama�o agregado y modificado de lo actual.
	 * @param actulAddedAndModifiedSize : el tama�o agregado y modificado de lo actual a asignar.
	 */
	public void asignarActualAddedAndModifiedSize(int actulAddedAndModifiedSize) {
		this.actulAddedAndModifiedSize = actulAddedAndModifiedSize;
	}
	
	/**
	 * Da el tiempo actual de desarrollo.
	 * @return el tiempo actual de desarrollo.
	 */
	public double darActualDevelopmentHours() {
		return actualDevelopmentHours;
	}
	
	/**
	 * Asigna el tiempo actual de desarrollo.
	 * @param actualDevelopmentHours : el tiempo actual de desarrollo a asignar.
	 */
	public void asignarActualDevelopmentHours(double actualDevelopmentHours) {
		this.actualDevelopmentHours = actualDevelopmentHours;
	}	
}
