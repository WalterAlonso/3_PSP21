package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ArchivoIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewArchivoIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.Rango;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.IMetodoProbe;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.DistribucionT;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.ModelViewReglaSimpson;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.ReglaSimpson;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.vista.CalculoIntervaloPrediccionVista;

/**
 * Utilizando el patrón fachada, se encargara de orquestar las clases desde la carga del archivo,
 * calcular la regla Simpson y mostrar los resultados, sean web o en consola. 
 * @author WALONSO
 *
 */
public class Fachada {
	
	/**
	 * La lista de registros con los programas.
	 */
	private ArrayList<ModelViewArchivoIntervaloPrediccion> datosIntervaloPrediccion;
	
	/**
	 * Los datos de regla Simpson
	 */
	private ModelViewReglaSimpson datoReglaSimpson;
	
	/**
	 * Metodo probe, el cual indica el metodo de estimacion de tiempo  tamaño. 
	 */
	private IMetodoProbe metodoProbe;
	
	/**
	 * El modelo de intervalo de predicción, el cual se mostrara en la vista.
	 */
	private ModelViewIntervaloPrediccion modeloIntervaloPrediccion; 
	
	/**
	 * Se encarga de cargar y procesar el archivo segun regla de intervalo de predicción.
	 * @param rutaArchivo : la ruta de ubicación del archivo.
	 * @return los datos que contiene el archivo.
	 * @throws Exception : Se válidan las reglas de datos del archivo.
	 */
	public ArrayList<ModelViewArchivoIntervaloPrediccion> cargarDatosInicialesIntervaloPrediccion(String rutaArchivo) throws Exception {
		ArchivoIntervaloPrediccion archivoIntervaloPrediccion = new ArchivoIntervaloPrediccion(rutaArchivo);
		archivoIntervaloPrediccion.procesarArchivo();
		datosIntervaloPrediccion = archivoIntervaloPrediccion.darDatos();
		return datosIntervaloPrediccion; 
	}
	
	/**
	 * Procesa la regla Simpson
	 * @param rangoFinal : el rango final con el cual se inicia el calculo, para calcular el rango 
	 * @param errorAceptable : el error aceptable
	 * @param numeroSegmentos : el número de segmentos a partir
	 * @param d : Da el número d inicial (para calcular el rango final)
	 * @param metodoProbe : el metodoProbe escogido por el usuario, como lo es metodo A o B
	 * @throws Exception al cargar archivo se valida que no este vacio, cantidad columnas adecuadas.
	 */
	public void procesarIntervaloPrediccion(double rangoFinal, double errorAceptable, int numeroSegmentos, double d, IMetodoProbe metodoProbe) throws Exception {
		modeloIntervaloPrediccion = new ModelViewIntervaloPrediccion();
		this.datoReglaSimpson = new ModelViewReglaSimpson();
		this.metodoProbe = metodoProbe;
		
		int cantidadRegistros = metodoProbe.darListaTamanioOPlanEstimado().size();		
		this.asignarValoresConfiguracionSimpson(errorAceptable, numeroSegmentos, d);
		this.datoReglaSimpson.asignarDof(cantidadRegistros - 2);		
		this.asignarValoresConfiguracionFuncionSimetrica(this.datoReglaSimpson.darDof());
		
		this.asignarValoresMetodoProbe();
		double valorX = darValorX();
		this.datoReglaSimpson.asignarRangoFinal(valorX);
		this.asignarValorSignificancia();
		if (!modeloIntervaloPrediccion.darNoPosibleCalcular()) {
			this.asignarRango(rangoFinal, errorAceptable, numeroSegmentos, cantidadRegistros);
		}
	}
	
	/**
	 * Asigna los valores de correlación del metodo Probe
	 * @throws Exception si se presenta algun error en los calculos de correlación.
	 */
	private void asignarValoresMetodoProbe() throws Exception {
		modeloIntervaloPrediccion.asignarRSubXY(metodoProbe.darCoeficienteCorrelacionR());
		modeloIntervaloPrediccion.asignarRalCuadrado(Math.pow(metodoProbe.darCoeficienteCorrelacionR(), 2));
		modeloIntervaloPrediccion.asignarBSubCero(metodoProbe.darParametroRegresionB0());
		modeloIntervaloPrediccion.asignarBSubUno(metodoProbe.darParametroRegresionB1());
		modeloIntervaloPrediccion.asignarYSubK(metodoProbe.darEstimacion());
	}
	
	/**
	 * Calcula el valor de X
	 * @return el valor de X, el rango final
	 */
	private double darValorX() {
		double rSubXY = modeloIntervaloPrediccion.darRSubXY();
		double denominador = 1 - Math.pow(rSubXY, 2);
		denominador = Math.sqrt(denominador);
		int cantidadRegistros = metodoProbe.darListaTamanioOPlanEstimado().size();
		double parteNumerador = Math.sqrt(cantidadRegistros - 2);
		double numerador = Math.abs(rSubXY) * parteNumerador;
		double x = numerador / denominador;
		return x;
	}
	
	/**
	 * Asigna el valor de significancia
	 */
	private void asignarValorSignificancia() {
		try {
			double valorP = darCalculoSimpson();
			double significancia = 1.0 - (2.0 * valorP);
			modeloIntervaloPrediccion.asinarSignificancia(significancia);
		} catch(Exception ex) {
			modeloIntervaloPrediccion.asignarNoPosibleCalcular(true);
		}
	}
	
	/**
	 * Da el calculo de Simpson.
	 * @return el valor del calculo Simpson.	 
	 * @throws Exception puede dar 0 en el calculo e distribución.
	 */
	private double darCalculoSimpson() throws Exception {
		ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();		
		this.datoReglaSimpson.asignarP(reglaSimpson.darValorCalculoReglaSimpson(this.datoReglaSimpson.darRangoFinal(), DistribucionT.getInstance()));
		return this.datoReglaSimpson.darP();
	}
	
	/**
	 * Asigna el valor del rango
	 * @param rangoFinal : el valor del rango final de inicio con el cual va a iniciar el proceso.
	 * @param errorAceptable : el valor de error aceptable.
	 * @param numeroSegmentos : el número de segmentos a partir en la distribución.
	 * @param d : el valor de d, para indicar que tan lejos esta el valor calculado.
	 * @throws Exception si hay error en los calculos del rango, regla Simpson.
	 */
	private void asignarRango(double rangoFinal, double errorAceptable, int numeroSegmentos, double d) throws Exception { //   (el modelProbe me da las lista de X y Y, llama a model: ModelViewReglaSimpson)
		Rango rango = new Rango();
		double valor = rango.darRango(metodoProbe, errorAceptable, numeroSegmentos, d, rangoFinal);
		modeloIntervaloPrediccion.asignarRango(valor);
	}
		
	/**
	 * Se asignan valores de iniciación para calcular Simpson.
	 * @param errorAceptable : indica el valor de error aceptable.
	 * @param numeroSegmentos : el número de segmentos a partir el rango y calcular su área.
	 * @param d : el valor d incremental o decreciente segun cálculo para el rango final.
	 */
	private void asignarValoresConfiguracionSimpson(double errorAceptable, int numeroSegmentos, double d) {
		ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
		reglaSimpson.asignarErrorAceptable(errorAceptable);
		reglaSimpson.asignarNumeroSegmentos(numeroSegmentos);
		reglaSimpson.asignarD(d);
	}
	
	/**
	 * Asigna los valores de configuración de la distribución t
	 * @param dof : asigna los degree of fredoom a la distribución t. 
	 */
	private void asignarValoresConfiguracionFuncionSimetrica(int dof) {
		DistribucionT distribucion = DistribucionT.getInstance();
		distribucion.asignarDof(dof);
	}
		
	/**
	 * Muestra los cálculos de la regla
	 * @param vista : la clase que se encarga de renderizar la informacion.
	 * @throws Exception al momento de calcular lo valores se puede presentar errores y excepciones, como incohrenecia en el tipo de dato.
	 */
	public void mostrarCalculos(CalculoIntervaloPrediccionVista vista) throws Exception {
		vista.asignarModelo(this.modeloIntervaloPrediccion);
		vista.MostrarValores();
		vista.continuarOtraEstimacion();
	}

	/**
	 * Muestra los cálculos web
	 * @return los datos y la vista de los datos que se van a desplegar.
	 */
	public ModelAndView mostrarCalculosWeb() {
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("datos", this.modeloIntervaloPrediccion);		
		return new ModelAndView(attributes, "intervaloPrediccion.ftl");
	}
	
	/**
	 * Retorna el modelo intervalo de predicción.
	 * @return el modelo intervalo de predicción.
	 */
	public ModelViewIntervaloPrediccion darModeloIntervaloPrediccion() {
		return this.modeloIntervaloPrediccion;
	}
}
