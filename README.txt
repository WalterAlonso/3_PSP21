/************************************************************/
Codigo curso: CSOF5101 - 2017.
Nombre curso: CONCEPTOS AVANZADOS EN INGENIERIA DE SOFTWARE.
Nombre de la tarea: Assignment Kit for Program 7.
Fecha de envío de la tarea: 30 Abril 2017 (16:00), 
		GithHub: 30 Abril 2017 (15:00), Heroku: 30 Abril 2017 (15:00)
Autor: Walter Javier Alonso Roa
/************************************************************/


¨** Descripcion:
Primero se debe colocar el archivo a procesar en la carpeta "ArchivoProcesar". (deben ser txt),
el codigo fuente se encuentra en el repo: https://github.com/WalterAlonso/3_PSP21.git

** Ambiente de ejecucion:
Este programa fue realizado con JRE 1.8 en S.O 7.
Debe tener instalado Maven


**************** Instrucciones de ejecucion ************************
** clone repo desde github.
$git clone https://github.com/WalterAlonso/3_PSP21.git

** Ingresar al folder 3_PSP21
  	cd 3_PSP21

** Ejecucion maven

	 mvn clean install site

** Ejecute el programa:

	java -cp target/Ecos_CalculoIntervaloPrediccion-1.0-SNAPSHOT-jar-with-dependencies.jar uniandes.ecos.conceptosAvanzados.calculoIntervaloPrediccion.controlador.CalculoIntervaloPrediccion "ArchivoCargaIntervaloPrediccion.txt"

** Documentacion del sitio

		- Cobertura de pruebas unitarias: target/site/cobertura/index.html
		- Analisis de codigo (PMD): 	  target/site/pmd.html
		- Documentacion de codigo test: target/site/testapidocs/index.html
		- Documentacion de codigo de la aplicacion: target/site/apidocs/index.html

** Heroku:

	  https://app-calculointrevaloprediccion.herokuapp.com/

