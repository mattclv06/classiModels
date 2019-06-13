<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br><br><br><br>
<h1 style="color : white"> Bonjour Client <c:out value="${sessionScope.login.login}" /> ! </h1>
    <!-- Mask & flexbox options-->
    <div class="mask rgba-black-light d-flex justify-content-center align-items-center">
      <!-- Content -->
      <div class="container">
        <!--Grid row-->
        <div class="row wow fadeIn">
          <!--Grid column-->
          <div class="col-md-6 mb-4 white-text text-center text-md-left">

            <h1 class="display-4 font-weight-bold couleurOrange">Classic Models</h1>

            <hr class="hr-light">

            <p class="mb-4 d-none d-md-block couleurOrange">
              <strong> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam euismod, nisl id sollicitudin
                vestibulum, leo nunc bibendum tortor, id porta purus nisl vitae lectus. Quisque mattis, ipsum non
                ultricies faucibus, tellus felis sagittis velit, sed ultricies felis orci scelerisque est. Vestibulum
                egestas congue turpis vitae convallis </strong>
            </p>

          </div>
          <!--Grid column-->

        </div>
        <!--Grid row-->
      </div>
      <!-- Content -->
    </div>
    <!-- Mask & flexbox options-->
