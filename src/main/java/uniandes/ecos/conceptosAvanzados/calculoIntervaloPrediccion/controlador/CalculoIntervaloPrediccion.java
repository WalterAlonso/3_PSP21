/**
 * Propósito:     Calcular el intervalo de predicción utilizando regla Simpson con distribución T de un conjúnto de datos dado.
 * Autor(s):   Walter Alonso
 * Fecha creación: 29 Abril 2017
 * Modificado por: Walter Alonso. 
 * Ultima modificación: 29 Abril 2017.
*/

package uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.controlador;

import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.ModelViewArchivoIntervaloPrediccion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.IMetodoProbe;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.MetodoA;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.MetodoB;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.modelo.MetodoProbe.TipoEstimacion;
import uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.vista.CalculoIntervaloPrediccionVista;

/**
 * Realiza el calculo de Intervalo predicción.
 * @author WALONSO
 *
 */
public class CalculoIntervaloPrediccion {

	/**
	 * Metodo principal que se encarga de centralizar las interacciones con el usuario y mostrar
	 * los resultados.
	 * @param args: debe contener la ruta del archivo a procesar
	 */
	public static void main(String[] args) {
		CalculoIntervaloPrediccionVista vista = new CalculoIntervaloPrediccionVista();
		try
		{		
			if(args.length < 1) {
				throw new Exception("No tiene argumentos, debe ingresar la ruta del archivo");
			}
			
			String archivo = "./ArchivoProcesar/" + args[0];
			Fachada fachada = new Fachada();
			ArrayList<ModelViewArchivoIntervaloPrediccion> datos = fachada.cargarDatosInicialesIntervaloPrediccion(archivo);
						
			while (true) {
				IMetodoProbe metodoProbe = obtenerElMetodo(vista, datos);
				fachada.procesarIntervaloPrediccion(1.0, 0.00001, 10, 0.5, metodoProbe);
				fachada.mostrarCalculos(vista);	
			}
		}
		catch(Exception ex) {				
			vista.mostrarError(ex.getMessage());
		}
	}
	
	/**
	 * Obtiene el metodo sea A o B, con el cual se espera realizar el calculo de estimaciones de tamaño o tiempo.
	 * @param vista : la vista de la aplicación, para informar los cambios o errores.
	 * @param programas : los registros de los programas e insumo para realizar el calculo.
	 * @return el metodoProbe el cual se va a analizar.
	 */
	private static IMetodoProbe obtenerElMetodo(CalculoIntervaloPrediccionVista vista, ArrayList<ModelViewArchivoIntervaloPrediccion> programas) {
		IMetodoProbe metodoProbe = null;
		// la vista retorna el metodo a analizar (1=A y 2=B)
		int metodo = vista.obtenerMetodoCrear();
		// la vista retorna el tipo de estimacion ( 1=Estimacion LOC, 2=Estimacion tiempo)
		int tipoEstimacionUsuario = vista.obtenerPlanEstimacion();
		int proxyEstimado = vista.obtenerProxyEstimado();
		
		TipoEstimacion tipoEstimacion = TipoEstimacion.EstimacionLOC;
		if (tipoEstimacionUsuario == 2) {
			tipoEstimacion = TipoEstimacion.EstimacionTiempoDesarrollo;
		}
		
		if (metodo == 1) {				
			metodoProbe = new MetodoA(programas, tipoEstimacion, proxyEstimado);
		}
		else {
			metodoProbe = new MetodoB(programas, tipoEstimacion, proxyEstimado);
		}
		return metodoProbe;
	}

}
