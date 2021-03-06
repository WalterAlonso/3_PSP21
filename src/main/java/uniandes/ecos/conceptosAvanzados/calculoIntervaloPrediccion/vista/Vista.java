package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.vista;


import java.util.Scanner;

/**
 * Es una vista genérica, que se encarga de desplegar informacion e forma secuencial
 * @author WALONSO
 *
 */
public class Vista {
	
	/**
	 * Se encarga de desplegar al usuario los datos en estructura llave - valor.
	 * @param nombreValor: el nombre del tipo que se esta enviando
	 * @param valor: el valor que se desea para ese nombre
	 */
	public void mostrarDatos(String nombreValor, String valor) {
		System.out.println("");
		System.out.printf(" 	%s = %s", nombreValor, valor);	
	}
	
	/**
	 * Pregunta al usuario por datos. espera ena respuesta del usuario.
	 * @param opciones: el conjunto de información que se despliega al usuario.
	 * @return el valor ingresado.
	 */
	public String obtenerDato(StringBuilder opciones) {
		System.out.println("");
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		System.out.println(opciones);
		String valor = teclado.next();
		return valor.trim();
	}
	
	/**
	 * Muestra el error
	 * @param error : el error que se presenta e la aplicación. 
	 */
	public void mostrarError(String error) {
		mostrarDatos("Error", error);
	}
}