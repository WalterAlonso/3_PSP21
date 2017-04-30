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
	<tr >
		<td rowspan="9">TEST ${numeroTest}</td> 
			<td>r (x,y) </td>
			<td>
				<#if datos.darNoPosibleCalcular() == true >
					n/a					
				<#else>
					${datos.darRSubXY()}
				</#if>
			</td> 
	</tr>
			<tr >		
				<td>r (2) </td> 	
				<td>${datos.darRalCuadrado()}</td> 
			</tr>
			<tr >		
				<td>Significancia</td> 	
				<td>${datos.darSignificancia()}</td> 
			</tr>	
			<tr >		
				<td>B0</td> 		
				<td>${datos.darBSubCero()}</td> 
			</tr>		
			<tr >		
				<td>B1</td> 		
				<td>${datos.darBSubUno()}</td> 
			</tr>
			<tr >		
				<td>Yk</td> 		
				<td>${datos.darYSubK()}</td> 
			</tr>
			<tr >		
				<td>Rango</td> 		
				<td>${datos.darRango()}</td> 
			</tr>
			<tr >		
				<td>UPI</td> 		
				<td>${datos.darUpi()}</td> 
			</tr>
			<tr >		
				<td>LPI</td> 		
				<td>${datos.darLpi()}</td> 
			</tr>
  </table>
  
  VALORES ESPERADOS
  <table class="table table-striped">
	<tr>
		<th>Test</th>
		<th>Parameter</th>
		<th>Valor esperado</th>		
	</tr>	
			<tr >		
				<td rowspan="9">TEST ${numeroTest}</td> 
				<td>r (x,y) </td>
				<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darRSubXY()}
					</#if>
				</td> 
			</tr>
			<tr >		
				<td>r (2) </td> 	
				<td>${datosEsperado.darRalCuadrado()}</td> 
			</tr>
			<tr >		
				<td>Significancia</td> 	
				<td>${datosEsperado.darSignificancia()}</td> 
			</tr>	
			<tr >		
				<td>B0</td> 		
				<td>${datosEsperado.darBSubCero()}</td> 
			</tr>		
			<tr >		
				<td>B1</td> 		
				<td>${datosEsperado.darBSubUno()}</td> 
			</tr>
			<tr >		
				<td>Yk</td> 		
				<td>${datosEsperado.darYSubK()}</td> 
			</tr>
			<tr >		
				<td>Rango</td> 		
				<td>${datosEsperado.darRango()}</td> 
			</tr>
			<tr >		
				<td>UPI</td> 		
				<td>${datosEsperado.darUpi()}</td> 
			</tr>
			<tr >		
				<td>LPI</td> 		
				<td>${datosEsperado.darLpi()}</td> 
			</tr>	
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