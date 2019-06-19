<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="PanierClient">
	<c:import url="/WEB-INF/ConnectClientOrEmploy/panier.jsp"></c:import>
</div>
<section id="choix">
	<marquee>
		<h1>Un message qui ce deplace pour dire que c'est un client ! </h1>
	</marquee>
</section>
<div>
	<div onchange="myFunction()">
		<form action="#">
			<fieldset>
				<label for="speed">Select a style : </label> <select name="speed"
					id="speed">
					<c:forEach var="pLine" items="${sessionScope.listLine}">
						<option>${pLine.productLine}</option>

					</c:forEach>
				</select>
			</fieldset>
			<p id="demo"></p>
		</form>
	</div>
	<div id="Cars" style="display: flex; justify-content: center;">
		<c:import url="/WEB-INF/ConnectClientOrEmploy/MorceauModele.jsp"></c:import>
	</div>
</div>
<script>
	function myFunction() {
		// ici je stock dans la variable productLine la valeur de l'élément du DOM correspond a l'ID speed
		var productLine = document.getElementById("speed").value;
		// Now nous allons send cette variable en request à la servlet ProductLineServlet
		//La réponse de cette servlet remplacera le contenu id "CARS"
		// si on met un param c'est GET 
		//$("#Cars").load("ProductLine"); ==> dans le GET 
		//si on met met c'est POST la on est dans le post ! 
		$("#Cars").load("ProductLine", {modele : productLine});
		
	}
	
	function Suivant(e){
		console.log($(e).attr("id").substr(4));
		console.log($("#speed").val() );
		$("#Cars").load("ProductLine", {modele : $("#speed").val(), index : $(e).attr("id").substr(4), suivant : 1 });
	}
	
	
	function Precedent(e){
		console.log($(e).attr("id").substr(5));
		console.log($("#speed").val());
		$("#Cars").load("ProductLine", {modele : $("#speed").val(), index : $(e).attr("id").substr(5), precedent : 1 });
	}
	
	  
	  $( function() {
	    $( "#accordion" ).accordion();
	  } );
	  
</script>