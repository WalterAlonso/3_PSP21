package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson;

import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.utilidades.UtilidadCalculo;

/**
 * Representa a la funcion simetrica de distribucionT, el cual tiene sus operaciones
 * propias de calculo.
 * @author WALONSO
 *
 */
public class DistribucionT implements IMetodoDistribucionSimetrica {
	
	/**
	 * el valor de dof
	 */
	private int dof;
	
	/**
	 * el valor gamma calculado
	 */
	private Double valorGamma;
	
	/**
	 * El valor de potencia calculado.
	 */
	private Double	potencia;
	
	/**
	 * Instancia �nica de est� clase.
	 */
	private static DistribucionT INSTANCE = null;
			 
	/**
	 * Ctor de la clase.
	 */
	private DistribucionT(){		
	}

	/**
	 * cr�a la instancia �nica de la clase.
	 */
	private synchronized static void createInstance() {
	    if (INSTANCE == null) { 
	        INSTANCE = new DistribucionT();
	    }
	}
	
	/**
	 * Devuelve instancia �nica de DistribucionT
	 * @return la instancia de DistribucionT
	 */
	public static DistribucionT getInstance() {
	    if (INSTANCE == null) {
	    	createInstance();
	    }
	    return INSTANCE;
	}
	
	/**
	 * Asigna dof
	 * @param dof : el parametro dof para realizar los calculos.
	 */
	public void asignarDof(int dof) {
		this.dof = dof;
	}
	
	/**
	 * Reinicia los valores de la potencia y gamma, esto debe ser llamado cada vez
	 * que se pasa por un nuevo ranngo a analizar.
	 */
	public void iniciarValores() {
		this.potencia = null;
		this.valorGamma = null;
	}
	
	/**
	 * Da el calculo gamma
	 * @return el calculo gamma segun dof dado.
	 * @throws Exception al calcular dof puede dar valor 0
	 */
	private double darCalculoGamma() throws Exception {
		if(this.valorGamma == null) {		
			double numeradorGammaAProcesar = ((this.dof + 1)/2.0);
			double factorialGamma = 0;
			if(this.esValorEntero(numeradorGammaAProcesar)) {				
				factorialGamma = UtilidadCalculo.darFactorial(numeradorGammaAProcesar-1, 1);
			}
			else {
				factorialGamma = UtilidadCalculo.darFactorial(numeradorGammaAProcesar-1, 0.5);
				factorialGamma *= Math.sqrt(Math.PI); 
			}
			
			double valorFactorialDof = this.dof / 2.0;
			double factorialDof = 0;
			if (this.esValorEntero(valorFactorialDof)) {
				if (valorFactorialDof == 1) {
					throw new Exception("Denominador 0, no posible calclar valor"); 
				}
				factorialDof = UtilidadCalculo.darFactorial(valorFactorialDof-1, 1);
			}
			else {
				factorialDof = UtilidadCalculo.darFactorial(valorFactorialDof-1, 0.5);
				factorialDof *= Math.sqrt(Math.PI);
			}		
			
			double denominador = Math.pow((this.dof * Math.PI), (0.5));
			denominador = denominador * factorialDof;
			
			this.valorGamma = factorialGamma / denominador; 
		}
		return this.valorGamma;
	}
	
	/**
	 * Realiza los calculos de Distribucion T.
	 * @param segmento : el segmento que se esta calculando.
	 * @throws Exception en el calculo de la distribuci�n el denominador puede dar 0
	 */
	public double darCalculo(double segmento) throws Exception {
		
		double funcionGamma = this.darCalculoGamma();
				
		double potenciaRestaDof = darPotencia();
		double segundaParteFuncion = (1 + (Math.pow(segmento, 2)/this.dof));		
		segundaParteFuncion = Math.pow(segundaParteFuncion, potenciaRestaDof);
		
		return funcionGamma * segundaParteFuncion;
	}
	
	/**
	 * Indica si es valor entero.
	 * @param valor : valor a evaluar.
	 * @return true si es entero, false si no lo es.
	 */
	private boolean esValorEntero(double valor) {
		 if (valor % 1 == 0) {
			 return true;
		 }
		 return false;
	}
	
	/**
	 * da el valor de la potencia.
	 * @return el vaor de la potencia seg�n dof.
	 */
	private double darPotencia() {
		if (this.potencia == null) {
			this.potencia = -((this.dof + 1)/2.0); 
		}
		return this.potencia;
	}
	
}



