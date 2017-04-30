package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo;

/**
 * Modelo que intercambiara el intervalo de prediccion.
 * @author WALONSO
 *
 */
public class ModelViewIntervaloPrediccion {

	/**
	 * el valor de correlacion (R (x,y))
	 */
	private double rSubXY;
	
	/**
	 * El valor del correlarion de R al cuadrado.
	 */
	private double rAlCuadrado;
	
	/**
	 * El valor de la significancia.
	 */
	private double significancia;
	
	/**
	 * El valor de B sub 0.
	 */
	private double bSubCero;
	
	/**
	 * El valor de B sub 1.
	 */
	private double bSubUno;
	
	/**
	 * El valor de y sub k.
	 */
	private double ySubK;
	
	/**
	 * El valor del rango.
	 */
	private double rango;
	
	/**
	 * Indica que no es posible calcular el valor.
	 */
	private boolean noPosibleCalcular;
	
	/**
	 * Ctor del modelo, iniciando noPosibleCalcular en false.
	 */
	public ModelViewIntervaloPrediccion() {
		this.noPosibleCalcular = false;
	}
	
	/**
	 * Da el valor de correlacion (R (x,y))
	 * @return el valor de correlacion (R (x,y))
	 */
	public double darRSubXY() {
		return rSubXY;
	}
	
	/**
	 * asigna el valor de  correlacion (R (x,y))
	 * @param rSubXY : valor de correlacion (R (x,y))
	 */
	public void asignarRSubXY(double rSubXY) {
		this.rSubXY = rSubXY;
	}
	
	/**
	 * Da el valor de correlacion (R elevado al cuadrado)
	 * @return el valor de correlacion (R elevado al cuadrado)
	 */
	public double darRalCuadrado() {
		return rAlCuadrado;
	}
	
	/**
	 * asigna el valor de  correlacion (R elevado al cuadrado)
	 * @param rAlCuadrado : valor de correlacion (R elevado al cuadrado)
	 */
	public void asignarRalCuadrado(double rAlCuadrado) {
		this.rAlCuadrado = rAlCuadrado; 
	}
	
	/**
	 * Da el valor de significancia
	 * @return el valor de significancia
	 */
	public double darSignificancia() {
		return significancia;
	}
	
	/**
	 * asigna el valor de  significancia
	 * @param significancia : valor de significancia
	 */
	public void asinarSignificancia(double significancia) {
		this.significancia = significancia;
	}
	
	/**
	 * Da el valor de B sub 0
	 * @return el valor de B sub 0
	 */
	public double darBSubCero() {
		return bSubCero;
	}
	
	/**
	 * asigna el valor de  B sub 0
	 * @param bSubCero : valor de B sub 0
	 */
	public void asignarBSubCero(double bSubCero) {
		this.bSubCero = bSubCero;
	}
	
	/**
	 * Da el valor de B sub 1
	 * @return el valor de B sub 1
	 */
	public double darBSubUno() {
		return bSubUno;
	}
	
	/**
	 * asigna el valor de  B sub 1
	 * @param bSubUno : valor de B sub 1
	 */
	public void asignarBSubUno(double bSubUno) {
		this.bSubUno = bSubUno;
	}
	
	/**
	 * Da el valor de Y sub k
	 * @return el valor de Y sub k
	 */
	public double darYSubK() {
		return ySubK;
	}
	
	/**
	 * asigna el valor de Y sub k
	 * @param ySubK : valor de Y sub k
	 */
	public void asignarYSubK(double ySubK) {
		this.ySubK = ySubK; 
	}
	
	/**
	 * Da el valor del rango
	 * @return el valor del rango
	 */
	public double darRango() {
		return rango;
	}
	
	/**
	 * signa el valor del rango
	 * @param rango : valor del rango
	 */
	public void asignarRango(double rango) {
		this.rango = rango;
	}
	
	/**
	 * Da el valor del UPI, sumando el rango con Y sub K 
	 * @return el valor de UPI
	 */
	public double darUpi() {
		return this.rango + this.ySubK;
	}
	
	/**
	 * Da el valor del UPI, restando el rango con Y sub K 
	 * @return el valor de LPI
	 */
	public double darLpi() {
		return Math.abs(this.rango - this.ySubK);
	}
	
	/**
	 * Indica si es posible calcular el valor. 
	 * @return Si es o no posible dar valores.
	 */
	public boolean darNoPosibleCalcular() {
		return this.noPosibleCalcular;
	}
	
	/**
	 * Asigna el valor de posibleNoCalcular
	 * @param noPosibleCalcular : contiene el valor false o true indicando si es posible calcular
	 * los valores según regla. 
	 */
	public void asignarNoPosibleCalcular(boolean noPosibleCalcular) {
		this.noPosibleCalcular = noPosibleCalcular;
	}
}
