package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.controlador;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ArchivoIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewArchivoIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.MetodoA;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.TipoEstimacion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewIntervaloPrediccion;
/**
 * Realiza el calculo de intervalo de predicción web.
 * @author WALONSO
 *
 */
public class CalculoIntervaloPrediccionWeb {
	
	/**
	 * Recibe los parametros del usuario en ambiente web para ser procesados.
	 * @param args el cual son los argumentos que se reciben del programa.
	 */
	public static void main(String[] args) {
		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/ArchivoProcesar");
		staticFileLocation("/site");
		Fachada fachada = new Fachada();		
		//Request al home del sitio.
		get("/", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccion.txt";
				ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
				MetodoA metodoA = new MetodoA(datos, TipoEstimacion.EstimacionLOC, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
								
				ModelViewIntervaloPrediccion datosEsperados = new ModelViewIntervaloPrediccion();
				datosEsperados.asignarNoPosibleCalcular(false);
				datosEsperados.asignarRSubXY(0.954496574);
				datosEsperados.asignarRSubXY(0.91106371);
				datosEsperados.asinarSignificancia(0.000077517);
				datosEsperados.asignarBSubCero(-22.55253275);
				datosEsperados.asignarBSubUno(1.727932426);
				datosEsperados.asignarYSubK(644.4293838);
				datosEsperados.asignarRango(230.0017197);				
				
				return fachada.mostrarCalculosWeb(1, datosEsperados);				
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());
	
		get("/test2", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccion.txt";
				ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
				
				MetodoA metodoA = new MetodoA(datos, TipoEstimacion.EstimacionLOC, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
				
				ModelViewIntervaloPrediccion datosEsperados = new ModelViewIntervaloPrediccion();
				datosEsperados.asignarNoPosibleCalcular(false);
				datosEsperados.asignarRSubXY(0.933306898);
				datosEsperados.asignarRSubXY(0.871061766);
				datosEsperados.asinarSignificancia(0.0000798203);
				datosEsperados.asignarBSubCero(-4.038881575);
				datosEsperados.asignarBSubUno(0.16812665);
				datosEsperados.asignarYSubK(60.85800528);
				datosEsperados.asignarRango(27.55764748);
	    						
				return fachada.mostrarCalculosWeb(2, datosEsperados);				
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());
		
		get("/test3", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccionProgramaTresSeis.txt";
				ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
								
				MetodoA metodoA3 = new MetodoA(datos, TipoEstimacion.EstimacionLOC, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA3);
				
				ModelViewIntervaloPrediccion datosEsperados = new ModelViewIntervaloPrediccion();
				datosEsperados.asignarNoPosibleCalcular(true);
								
				return fachada.mostrarCalculosWeb(3, datosEsperados);				
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());		
		get("/test4", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccionProgramaTresSeis.txt";
				ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
								
				MetodoA metodoA4 = new MetodoA(datos, TipoEstimacion.EstimacionTiempoDesarrollo, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA4);
								
				ModelViewIntervaloPrediccion datosEsperados = new ModelViewIntervaloPrediccion();
				datosEsperados.asignarNoPosibleCalcular(true);
				
				return fachada.mostrarCalculosWeb(4, datosEsperados);				
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());		
		// Request para ver las pruebas de archivo
		get("/PruebasArchivo", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoExtensionErronea.dat";
				ArchivoIntervaloPrediccion archivoReglaSimpson = new ArchivoIntervaloPrediccion(rutaArchivo);
				archivoReglaSimpson.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ExtensionErronea", ex.getMessage());
				attributes.put("MensajeEsperadoExtensionErronea", "El archivo debe ser en formato txt");
			}

			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoVacio.txt";
				ArchivoIntervaloPrediccion archivoReglaSimpson = new ArchivoIntervaloPrediccion(rutaArchivo);
				archivoReglaSimpson.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ArchivoVacio", ex.getMessage());
				attributes.put("MensajeEsperadoArchivoVacio", "El archivo esta vacio");
			}

			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoNoExiste.txt";
				ArchivoIntervaloPrediccion archivoReglaSimpson = new ArchivoIntervaloPrediccion(rutaArchivo);
				archivoReglaSimpson.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ArchivoNoExiste", ex.getMessage());
				attributes.put("MensajeEsperadoArchivoNoExiste", "No hay archivo que cargar");
			}
			
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoSinEstructuraCorrecta.txt";
				ArchivoIntervaloPrediccion archivoReglaSimpson = new ArchivoIntervaloPrediccion(rutaArchivo);
				archivoReglaSimpson.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ArchivoEstructuraIncorrecta", ex.getMessage());
				attributes.put("MensajeEsperadoEstructuraIncorrecta", "Tiene cantidad de columnas inadecuadas.");
			}
			
			return new ModelAndView(attributes, "testArchivo.ftl");
		}, new FreeMarkerEngine());
	}
}
