package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.test.ReglaSimpson;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.DistribucionT;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ReglaSimpson.ReglaSimpson;

/**
 * Esta se encarga de validar el correcto calculo de la regla simpson.
 * @author WALONSO
 *
 */
public class ReglaSimpsonTest extends TestCase {

	/**
	 * Valída el calculo de encontrar el valor de rango final
	 */
	public void testValidarCalculoRegla() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.iniciarValores();
			distribucion.asignarDof(15);			
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(20);
			reglaSimpson.asignarD(0.5);
						
			assertEquals( "El valor del rango final debe ser 1.75305", 1.75305, reglaSimpson.darCalculoRangoFinal(1.0, 0.45, distribucion), 0.00001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	/**
	 * Valída el calculo de encontrar el valor de rango final
	 */
	public void testValidarCalculoReglaDos() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.iniciarValores();
			distribucion.asignarDof(6);
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(10);
			reglaSimpson.asignarD(0.5);
			
			assertEquals( "El valor del rango final debe ser 0.55338", 0.55338, reglaSimpson.darCalculoRangoFinal(1.0, 0.20, distribucion), 0.00001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	/**
	 * Valída el calculo de encontrar el valor de rango final
	 */
	public void testValidarCalculoReglaTres() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.iniciarValores();
			distribucion.asignarDof(4);
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(10);
			reglaSimpson.asignarD(0.5);
						
			assertEquals( "El valor del rango final debe ser 4.60409", 4.60409, reglaSimpson.darCalculoRangoFinal(1.0, 0.495, distribucion), 0.00001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
		
	/**
	 * Valida el calculo de la regla Simpson  con dof 9
	 */
	public void testValidarCalculoSimpsonRegla() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.asignarDof(9);
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(10);
						
			assertEquals( "El valor de la regla debe ser 0.3500589", 0.3500589, reglaSimpson.darValorCalculoReglaSimpson(1.1, distribucion), 0.0001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	/**
	 * Calcula el valor de la regla Simpson con dof 10
	 */
	public void testValidarCalculoSimpsonReglaDos() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.asignarDof(10);
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(10);
						
			assertEquals( "El valor de la regla debe ser 0.36757", 0.36757, reglaSimpson.darValorCalculoReglaSimpson(1.1812, distribucion), 0.0001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	/**
	 * Calcula el valor de la regla Simpson con dof 30
	 */
	public void testValidarCalculoSimpsonReglaTres() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.asignarDof(30);
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(10);
						
			assertEquals( "El valor de la regla debe ser 0.49500", 0.49500, reglaSimpson.darValorCalculoReglaSimpson(2.750, distribucion), 0.0001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
}

