package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ArchivoIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewArchivoIntervaloPrediccion;

/**
 * Valida el archivo Intervalo Prediccion Test
 * @author WALONSO
 *
 */
public class ArchivoIntervaloPrediccionTest extends TestCase {
	
	/**
	 * Clase ArchivoEstimar testear
	 */
	private ArchivoIntervaloPrediccion archivoProcesar;
	
	/**
	 * Constante donde estan los archivos a testear
	 */
	public static final String rutaArchivo = "./ArchivoProcesarTest/TestArchivoIntervaloPrediccion/";

	/**
     * Este metodo se encarga de verificar que se cargue bien cuando es clase
     * 
     */
    public void testCargarArchivo() {
    	try {
    		String archivo = rutaArchivo + "ArchivoCargaIntervaloPrediccion.txt";
    		archivoProcesar = new ArchivoIntervaloPrediccion(archivo);
    		archivoProcesar.procesarArchivo();
    		ArrayList<ModelViewArchivoIntervaloPrediccion> datos = archivoProcesar.darDatos();
    		
    		assertEquals("Debe ser 1", 1, datos.get(0).darNumeroPrograma());
    		assertEquals("Debe ser 130", 130, datos.get(0).darEstimatedProxySize());
    		assertEquals("Debe ser 163", 163, datos.get(0).darPlanAddedAndModifiedSize());
    		assertEquals("Debe ser 186", 186, datos.get(0).darActualAddedAndModifiedSize());
    		assertEquals("Debe ser 15.0", 15.0, datos.get(0).darActualDevelopmentHours());
    		
    		assertEquals("Debe ser 10", 10, datos.get(9).darNumeroPrograma());
    		assertEquals("Debe ser 961", 961, datos.get(9).darEstimatedProxySize());
    		assertEquals("Debe ser 1130", 1130, datos.get(9).darPlanAddedAndModifiedSize());
    		assertEquals("Debe ser 1601", 1601, datos.get(9).darActualAddedAndModifiedSize());
    		assertEquals("Debe ser 138.2", 138.2, datos.get(9).darActualDevelopmentHours());    		    		
    	}
    	catch(Exception ex) { 		
    		fail("Excepcion: " + ex.getMessage());
    	}
    }
    
    /**
     * Se valida que no tenga caracteres
     */
    public void testValidarSoloReales() {
    	try {
    		String archivo = rutaArchivo + "ArchivoConCaracteres.txt";
    		archivoProcesar = new ArchivoIntervaloPrediccion(archivo);
    		archivoProcesar.procesarArchivo();
    		archivoProcesar.darDatos();
    		fail("Debio fallar: Hay un valor que no es numero real.");
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Hay un valor que no es numero real.", "Hay un valor que no es numero real.", ex.getMessage());
    	}
    }
    
    /**
     * Se valida que no tenga valores en 0
     */
    public void testValidarValoresMayoresACero() {
    	try {
    		String archivo = rutaArchivo + "ArchivoConDatoIgualCero.txt";
    		archivoProcesar = new ArchivoIntervaloPrediccion(archivo);
    		archivoProcesar.procesarArchivo();
    		archivoProcesar.darDatos();
    		fail("Debio fallar: Hay valores menores o iguales a 0, los cuales deben ser mayores a 0, son el proxy y el número del programa.");
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Hay valores menores o iguales a 0, los cuales deben ser mayores a 0, son el proxy y el número del programa.",
    				"Hay valores menores o iguales a 0, los cuales deben ser mayores a 0, son el proxy y el número del programa.", ex.getMessage());
    	}
    }
    
    
}



