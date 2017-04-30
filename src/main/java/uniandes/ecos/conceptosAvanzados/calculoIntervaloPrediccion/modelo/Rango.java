package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo;

import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.IMetodoProbe;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.ModelViewReglaSimpson;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.ReglaSimpson;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.utilidades.UtilidadCalculo;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.DistribucionT;

/**
 * Clase que realiza los calculos de rango
 * @author WALONSO
 *
 */
public class Rango {

	/**
	 * Contiene el metodoProbe (datos de correlacion)
	 */
	private IMetodoProbe metodoProbe;
	
	/**
	 * Tiene el valor de P estandar para obtener el rango.
	 */
	private double p = 0.35;
	
	/**
	 * Da el valor del rango
	 * @param metodoProbe : contiene el metodo probe (valores de correlacion)
	 * @param errorAceptable : el valor de tolerancia de error aceptable para ReglaSimpson. 
	 * @param numeroSegmentos : el numero de segmentos para ReglaSimpson.
	 * @param d : el valor de d para ReglaSimpson, con el cual se calcula el rango final.
	 * @param rangoFinal: El valor del rango final con el cual inicia el calculo.
	 * @return el valor del rango calculado.
	 * @throws Exception por el calculo de los valores en distribucionT y reglaSimpson, controlando valores en 0.
	 */
	public double darRango(IMetodoProbe metodoProbe, double errorAceptable,int numeroSegmentos, 
			double d, double rangoFinal) throws Exception {
		
		this.metodoProbe = metodoProbe;
		int numeroRegistros = metodoProbe.darListaTamanioOPlanEstimado().size();
		DistribucionT.getInstance().iniciarValores();
		
		asignarValoresConfiguracionReglaSimpson(errorAceptable, numeroSegmentos, d);
		int dof = numeroRegistros - 2;		
		asignarValoresConfiguracionFuncionSimetrica(dof);
		ModelViewReglaSimpson modelReglaSimpson = new ModelViewReglaSimpson();
		modelReglaSimpson.asignarDof(dof);
		modelReglaSimpson.asignarP(p);
		modelReglaSimpson.asignarRangoFinal(rangoFinal);
		
		double rangoFinalP = darRangoFinalDistribucion(modelReglaSimpson);
		double desviacionEstandar = darDesviacionEstandar();
		double tercerFactor = darTercerFactor();
		
		double resultado = rangoFinalP * desviacionEstandar * tercerFactor;
		
		return resultado;
	}
	
	/**
	 * Calcula el rango final de la distribución.
	 * @param model : el modelo de la regla Simpson.
	 * @return el rango final de distribución.
	 * @throws Exception cuando al realizar los calculos de regla Simpson arroja error.
	 */
	private double darRangoFinalDistribucion(ModelViewReglaSimpson model) throws Exception {
		ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();		
		return reglaSimpson.darCalculoRangoFinal(model.darRangoFinal(), model.darP(), DistribucionT.getInstance());		
	}
	
	/**
	 * Calcula la desviacion estandar de los datos de los programas.
	 * (El segundo parametro de tres)
	 * @return el calculo de la desviacion estandar.
	 * @throws Exception si el calculo de metodoProbe arroja error en su calculo.
	 */
	private double darDesviacionEstandar() throws Exception {
		ArrayList<Double> listValoresX = metodoProbe.darListaTamanioOPlanEstimado();
		ArrayList<Double> listValoresY = metodoProbe.darListaTamanioOTiempoActual();
		double numeroRegistros = listValoresX.size();
		double sumatoria = 0;
		double b0 = metodoProbe.darParametroRegresionB0();
		double b1 = metodoProbe.darParametroRegresionB1();
		
		for(int indice = 0; indice < numeroRegistros; indice ++) {
			double valorY = listValoresY.get(indice);
			double valorX = listValoresX.get(indice);			
			double valorResta= valorY - b0 - (b1 * valorX);
			sumatoria += Math.pow(valorResta, 2);			
		}
		
		double primerFactor = 1.0 / (numeroRegistros - 2.0);
		double raiz = Math.sqrt(primerFactor * sumatoria);
		return raiz;
	}
	
	/**
	 * Calcula el tercer factor de tres para encontrar el rango.
	 * @return el tercer factor para calcular el rango.
	 */
	private double darTercerFactor() {
		ArrayList<Double> listValoresX = metodoProbe.darListaTamanioOPlanEstimado();
		double numeroRegistros = listValoresX.size();		
		double xPromedio = UtilidadCalculo.darPromedio(listValoresX);
		double xk = metodoProbe.darEstimadoProxy();
		
		double numerador = Math.pow(xk - xPromedio,2);
		double denominador = sumaXMenosPromedio();
		double unoDividioN = 1.0 / numeroRegistros;
		double resultado = 1.0 + unoDividioN + (numerador / denominador);
		double raiz = Math.sqrt(resultado);
		return raiz;
	}
	
	/**
	 * Asigna los valores de inicio a ReglaSimpson 
	 * @param errorAceptable : el valor de tolerancia de error aceptable para ReglaSimpson.  
	 * @param numeroSegmentos : el numero de segmentos para ReglaSimpson.
	 * @param d : el valor de d para ReglaSimpson, con el cual se calcula el rango final.
	 */
	private void asignarValoresConfiguracionReglaSimpson(double errorAceptable, int numeroSegmentos, double d) {
		ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
		reglaSimpson.asignarErrorAceptable(errorAceptable);
		reglaSimpson.asignarNumeroSegmentos(numeroSegmentos);
		reglaSimpson.asignarD(d);
	}
	
	/**
	 * Asigna los valores de inicio a DistribucionT  
	 * @param dof : el valor de degree of freedom.
	 */
	private void asignarValoresConfiguracionFuncionSimetrica(int dof) {
		DistribucionT distribucion = DistribucionT.getInstance();
		distribucion.asignarDof(dof);
	}
				
	/**
	 * Submetodo que devuelve calculo de promedio al tercer factor.
	 * @return valor de resta entre x y su promedio para calculos en el tercer factor.
	 */
	private double sumaXMenosPromedio() {
		ArrayList<Double> listValoresX = metodoProbe.darListaTamanioOPlanEstimado();
		double numeroRegistros = listValoresX.size();
		double xPromedio = UtilidadCalculo.darPromedio(listValoresX);
		double sumatoria = 0;
		
		for(int indice = 0; indice < numeroRegistros; indice ++) {			
			double valorX = listValoresX.get(indice);			
			double valorResta=  valorX - xPromedio;
			sumatoria += Math.pow(valorResta, 2);			
		}
		return sumatoria;
	}
}
