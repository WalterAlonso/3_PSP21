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
				ModelViewIntervaloPrediccion model = new ModelViewIntervaloPrediccion();				
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccion.txt";
				ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
				MetodoA metodoA = new MetodoA(datos, TipoEstimacion.EstimacionLOC, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
				model=fachada.darModeloIntervaloPrediccion();
				
				ModelViewIntervaloPrediccion datosEsperados = new ModelViewIntervaloPrediccion();
				datosEsperados.asignarNoPosibleCalcular(false);
				datosEsperados.asignarRSubXY(0.954496574);
				datosEsperados.asignarRSubXY(0.91106371);
/*
assertFalse( "Valor de NoPosibleCalcular debe ser false", model.darNoPosibleCalcular());
    		assertEquals( "Valor de r(x,y) debe ser 0.954496574", 0.954496574, model.darRSubXY(), 0.00001);
    		assertEquals( "Valor de r(2) debe ser 0.91106371", 0.91106371, model.darRalCuadrado(), 0.00001);
    		assertEquals( "Valor de significancia debe ser 0.000077517", 0.000077517, model.darSignificancia(), 0.00001);
    		assertEquals( "Valor de B0 debe ser -22.55253275", -22.55253275, model.darBSubCero(), 0.00001);
    		assertEquals( "Valor de B1 debe ser 1.727932426", 1.727932426, model.darBSubUno(), 0.00001);
			
			
    		assertEquals( "Valor de yk debe ser 644.4293838", 644.4293838, model.darYSubK(), 0.00001);
    		assertEquals( "Valor de Rango debe ser 230.0017197", 230.0017197, model.darRango(), 0.00001);
    		assertEquals( "Valor de UPI debe ser 874.4311035", 874.4311035, model.darUpi(), 0.00001);
    		assertEquals( "Valor de LPI debe ser 414.427664", 414.427664, model.darLpi(), 0.00001); 	
    		
				*/
				/*MetodoA metodoA2 = new MetodoA(datos, TipoEstimacion.EstimacionTiempoDesarrollo, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA2);
				model.add(fachada.darModeloIntervaloPrediccion());
				
				rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccionProgramaTresSeis.txt";
				datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
								
				MetodoA metodoA3 = new MetodoA(datos, TipoEstimacion.EstimacionLOC, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA3);
				model.add(fachada.darModeloIntervaloPrediccion());
				
				MetodoA metodoA4 = new MetodoA(datos, TipoEstimacion.EstimacionTiempoDesarrollo, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA4);
				model.add(fachada.darModeloIntervaloPrediccion());*/
				
				return fachada.mostrarCalculosWeb(1, datosEsperados);				
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());
	
		get("/test2", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				ModelViewIntervaloPrediccion model = new ModelViewIntervaloPrediccion();				
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccion.txt";
				ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
				
				MetodoA metodoA = new MetodoA(datos, TipoEstimacion.EstimacionLOC, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
				model = fachada.darModeloIntervaloPrediccion();
								
				ModelViewIntervaloPrediccion datosEsperados = new ModelViewIntervaloPrediccion();
				datosEsperados.asignarNoPosibleCalcular(false);
				datosEsperados.asignarRSubXY(0.954496574);
				datosEsperados.asignarRSubXY(0.91106371);
				
				return fachada.mostrarCalculosWeb(2, datosEsperados);				
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());
		
		/*get("/test3", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				ModelViewIntervaloPrediccion model = new ModelViewIntervaloPrediccion();				
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccion.txt";
				ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
				
				MetodoA metodoA = new MetodoA(datos, TipoEstimacion.EstimacionLOC, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
				model = fachada.darModeloIntervaloPrediccion();
				
				
				
				MetodoA metodoA2 = new MetodoA(datos, TipoEstimacion.EstimacionTiempoDesarrollo, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA2);
				model.add(fachada.darModeloIntervaloPrediccion());
				
				rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaIntervaloPrediccionProgramaTresSeis.txt";
				datos = fachada.cargarDatosInicialesIntervaloPrediccion(rutaArchivo);
								
				MetodoA metodoA3 = new MetodoA(datos, TipoEstimacion.EstimacionLOC, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA3);
				model.add(fachada.darModeloIntervaloPrediccion());
				
				MetodoA metodoA4 = new MetodoA(datos, TipoEstimacion.EstimacionTiempoDesarrollo, 386);  
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA4);
				model.add(fachada.darModeloIntervaloPrediccion());
				
				return fachada.mostrarCalculosWeb();				
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());
		*/
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
