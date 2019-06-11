<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Veuillez vous authentifier</title>
        <link rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Crete+Round" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"/> <!-- CDN FontAwesome -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/> <!-- CDN Bootstrap -->
		<meta name="viewport" content="width=device-width, initial-scale=1"/> <!-- Responsive design -->
		<meta name="theme-color" content="code couleur"/> <!-- Couleur navigateur Chrome Mobile -->
    	<style><%@include file="/css/styles.css"%></style>
    </head>
    <body>
     <nav class="navbar navbar-expand-sm navbar-dark">
 		 <a class="navbar-brand" href="#">McKING</a>
  			<ul class="navbar-nav">
    			<li class="nav-item">
      	 <a class="nav-link" href="/Base/">Accueil</a>
    			</li>
    			<li class="nav-item">
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
  Comment ça marche ?
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" data-backdrop="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Comment ça marche ?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Connectez-vous ensuite vous aurez accès à votre compte ! pour ensuite avoir une large selection et création de menu en fonction de divers pathologie
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
    			</li>
  			</ul>
	</nav>
 
    	<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
			  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			  <li data-target="#myCarousel" data-slide-to="1"></li>
			  <li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
			  <div class="carousel-item active">
					<img src="<%=request.getContextPath()%>/img/12.jpg" alt="...">
				<div class="container">
				  <div class="carousel-caption text-left">
					<h1 style="color:whitesmoke">Texte 1 </h1>
					<p>desc 1 </p>
				  </div>
				</div>
			  </div>
			  <div class="carousel-item">
				  <img src="<%=request.getContextPath()%>/img/10.jpg" alt="...">
				<div class="container">
					<div class="carousel-caption">
					<h1 style="color:whitesmoke">Texte 2 </h1>
					<p>desc 2 </p>
				  </div>
				</div>
			  </div>
			  <div class="carousel-item">
					<img src="<%=request.getContextPath()%>/img/14.jpg" alt="...">
				<div class="container">
				  <div class="carousel-caption text-right">
					<h1 style="color:whitesmoke">Texte 2 </h1>
					<h1 >Texte 3</h1>
					<p>descr1 </p>
				  </div>
				</div>
			  </div>
			</div>
			<a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
			  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			  <span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
			  <span class="carousel-control-next-icon" aria-hidden="true"></span>
			  <span class="sr-only">Next</span>
			</a>
		  </div>
    
    	<c:if test="${not empty login }"></c:if>
<form method='post' action='login'>
			<img class="logo" src="<%=request.getContextPath()%>/img/01.jpg" alt="Logo">
			<h1> Please sign in </h1>
		<div class="form-group">
			<input name='txtLogin' type="text" class="form-control" value='' placeholder="Login">
			<small id="loginhelp" class="form-text text-muted">Ne confier vos identifiants à personne sauf à votre femme</small>
		</div>
		<div class="form-group">
			<input name='txtPassword' type="password" value='' class="form-control" placeholder="Password">
		</div>
		<input name='btnConnect' class="bouton" type='submit' value='Sign in' />
		<div class="sign">
			<a href="#" style="color : rgb(104, 104, 104)" >I forgot my password :/ </a>
			<br>
			<a href="#" style="color : rgb(104, 104, 104)"> Sign up here :)  </a>
		</div>
</form>



<footer class="page-footer font-small mdb-color darken-3 pt-4">
    <div class="container">
      <!--Grid row-->
      <div class="row d-flex justify-content-center">
        <!--Grid column-->
        <div class="col-md-6">
          <div class="embed-responsive embed-responsive-16by9 mb-4">
            <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/3egagRvougI" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>

    
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
      <a href="https://www.youtube.com/watch?v=3egagRvougI&list=RD3egagRvougI&start_radio=1"> King@</a>
    </div>
  </footer>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> <!-- CDN jQuery -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> <!-- CDN Popper.js -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> <!-- CDN JavaScript Bootstrap  -->  
    </body>
</html>