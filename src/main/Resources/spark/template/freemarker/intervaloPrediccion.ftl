<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>
  <#include "nav.ftl">
<div class="jumbotron text-center">
  <div class="container">    
    <h3>CALCULO DE INTERVALO PREDICCI&OCUTE;N - TEST ${numeroTest}</h3>
  </div>
</div>
<div class="container">
	VALORES DADOS
  <table class="table table-striped">
	<tr>
		<th>Test</th>
		<th>Parameter</th>
		<th>Actual Value</th>		
	</tr>	
	<#list datos as modeloIntervaloPrediccion>		
			<tr >		
				<td rowspan="9">TEST ${numeroTest}</td> 
				<td>r (x,y) </td>
				<td>
					<#if modeloIntervaloPrediccion.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${modeloIntervaloPrediccion.darRSubXY()}
					</#if>
				</td> 
			</tr>
			<tr >		
				<td>r (2) </td> 	
				<td>${modeloIntervaloPrediccion.darRalCuadrado()}</td> 
			</tr>
			<tr >		
				<td>Significancia</td> 	
				<td>${modeloIntervaloPrediccion.darSignificancia()}</td> 
			</tr>	
			<tr >		
				<td>B0</td> 		
				<td>${modeloIntervaloPrediccion.darBSubCero()}</td> 
			</tr>		
			<tr >		
				<td>B1</td> 		
				<td>${modeloIntervaloPrediccion.darBSubUno()}</td> 
			</tr>
			<tr >		
				<td>Yk</td> 		
				<td>${modeloIntervaloPrediccion.darYSubK()}</td> 
			</tr>
			<tr >		
				<td>Rango</td> 		
				<td>${modeloIntervaloPrediccion.darRango()}</td> 
			</tr>
			<tr >		
				<td>UPI</td> 		
				<td>${modeloIntervaloPrediccion.darUpi()}</td> 
			</tr>
			<tr >		
				<td>LPI</td> 		
				<td>${modeloIntervaloPrediccion.darLpi()}</td> 
			</tr>
	</#list>
  </table>
  
  VALORES ESPERADOS
  <table class="table table-striped">
	<tr>
		<th>Test</th>
		<th>Parameter</th>
		<th>Valor esperado</th>		
	</tr>	
	<#list datosEsperado as modeloIntervaloPrediccion>		
			<tr >		
				<td rowspan="9">TEST ${numeroTest}</td> 
				<td>r (x,y) </td>
				<td>
					<#if modeloIntervaloPrediccion.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${modeloIntervaloPrediccion.darRSubXY()}
					</#if>
				</td> 
			</tr>
			<tr >		
				<td>r (2) </td> 	
				<td>${modeloIntervaloPrediccion.darRalCuadrado()}</td> 
			</tr>
			<tr >		
				<td>Significancia</td> 	
				<td>${modeloIntervaloPrediccion.darSignificancia()}</td> 
			</tr>	
			<tr >		
				<td>B0</td> 		
				<td>${modeloIntervaloPrediccion.darBSubCero()}</td> 
			</tr>		
			<tr >		
				<td>B1</td> 		
				<td>${modeloIntervaloPrediccion.darBSubUno()}</td> 
			</tr>
			<tr >		
				<td>Yk</td> 		
				<td>${modeloIntervaloPrediccion.darYSubK()}</td> 
			</tr>
			<tr >		
				<td>Rango</td> 		
				<td>${modeloIntervaloPrediccion.darRango()}</td> 
			</tr>
			<tr >		
				<td>UPI</td> 		
				<td>${modeloIntervaloPrediccion.darUpi()}</td> 
			</tr>
			<tr >		
				<td>LPI</td> 		
				<td>${modeloIntervaloPrediccion.darLpi()}</td> 
			</tr>
	</#list>
  </table>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('[name ^= "lnkArchivo"]').removeClass('active');
        $('[name = "lnkHome"]').addClass('active');
    });
</script>
</body>
</html>