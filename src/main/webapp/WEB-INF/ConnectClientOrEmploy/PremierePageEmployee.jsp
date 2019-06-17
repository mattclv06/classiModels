<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <script>
	var request;
	function sendInfo() {
		var v = document.vinform.t1.value;
		var url = "Login.jsp?val=" + v;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}

		try {
			request.onreadystatechange = getInfo;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function getInfo() {
		if (request.readyState == 4) {
			var val = request.responseText;
			document.getElementById('amit').innerHTML = val;
		}
	}
</script> 
-->
<section id="choix">
	<marquee>
		<h1>Un message qui ce deplace pour dire que c'est un employee </h1>
	</marquee>
	<form name="vinform">
		<input type="text" name="t1" onkeyup="sendInfo()">
	</form>

	<span id="amit"> </span>
</section>