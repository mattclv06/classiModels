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
							<p>
								<c:out value="${p.productDescription}" />
							</p>
						</div>
					</div>
				</td>
				<td data-th="Price"><c:out value="${p.buyPrice}"/></td>
				<td data-th="Quantity"><input type="number" class="form-control text-center" value=""></td>
				<td data-th="Subtotal" class="text-center"><c:out value="${p.quProduit}"/> x <c:out value="${p.buyPrice}"></c:out> </td>
				<td class="actions" data-th="">
					<button class="btn btn-info btn-sm" > Actualiser
						<i class="fa fa-refresh"></i>
					</button>
					<button class="btn btn-danger btn-sm"> Effacer
						<i class="fa fa-trash-o"></i>
					</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr class="visible-xs">
			<c:set var = "total" scope = "session" value = "${p.buyPrice * p.quProduit}"/>
			<td class="text-center"><strong>Total : <c:out
							value="${total}"/>
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