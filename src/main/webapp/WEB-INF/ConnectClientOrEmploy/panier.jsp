<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">
	<table id="cart" class="table table-hover table-condensed">
		<thead>
			<tr>
				<th style="width: 50%">Product</th>
				<th style="width: 10%">Price</th>
				<th style="width: 8%">Quantity</th>
				<th style="width: 22%" class="text-center">Subtotal</th>
				<th style="width: 10%"></th>
			</tr>
		</thead>
		<tbody>
		<c:set var="totalCount" scope="session" value="0"/>
			<c:forEach var="p" items="${sessionScope.listProductInPanier}">
				<tr>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-2 hidden-xs">
								<img src="./img/Products/${p.img.nom}" alt="..."
									class="imagepanier" />
							</div>
							<div class="col-sm-10">
								<h4 class="nomargin">
									<c:out value="${p.productName}" />
								</h4>
							</div>
						</div>
					</td>

					<td data-th="Price"><c:out value="${p.buyPrice}" /></td>
					<td data-th="Quantity">
					
					<input id="quu-${ p.productCode }"
						type="number" min="1" value="1"
						class="form-control text-center" ></td>
					<td data-th="Subtotal" class="text-center">
					<c:out value="${p.quProduit}" /> x <c:out value="${p.buyPrice}"/>
					<c:set var="SommeQuantiteCars" value="${p.total}" />
					
					</td>
					<td class="actions" data-th="">
						<button class="btn btn-info btn-sm" id="${p.productCode}"
							onclick="AjoutInPanier(this)">
							Ajouter <i class="fa fa-refresh"></i>
						</button>
						<button class="btn btn-danger btn-sm" onclick="RemoveInPanier(this)" id="${p.productCode}">
							Effacer <i class="fa fa-trash-o"></i>
						</button> 
				Somme total de l'article : 
				<c:out value="${p.total}€"/>
				<c:set var="totalDesCommandes" value="${totalDesCommandes + p.total}" />
					</td>
				</tr>

			</c:forEach>
		</tbody>
		<tfoot>
			<tr class="visible-xs">
				<td class="text-center"><strong>Sommes Total des Articles : <c:out value="${totalDesCommandes}"/> 
				</strong></td>
			</tr>
			<tr>
				<td><a href="#" class="btn btn-warning"> <i
						class="fa fa-angle-left"></i> Continue Shopping
				</a></td>
				<td colspan="2" class="hidden-xs"></td>
				<td class="hidden-xs text-center"><strong>Total <c:out
							value="" /> x Quantity
				</strong></td>
				<td><a href="#" class="btn btn-success btn-block">Checkout
						<i class="fa fa-angle-right"></i>
				</a></td>
			</tr>
		</tfoot>
	</table>
</div>
<script>

function AjoutInPanier(button) {
	// recupere id (code produit)
	var idProduit = $(button).attr("id");
	console.log(idProduit);
	// Chercher la quantite
	var quantiteProduit = $("#quu-" + idProduit).val();

	// Envoyer ces info a la servlet
	$('#PanierClient').load('SupPanier', {
		// id et quantite ==> le parametre de la requete  
		id : idProduit,
		quantite : quantiteProduit,
		plus : 1
	});

}

function RemoveInPanier(button) {
	// recupere id (code produit)
	var idProduit = $(button).attr("id");
	console.log(idProduit);
	// Chercher la quantite
	var quantiteProduit = $("#quu-" + idProduit).val();

	// Envoyer ces info a la servlet
	$('#PanierClient').load('SupPanier', {
		// id et quantite ==> le parametre de la requete  
		id : idProduit,
		quantite : quantiteProduit,
		moins : 1
	});

}
</script>

<!--	$('#vider').click(function(e){
		$('#PanierClient').load('acces-panier',{article:$(this).attr('id').substr(4), quantite: 0 , vider:1});
		$('#nbArticle').load("Panier");
		return false;
	}); -->

