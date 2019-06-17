<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="choix">
	<marquee>
		<h1>Un message qui ce deplace pour dire que c'est un client</h1>
	</marquee>
</section>
<div style="display: flex; justify-content: center;">

	<script>
		$(function() {
			$("#speed").selectmenu();

			$("#files").selectmenu();

			$("#number").selectmenu().selectmenu("menuWidget").addClass(
					"overflow");

			$("#salutation").selectmenu();
		});
	</script>

	<div class="demo">
		<form action="#">
			<fieldset>
				<label for="speed">Select a style : </label> <select name="speed"
					id="speed">
					<c:forEach var="pLine" items="${listLine}">
						<option>${pLine.productLine}</option>

					</c:forEach>
				</select>
			</fieldset>
		</form>
	</div>

	<c:forEach var="p" items="${ListProduct}">

		<section>
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="./img/Products/${p.img.nom}"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">
						<c:out value="${p.productName}" />
					</h5>
					<p class="card-text">
						<c:out value="${p.productDescription}" />
					</p>
					<a href="#" class="btn btn-primary"><c:out
							value="${p.buyPrice}" /> €</a>
				</div>
			</div>
		</section>

	</c:forEach>
</div>