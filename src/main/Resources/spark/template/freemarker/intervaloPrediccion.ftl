<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>
  <#include "nav.ftl">
<div class="jumbotron text-center">
  <div class="container">    
    <h3>CALCULO DE INTERVALO PREDICCION - TEST ${numeroTest}</h3>
  </div>
</div>
<div class="container">
  <table class="table table-striped">
	<tr>
		<th>Test</th>
		<th>Parameter</th>
		<th>Actual Value</th>
		<th>Expected Value</th>		
	</tr>	
	<tr >
			<td rowspan="9">TEST ${numeroTest}</td> 
			<td>r (x,y) </td>
			<td>
				<#if datos.darNoPosibleCalcular() == true >
					n/a					
				<#else>
					${datos.darRSubXY()?string("####.##########")}
				</#if>
			</td> 
			<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darRSubXY()?string("####.##########")}
					</#if>
				</td> 
		</tr>
			<tr >		
				<td>r (2) </td> 	
				<td>
					<#if datos.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datos.darRalCuadrado()?string("####.##########")}
					</#if>
				</td> 
				<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darRalCuadrado()?string("####.##########")}
					</#if>
				</td> 
			</tr>
			<tr >		
				<td>Significancia</td> 	
				<td>
					<#if datos.darNoPosibleCalcular() == false >										
						${datos.darSignificancia()?string("####.##########")}						
					</#if>
				</td> 
				<td>
					<#if datosEsperado.darNoPosibleCalcular() == false >						
						${datosEsperado.darSignificancia()?string("####.##########")}					
					</#if>
				</td> 
			</tr>	
			<tr >		
				<td>B0</td> 		
				<td>
					<#if datos.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datos.darBSubCero()?string("####.##########")}
					</#if>
				</td> 
				<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darBSubCero()?string("####.##########")}
					</#if>
				</td> 
			</tr>		
			<tr >		
				<td>B1</td> 
				<td>
					<#if datos.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datos.darBSubUno()?string("####.##########")}
					</#if>
				</td> 
<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darBSubUno()?string("####.##########")}
					</#if>
				</td>				
			</tr>
			<tr >		
				<td>Yk</td> 
				<td>
					<#if datos.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datos.darYSubK()?string("####.##########")}
					</#if>
				</td> 
<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darYSubK()?string("####.##########")}
					</#if>
				</td> 					
			</tr>
			<tr >		
				<td>Rango</td> 		
				<td>
					<#if datos.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datos.darRango()?string("####.##########")}
					</#if>
				</td> 
				<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darRango()?string("####.##########")}
					</#if>
				</td> 
			</tr>
			<tr >		
				<td>UPI</td>
				<td>
					<#if datos.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datos.darUpi()?string("####.##########")}
					</#if>
				</td> 
				<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darUpi()?string("####.##########")}
					</#if>
				</td> 
			</tr>
			<tr >		
				<td>LPI</td> 
				<td>
					<#if datos.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datos.darLpi()?string("####.##########")}
					</#if>
				</td> 
				<td>
					<#if datosEsperado.darNoPosibleCalcular() == true >
						n/a					
					<#else>
						${datosEsperado.darLpi()?string("####.##########")}
					</#if>
				</td> 
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