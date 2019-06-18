<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<c:if test="${index >= 5 }">
		<button id="prcd-${index}" class="btn btn-success prcd"
			onclick="Precedent(this)">precedent</button>
	</c:if>
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
		<input id="qu-${ p.productCode }" type="number" min="0" max="${p.quantityInStock }"/>
				<button id="${p.productCode}" onclick="AjoutPanier(this)" class="btn btn-primary"><c:out value="${p.buyPrice}"/>
					€</button>
			</div>
		</div>
	</section>
		
		<input id="price-${p.productCode}" type="hidden" value="${p.buyPrice }"/>
		<input id="image-${p.productCode }" type="hidden" value="${p.img.nom}"/>
		<input id="name-${p.productCode }" type="hidden" value ="${p.productName }"/>

</c:forEach>

<div>
	<c:if test="${ListProduct.size() >= 5 }">
		<button id="svt-${index}" class="btn btn-success svt"
			onclick="Suivant(this)">suivant</button>
	</c:if>
</div>

<script>
	function AjoutPanier(button){
		// recupere id (code produit)
		var idProduit = $(button).attr("id");
		console.log(idProduit);
		// Chercher la quantite
		var quantiteProduit = $("#qu-"+idProduit).val();
		
		var imagePdt = $('#image-'+idProduit).val();
		var productNamePdt = $('#name-'+idProduit).val();
		var buyPricePdt = $('#price-'+idProduit).val();
		
		// Envoyer ces info a la servlet
		$('#PanierClient').load('Panier', {
			// id et quantite ==> le parametre de la requete  
			id: idProduit,
			quantite : quantiteProduit,
			img : imagePdt,
			pdtName : productNamePdt,
			price : buyPricePdt
		});
		
		
		
	}
</script>


