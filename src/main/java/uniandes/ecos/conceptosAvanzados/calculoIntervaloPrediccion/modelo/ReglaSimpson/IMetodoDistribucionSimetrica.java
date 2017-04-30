package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson;

/**
 * Interface que representa los metodos de distribución simetrica.
 * @author WALONSO
 *
 */
public interface IMetodoDistribucionSimetrica {
	
	/**
	 * Realiza el calculo propio del metodo de distibución simetrica.
	 * @param segmento : el segmento que se esta validando
	 * @return el cálculo del segmento que se esta procesando.
	 * @throws Exception en el calculo de la distribucion puede dar 0
	 */
	public double darCalculo(double segmento) throws Exception;
	
	/**
	 * Realiza el reinicio de los valores los cuales eben cambiar por cada operacion de busqueda.	 
	 */
	public void iniciarValores();
}
