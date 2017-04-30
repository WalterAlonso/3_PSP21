package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewArchivoIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.Rango;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.MetodoA;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.TipoEstimacion;

public class RangoTest extends TestCase {
	
	/**
	 * Propiedad que contiene los datos de los programas
	 */
	private ArrayList<ModelViewArchivoIntervaloPrediccion> parejaDato;
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
     * Se valida el rango del metodo A tamaño
     */
    public void testValidarRangoTamanio() {
    	try {
    		setupInicializarDatos();
    		MetodoA metodoA = new MetodoA(parejaDato, TipoEstimacion.EstimacionLOC, 386);
    		Rango rango = new Rango();
    		double rangoCalculado = rango.darRango(metodoA, 0.00001, 10, 0.5, 1.0);
    		assertEquals( "Valor del rango debe ser 230.0017197", 230.0017197, rangoCalculado, 0.0001);
    	}
    	catch(Exception ex) { 		
    		fail("No debio fallar: " + ex.getMessage());
    	}
    }
    
    /**
     * Se valida el rango del metodo A tiempo
     */
    public void testValidarRangoTiempo() {
    	try {
    		setupInicializarDatos();
    		MetodoA metodoA = new MetodoA(parejaDato, TipoEstimacion.EstimacionTiempoDesarrollo, 386);
    		Rango rango = new Rango();
    		double rangoCalculado = rango.darRango(metodoA, 0.00001, 10, 0.5, 1.0);
    		assertEquals( "Valor del rango debe ser 27.55764748", 27.55764748, rangoCalculado, 0.0001);
    	}
    	catch(Exception ex) { 		
    		fail("No debio fallar: " + ex.getMessage());
    	}
    }
	
}
