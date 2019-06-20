<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div style="display : flex ; justify-content: center ; align-items: center">
	<c:if test="${index != 0 }">
		<button id="prcd-${index}" class="btn btn-success prcd"
			onclick="Precedent(this)">precedent</button>
	</c:if>
</div> 

<section
	style="display: flex; justify-content: center; flex-wrap: wrap; width : 85%" >
<c:forEach var="p" items="${ListProduct}">
	<div class="card" style="width: 18rem;">
		<img class="card-img-top" src="./img/Products/${p.img.nom}"
			alt="Card image cap">
		<div class="card-body">
			<h5 class="card-title">
				<c:out value="${p.productName}" />
			</h5>
			<button id="${p.productCode}" onclick="Ajout(this)"
				class="btn btn-primary">
				<c:out value="${p.buyPrice}" />
				€
			</button>
		</div>
	</div>

	<input id="price-${p.productCode}" type="hidden" value="${p.buyPrice }" />
	<input id="image-${p.productCode }" type="hidden" value="${p.img.nom}" />
	<input id="name-${p.productCode }" type="hidden"
		value="${p.productName }" />
</c:forEach>

</section>


<script>
	function Ajout(button) {
		// recupere id (code produit)
		var idProduit = $(button).attr("id");
		console.log(idProduit);
		// Chercher la quantite
		var quantiteProduit = $("#qu-" + idProduit).val();
		
		var imagePdt = $('#image-' + idProduit).val();
		var productNamePdt = $('#name-' + idProduit).val();
		var buyPricePdt = $('#price-' + idProduit).val();

		// Envoyer ces info a la servlet
		$('#PanierClient').load('Panier', {
			// id et quantite ==> le parametre de la requete  
			id : idProduit,
			quantite : 1,
			img : imagePdt,
			pdtName : productNamePdt,
			price : buyPricePdt
		});

	}
</script>


