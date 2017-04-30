<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>
  <#include "nav.ftl">
<div class="jumbotron text-center">
  <div class="container">    
    <h3>CALCULO DE INTERVALO PREDICCI&OCUTE;N</h3>
  </div>
</div>
<div class="container">
  <table class="table table-striped">
	<tr>
		<th>Test</th>
		<th>Parameter</th>
		<th>Expected Value</th>
		<th>Actual Value</th>		
	</tr>
	<#list datos as modeloIntervaloPrediccion>
		<#if modeloIntervaloPrediccion.darNoPosibleCalcular()>
		<tr >		
			
		</tr>
		<#else>			
			<tr >		
				<td rowspan="9">1</td> 
				<td>r (x,y) </td> 				
				<td>0.954496574</td> 
				<td>${modeloIntervaloPrediccion.darRSubXY()}</td> 
			</tr>
			<tr >		
				<td>r (2) </td> 				
				<td>0.91106371</td> 
				<td>${modeloIntervaloPrediccion.darRalCuadrado()}</td> 
			</tr>
			<tr >		
				<td>Significancia</td> 				
				<td>0.000077517</td> 
				<td>${modeloIntervaloPrediccion.darSignificancia()}</td> 
			</tr>	
			<tr >		
				<td>Significancia</td> 				
				<td>0.000077517</td> 
				<td>${modeloIntervaloPrediccion.darSignificancia()}</td> 
			</tr>				
assertFalse( "Valor de NoPosibleCalcular debe ser false", model.darNoPosibleCalcular());
    		assertEquals( "Valor de r(x,y) debe ser 0.954496574", 0.954496574, model.darRSubXY(), 0.00001);
    		assertEquals( "Valor de r(2) debe ser 0.91106371", 0.91106371, model.darRalCuadrado(), 0.00001);
    		assertEquals( "Valor de significancia debe ser 0.000077517", 0.000077517, model.darSignificancia(), 0.00001);
    		assertEquals( "Valor de B0 debe ser -22.55253275", -22.55253275, model.darBSubCero(), 0.00001);
    		assertEquals( "Valor de B1 debe ser 1.727932426", 1.727932426, model.darBSubUno(), 0.00001);
    		assertEquals( "Valor de yk debe ser 644.4293838", 644.4293838, model.darYSubK(), 0.00001);
    		assertEquals( "Valor de Rango debe ser 230.0017197", 230.0017197, model.darRango(), 0.00001);
    		assertEquals( "Valor de UPI debe ser 874.4311035", 874.4311035, model.darUpi(), 0.00001);
    		assertEquals( "Valor de LPI debe ser 414.427664", 414.427664, model.darLpi(), 0.00001); 			<
		   <!--
			<td>${modeloIntervaloPrediccion.darRalCuadrado()}</td> 
			<td>${modeloIntervaloPrediccion.darSignificancia()}</td> 
			<td>${modeloIntervaloPrediccion.darBSubCero()}</td> 
			<td>${modeloIntervaloPrediccion.darBSubUno()}</td> 
			<td>${modeloIntervaloPrediccion.darYSubK()}</td> 
			<td>${modeloIntervaloPrediccion.darRango()}</td> 
			<td>${modeloIntervaloPrediccion.darUpi()}</td> 
			<td>${modeloIntervaloPrediccion.darLpi()}</td> -->
		</#if>
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
