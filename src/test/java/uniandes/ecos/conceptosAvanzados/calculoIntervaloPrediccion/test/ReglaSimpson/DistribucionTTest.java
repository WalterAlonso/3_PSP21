package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.test.ReglaSimpson;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.DistribucionT;

/**
 * Realiza las validaciones de calculo de distribucion T
 * @author WALONSO
 *
 */
public class DistribucionTTest extends TestCase {

	/**
	 * Valida el calculod de la distribucionT para unos segmentos con dfo impar.
	 */
	public void testCalcularDistribucionT() {
		try {
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.iniciarValores();
			distribucion.asignarDof(9);			
			assertEquals( "El valor del segmento 0 debe ser 0.388034855 ", 0.388034855, distribucion.darCalculo(0), 0.0001);
			distribucion.iniciarValores();
			assertEquals( "El valor del segmento 1 debe ser 0.385436887 ", 0.385436887, distribucion.darCalculo(0.11), 0.0001);
			distribucion.iniciarValores();
			assertEquals( "El valor del segmento 2 debe ser 0.377767272 ", 0.377767272, distribucion.darCalculo(0.22), 0.0001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	/**
	 * Valida el calculo de la distribuci�nT para unos segmentos con dof par.
	 */
	public void testCalcularDistribucionTDecimal() {
		try {
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.iniciarValores();
			distribucion.asignarDof(10);			
			assertEquals( "El valor del segmento 0 debe ser 0,389108383966031", 0.389108383966031, distribucion.darCalculo(0), 0.0001);
			distribucion.iniciarValores();
			assertEquals( "El valor del segmento 1 debe ser 0,386135942960016", 0.386135942960016, distribucion.darCalculo(0.11812), 0.0001);
			distribucion.iniciarValores();
			assertEquals( "El valor del segmento 2 debe ser 0,377378298093173", 0.377378298093173, distribucion.darCalculo(0.23624), 0.0001);
			distribucion.iniciarValores();
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
}
