<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section id="choix">
	<marquee>
		<h1>Flooooooooo suce bitch </h1>
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
	
	<div id="recherche" style="display: flex; justify-content: center;">
		<c:import url="/WEB-INF/ConnectClientOrEmploy/recherche.jsp"></c:import>
	</div>
</div>



<section id="resultat">
		<c:import url="/WEB-INF/ConnectClientOrEmploy/resultatRecherche.jsp"></c:import>
</section>