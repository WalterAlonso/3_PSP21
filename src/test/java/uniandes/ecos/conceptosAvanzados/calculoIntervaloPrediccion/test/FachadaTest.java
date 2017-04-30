package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.controlador.Fachada;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewArchivoIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.MetodoA;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.TipoEstimacion;

/**
 * Clase para validar el resutado de fachada en el intervalo de predicción.
 * @author WALONSO
 *
 */
public class FachadaTest extends TestCase {
	
	/**
	 * Propiedad que contiene los datos de los programas
	 */
	private ArrayList<ModelViewArchivoIntervaloPrediccion> parejaDato;
	
	/**
	 * Propiedad que contiene los datos de los programas de 3 al 6
	 */
	private ArrayList<ModelViewArchivoIntervaloPrediccion> parejaDatoProgramaTresASeis;
	
	/**
	 * Constante donde estan los archivos a testear
	 */
	public static final String rutaArchivo = "./ArchivoProcesarTest/TestArchivoIntervaloPrediccion/";
	
	/**
     * Incializa el metodo A teniendo en cuenta el estimado y lo actual 
     */
    private void setupInicializarDatos( ) {
        
    	parejaDato = new ArrayList<ModelViewArchivoIntervaloPrediccion>();
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionUno = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionUno.asignarNumeroPrograma(1);
    	modelViewArchivoIntervaloPrediccionUno.asignarEstimatedProxySize(130);
    	modelViewArchivoIntervaloPrediccionUno.asignarPlanAddedAndModifiedSize(163);
    	modelViewArchivoIntervaloPrediccionUno.asignarActualAddedAndModifiedSize(186);
    	modelViewArchivoIntervaloPrediccionUno.asignarActualDevelopmentHours(15.0);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionDos = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionDos.asignarNumeroPrograma(2);
    	modelViewArchivoIntervaloPrediccionDos.asignarEstimatedProxySize(650);
    	modelViewArchivoIntervaloPrediccionDos.asignarPlanAddedAndModifiedSize(765);
    	modelViewArchivoIntervaloPrediccionDos.asignarActualAddedAndModifiedSize(699);
    	modelViewArchivoIntervaloPrediccionDos.asignarActualDevelopmentHours(69.9);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionTres = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionTres.asignarNumeroPrograma(3);
    	modelViewArchivoIntervaloPrediccionTres.asignarEstimatedProxySize(99);
    	modelViewArchivoIntervaloPrediccionTres.asignarPlanAddedAndModifiedSize(141);
    	modelViewArchivoIntervaloPrediccionTres.asignarActualAddedAndModifiedSize(132);
    	modelViewArchivoIntervaloPrediccionTres.asignarActualDevelopmentHours(6.5);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionCuatro = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionCuatro.asignarNumeroPrograma(4);
    	modelViewArchivoIntervaloPrediccionCuatro.asignarEstimatedProxySize(150);
    	modelViewArchivoIntervaloPrediccionCuatro.asignarPlanAddedAndModifiedSize(166);
    	modelViewArchivoIntervaloPrediccionCuatro.asignarActualAddedAndModifiedSize(272);
    	modelViewArchivoIntervaloPrediccionCuatro.asignarActualDevelopmentHours(22.4);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionCinco = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionCinco.asignarNumeroPrograma(5);
    	modelViewArchivoIntervaloPrediccionCinco.asignarEstimatedProxySize(128);
    	modelViewArchivoIntervaloPrediccionCinco.asignarPlanAddedAndModifiedSize(137);
    	modelViewArchivoIntervaloPrediccionCinco.asignarActualAddedAndModifiedSize(291);
    	modelViewArchivoIntervaloPrediccionCinco.asignarActualDevelopmentHours(28.4);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionSeis = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionSeis.asignarNumeroPrograma(6);
    	modelViewArchivoIntervaloPrediccionSeis.asignarEstimatedProxySize(302);
    	modelViewArchivoIntervaloPrediccionSeis.asignarPlanAddedAndModifiedSize(355);
    	modelViewArchivoIntervaloPrediccionSeis.asignarActualAddedAndModifiedSize(331);
    	modelViewArchivoIntervaloPrediccionSeis.asignarActualDevelopmentHours(65.9);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionSiete = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionSiete.asignarNumeroPrograma(7);
    	modelViewArchivoIntervaloPrediccionSiete.asignarEstimatedProxySize(95);
    	modelViewArchivoIntervaloPrediccionSiete.asignarPlanAddedAndModifiedSize(136);
    	modelViewArchivoIntervaloPrediccionSiete.asignarActualAddedAndModifiedSize(199);
    	modelViewArchivoIntervaloPrediccionSiete.asignarActualDevelopmentHours(19.4);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionOcho = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionOcho.asignarNumeroPrograma(8);
    	modelViewArchivoIntervaloPrediccionOcho.asignarEstimatedProxySize(945);
    	modelViewArchivoIntervaloPrediccionOcho.asignarPlanAddedAndModifiedSize(1206);
    	modelViewArchivoIntervaloPrediccionOcho.asignarActualAddedAndModifiedSize(1890);
    	modelViewArchivoIntervaloPrediccionOcho.asignarActualDevelopmentHours(198.7);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionNueve = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionNueve.asignarNumeroPrograma(9);
    	modelViewArchivoIntervaloPrediccionNueve.asignarEstimatedProxySize(368);
    	modelViewArchivoIntervaloPrediccionNueve.asignarPlanAddedAndModifiedSize(433);
    	modelViewArchivoIntervaloPrediccionNueve.asignarActualAddedAndModifiedSize(788);
    	modelViewArchivoIntervaloPrediccionNueve.asignarActualDevelopmentHours(38.8);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionDiez = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionDiez.asignarNumeroPrograma(10);
    	modelViewArchivoIntervaloPrediccionDiez.asignarEstimatedProxySize(961);
    	modelViewArchivoIntervaloPrediccionDiez.asignarPlanAddedAndModifiedSize(1130);
    	modelViewArchivoIntervaloPrediccionDiez.asignarActualAddedAndModifiedSize(1601);
    	modelViewArchivoIntervaloPrediccionDiez.asignarActualDevelopmentHours(138.2);
    		    	
    	parejaDato.add(modelViewArchivoIntervaloPrediccionUno);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionDos);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionTres);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionCuatro);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionCinco);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionSeis);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionSiete);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionOcho);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionNueve);
    	parejaDato.add(modelViewArchivoIntervaloPrediccionDiez);
    }
	
    /**
     * Incializa el metodo A teniendo en cuenta el estimado y lo actual 
     */
    private void setupInicializarDatosProgramaTresASeis( ) {
        
    	parejaDatoProgramaTresASeis = new ArrayList<ModelViewArchivoIntervaloPrediccion>();
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionTres = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionTres.asignarNumeroPrograma(3);
    	modelViewArchivoIntervaloPrediccionTres.asignarEstimatedProxySize(99);
    	modelViewArchivoIntervaloPrediccionTres.asignarPlanAddedAndModifiedSize(141);
    	modelViewArchivoIntervaloPrediccionTres.asignarActualAddedAndModifiedSize(132);
    	modelViewArchivoIntervaloPrediccionTres.asignarActualDevelopmentHours(6.5);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionCuatro = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionCuatro.asignarNumeroPrograma(4);
    	modelViewArchivoIntervaloPrediccionCuatro.asignarEstimatedProxySize(150);
    	modelViewArchivoIntervaloPrediccionCuatro.asignarPlanAddedAndModifiedSize(166);
    	modelViewArchivoIntervaloPrediccionCuatro.asignarActualAddedAndModifiedSize(272);
    	modelViewArchivoIntervaloPrediccionCuatro.asignarActualDevelopmentHours(22.4);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionCinco = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionCinco.asignarNumeroPrograma(5);
    	modelViewArchivoIntervaloPrediccionCinco.asignarEstimatedProxySize(128);
    	modelViewArchivoIntervaloPrediccionCinco.asignarPlanAddedAndModifiedSize(137);
    	modelViewArchivoIntervaloPrediccionCinco.asignarActualAddedAndModifiedSize(291);
    	modelViewArchivoIntervaloPrediccionCinco.asignarActualDevelopmentHours(28.4);
    	
    	ModelViewArchivoIntervaloPrediccion modelViewArchivoIntervaloPrediccionSeis = new ModelViewArchivoIntervaloPrediccion();
    	modelViewArchivoIntervaloPrediccionSeis.asignarNumeroPrograma(6);
    	modelViewArchivoIntervaloPrediccionSeis.asignarEstimatedProxySize(302);
    	modelViewArchivoIntervaloPrediccionSeis.asignarPlanAddedAndModifiedSize(355);
    	modelViewArchivoIntervaloPrediccionSeis.asignarActualAddedAndModifiedSize(331);
    	modelViewArchivoIntervaloPrediccionSeis.asignarActualDevelopmentHours(65.9);
    	
    	parejaDatoProgramaTresASeis.add(modelViewArchivoIntervaloPrediccionTres);
    	parejaDatoProgramaTresASeis.add(modelViewArchivoIntervaloPrediccionCuatro);
    	parejaDatoProgramaTresASeis.add(modelViewArchivoIntervaloPrediccionCinco);
    	parejaDatoProgramaTresASeis.add(modelViewArchivoIntervaloPrediccionSeis);
    }
	
    
	/**
     * Se valida el rango del metodo A tamaño
     */
    public void testValidarDatosTest1() {
    	try {
    		setupInicializarDatos();
    		Fachada fachada = new Fachada();
    		MetodoA metodoA = new MetodoA(parejaDato, TipoEstimacion.EstimacionLOC, 386);    		
    		fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
    		ModelViewIntervaloPrediccion model = fachada.darModeloIntervaloPrediccion();
    		
    		assertFalse( "Valor de NoPosibleCalcular debe ser false", model.darNoPosibleCalcular());
    		assertEquals( "Valor de r(x,y) debe ser 0.954496574", 0.954496574, model.darRSubXY(), 0.00001);
    		assertEquals( "Valor de r(2) debe ser 0.91106371", 0.91106371, model.darRalCuadrado(), 0.00001);
    		assertEquals( "Valor de significancia debe ser 0.000077517", 0.000077517, model.darSignificancia(), 0.0001);
    		assertEquals( "Valor de B0 debe ser -22.55253275", -22.55253275, model.darBSubCero(), 0.00001);
    		assertEquals( "Valor de B1 debe ser 1.727932426", 1.727932426, model.darBSubUno(), 0.00001);
    		assertEquals( "Valor de yk debe ser 644.4293838", 644.4293838, model.darYSubK(), 0.00001);
    		assertEquals( "Valor de Rango debe ser 230.0017197", 230.0017197, model.darRango(), 0.0001);
    		assertEquals( "Valor de UPI debe ser 874.4311035", 874.4311035, model.darUpi(), 0.0001);
    		assertEquals( "Valor de LPI debe ser 414.427664", 414.427664, model.darLpi(), 0.0001);    
    	}
    	catch(Exception ex) { 		
    		fail("No debio fallar: " + ex.getMessage());
    	}
    }
    
    /**
     * Se valida el rango del metodo A tiempo
     */
    public void testValidarDatosTest2() {
    	try {
    		setupInicializarDatos();
    		Fachada fachada = new Fachada();
    		MetodoA metodoA = new MetodoA(parejaDato, TipoEstimacion.EstimacionTiempoDesarrollo, 386);    		
    		fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
    		ModelViewIntervaloPrediccion model = fachada.darModeloIntervaloPrediccion();
    		
    		assertFalse( "Valor de NoPosibleCalcular debe ser false", model.darNoPosibleCalcular());
    		assertEquals( "Valor de r(x,y) debe ser 0.933306898", 0.933306898, model.darRSubXY(), 0.00001);
    		assertEquals( "Valor de r(2) debe ser 0.871061766", 0.871061766, model.darRalCuadrado(), 0.00001);
    		assertEquals( "Valor de significancia debe ser 0.0000798203", 0.0000798203, model.darSignificancia(), 0.0001);
    		assertEquals( "Valor de B0 debe ser -4.038881575", -4.038881575, model.darBSubCero(), 0.00001);
    		assertEquals( "Valor de B1 debe ser 0.16812665", 0.16812665, model.darBSubUno(), 0.00001);
    		assertEquals( "Valor de yk debe ser 60.85800528", 60.85800528, model.darYSubK(), 0.00001);
    		assertEquals( "Valor de Rango debe ser 27.55764748", 27.55764748, model.darRango(), 0.00001);
    		assertEquals( "Valor de UPI debe ser 88.41565276", 88.41565276, model.darUpi(), 0.00001);
    		assertEquals( "Valor de LPI debe ser 33.3003578", 33.3003578, model.darLpi(), 0.00001);    		
    	}
    	catch(Exception ex) { 		
    		fail("No debio fallar: " + ex.getMessage());
    	}
    }
    
    /**
     * Se valida que la prueba tres, no se pueda calcular
     */
    public void testValidarDatosTest3() {
    	try {
    		setupInicializarDatosProgramaTresASeis();
    		Fachada fachada = new Fachada();
    		MetodoA metodoA = new MetodoA(parejaDatoProgramaTresASeis, TipoEstimacion.EstimacionLOC, 386);    		
    		fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
    		ModelViewIntervaloPrediccion model = fachada.darModeloIntervaloPrediccion();
    		
    		assertTrue( "Valor de NoPosibleCalcular debe ser true", model.darNoPosibleCalcular());    		    		
    	}
    	catch(Exception ex) { 		
    		fail("No debio fallar: " + ex.getMessage());
    	}
    }
    
    /**
     * Se valida que la prueba tres, no se pueda calcular
     */
    public void testValidarDatosTest4() {
    	try {
    		setupInicializarDatosProgramaTresASeis();
    		Fachada fachada = new Fachada();
    		MetodoA metodoA = new MetodoA(parejaDatoProgramaTresASeis, TipoEstimacion.EstimacionTiempoDesarrollo, 386);    		
    		fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoA);
    		ModelViewIntervaloPrediccion model = fachada.darModeloIntervaloPrediccion();
    		
    		assertTrue( "Valor de NoPosibleCalcular debe ser true", model.darNoPosibleCalcular());    		    		
    	}
    	catch(Exception ex) { 		
    		fail("No debio fallar: " + ex.getMessage());
    	}
    }
    
    /**
     * Este metodo se encarga de verificar que se cargue bien cuando es clase
     * 
     */
    public void testCargarArchivo() {
    	try {
    		String archivo = rutaArchivo + "ArchivoCargaIntervaloPrediccion.txt";
    		Fachada fachada = new Fachada();
    		ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(archivo);
    		
    		assertEquals("Deben ser 10 registros", 10, datos.size());    		    		
    	}
    	catch(Exception ex) { 		
    		fail("Excepcion: " + ex.getMessage());
    	}
    }
	
}
