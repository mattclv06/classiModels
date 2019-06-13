<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" /><!-- Encodage en UTF-8-->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" />
		<!-- CDN FontAwesome -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
		<!-- CDN Bootstrap -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<!-- CSS -->
		  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Material Design Bootstrap -->
		<link href="css/mdb.min.css" rel="stylesheet">
		<!-- Your custom styles (optional) -->
		<link href="css/style.min.css" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!-- Responsive design -->
		<meta name="theme-color" content="code couleur" />
		<!-- Couleur navigateur Chrome Mobile -->
		<title>Page test alim</title>
		<meta name="description" content="Ta description, ne pas depasser 155 caracteres">
	</head>
	<!-- ---------------------------------------------------NAVBAR---------------------------------------- -->
	<body>
		<!-- Naaaaaaaaaaaaaaav  -->
		<nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
			<c:import url="/WEB-INF/nav.jsp"></c:import>
		</nav>
	
		<!-- ligne de lien  -->
		<section class="view full-page-intro"
    style="background-image: url('img/S700_1938.jpg'); background-repeat: no-repeat; background-size: cover;">
			<c:import url="/WEB-INF/ConnectEmploy/Milieu.jsp"></c:import>
		</section>
	
		<div id="retour">  
			<c:import url="/WEB-INF/ConnectEmploy/PremierePage.jsp" />
		</div>
		<footer	class="page-footer text-center font-small mt-4 wow fadeIn couleurFramboise">
			<c:import url="/Footer.jsp"></c:import>
		</footer>
	
		<script type="text/javascript" src="./js/application.js"></script>
		<!-- JS -->
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		<!-- Bootstrap tooltips -->
		<script type="text/javascript" src="js/popper.min.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<!-- MDB core JavaScript -->
		<script type="text/javascript" src="js/mdb.min.js"></script>
		<!-- Initializations -->
		<script type="text/javascript">
		  // Animations initialization
		  new WOW().init();
		</script>
		<script type="text/javascript" src=" <c:url value="./js/scriptco.js" />"></script>
		<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<!-- CDN Popper.js -->
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<!-- CDN JavaScript Bootstrap  -->
		<script>
			$(document).ready(function(){
				
			//etape une selection 
				$("#CreerMenuServlet").click(
					//quest ce qu'il ce passe pendant l'action 
						function(event){
						$(this).siblings().removeClass("activeCSS");
						$(this).addClass("activeCSS");
						// changement de la div retour ! 
						$("#retour").load("CreerMenuServlet");
					});
			});
		</script>
	</body>
</html>