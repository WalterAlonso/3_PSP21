package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson;

/**
 * Representa cada segmento partido en la regla Simpson, el cual realiza operaciones
 * pertinentes a cada segmento.
 * @author WALONSO
 *
 */
public class SegmentoSimpson {
	
	/**
	 * El valor del segmento.
	 */
	private double valorSegmento;
	
	/**
	 * El ancho del segmento.
	 */
	private double anchoSegmento;
	
	/**
	 * El factor de multiplicaci�n.
	 */
	private int multiplicador;
	
	/**
	 * La funci�n de distribuci�n asociada, para calular el valor del segmento.
	 */
	private IMetodoDistribucionSimetrica metodoDistribucionSimetrica;
	
	/**
	 * el valor de la funci�n, segun la funci�n de distibuci�n.
	 */
	private double valorFuncion; 
	
	/**
	 * Ctor del segmento en regla Simpson
	 * @param valorSegmento : el valor del segmento.
	 * @param anchoSegmento : el ancho del segmento
	 * @param multiplicador : el factor de multiplicacion.
	 * @param metodoDistribucionSimetrica : el metodo de distribuci�n para el calculo.
	 */
	public SegmentoSimpson(double valorSegmento, double anchoSegmento, 
		int multiplicador, IMetodoDistribucionSimetrica metodoDistribucionSimetrica) {	
		this.valorSegmento = valorSegmento;
		this.anchoSegmento = anchoSegmento;
		this.multiplicador = multiplicador;
		this.metodoDistribucionSimetrica = metodoDistribucionSimetrica;
	}
	
	/**
	 * Da el c�lculo de la distribucion.
	 * @throws Exception puede dar 0 en el calculo e distribuci�n.
	 */
	public void calcular() throws Exception {
		double valorDistribucion = metodoDistribucionSimetrica.darCalculo(this.valorSegmento);
		this.valorFuncion = (this.anchoSegmento / 3.0) * this.multiplicador * valorDistribucion; 
	}
	
	/**
	 * Da el valor de la distribuci�n.
	 * @return el valor de la distribuci�n.
	 */
	public double darValorFuncion() {
		return this.valorFuncion;
	}
}
