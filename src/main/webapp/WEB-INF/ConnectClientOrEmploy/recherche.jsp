<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section style="display : flex ; flex-wrap: wrap; width: 80%; justify-content: center">
<form method="post" action="Search()">
	<div class="input-group-text">Customer Name :
	<input type="text" class="form-control"	id="CustomerName" placeholder="Customer Name"></div>
<!-- Payment Date -->
	<div class="input-group-text">Payment Date :
	<input type="date" class="form-control"	id="PaymentDate"></div>

<!-- Period -->
	<div class="input-group-text">Period Payment / Début :
	<input type="date" class="form-control"	id="PeriodeDePaiementDebut"> Fin : 
	<input type="date" class="form-control"	id="PeriodeDePaiementFin"></div>
<!-- Order Date -->
	<div class="input-group-text">Date de commande : 
	<input type="date" class="form-control"	id="OrderDate">
	</div>
<!-- Period Order Date-->
	<div class="input-group-text">Period Order Date / Début :
	<input type="date" class="form-control"	id="PeriodeDateCommandeDebut"> Fin : 
	<input type="date" class="form-control"	id="PeriodeDateCommandeFin">
	</div>
<!-- Shipped Date -->
	<div class="input-group-text">Date d'envoi :
	<input type="date" class="form-control"	id="DateEnvoieFin"></div>
<!-- Period Order Date-->
	<div class="input-group-text">Period Shipped Date / Début : 
	<input type="date" class="form-control"	id="PeriodEnvoiDebut"> Fin :
	<input type="date" class="form-control"	id="PeriodEnvoiFin">
	</div>

<!-- Status -->
	<div class="input-group-text">Status :
	<input type="text" class="form-control" id="Status"	placeholder="Status"></div>
<!-- ProductNames -->
	<div class="input-group-text">Product Name :
	<input type="text" class="form-control" id="ProductsName" placeholder="Products Name"></div>

	<button type="button" class="btn btn-succes" id="search" onclick="Search()">Search</button>
</form>
</section>


<script>
	function Search() {
		var CustomerName = $("#CustomerName").val();
		var PaymentDate = $("#PaymentDate").val();
		
		var OrderDate = $('#OrderDate').val();
		var DateEnvoieFin = $('#DateEnvoieFin').val();
		var Statuso = $('#Status').val();
		var ProductsNameo = $("#ProductsName").val();

		// Envoyer ces info a la servlet
		$('#resultat').load('Find', {
			CustoName : CustomerName,
			PayDate : PaymentDate,
			OrdDate : OrderDate,
			DateEnvFin : DateEnvoieFin,
			Status : Statuso,
			ProductsName : ProductsNameo

		});

	}
</script>