<%-- 
    Document   : Depart_Form
    Created on : 14 déc. 2020, 19:00:54
    Author     : Mohamed
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Carrefour Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="/Carref_Web/HomePage" class="navbar-brand"> Carrefour Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="/Carref_Web/Depart/Home" class="nav-link">Departements</a></li>
                                <li><a href="Home" class="nav-link">Employes</a></li>
                                        
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
                        <form action="Update" method="post">
				<caption>
					<h2>Edit New Employe</h2>
				</caption>

				<fieldset class="form-group">
					<label>Employe ID</label> <input type="text"
						value="<c:out value="${idEmp}" />" class="form-control" name="IdEmp" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Employe Name</label> <input type="text"
						value="<c:out value="${EmpName}" />" class="form-control" name="EmpName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>salaire</label> <input type="text"
						value="<c:out value="${salaire}" />" class="form-control" name="salaire" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Departement</label> 
                                        <select class="form-control" name="refDept" value="<c:out value="${refDept.idDept}" />">
                                                
                                                <c:forEach var="Dep" items="${Deps}">
                                                    <option><c:out value="${Dep.idDept}" /></option>				
                                                </c:forEach>
                                              </select>
				</fieldset>
				<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

