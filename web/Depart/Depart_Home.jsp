<%-- 
    Document   : Depart_Home
    Created on : 14 déc. 2020, 19:22:37
    Author     : Mohamed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
				<li><a href="Home" class="nav-link">Departements</a></li>
                                <li><a href="/Carref_Web/Employe/Home" class="nav-link">Employes</a></li>
                                        
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Departements</h3>
			<hr>
			<div class="container text-left">

				<a href="Add" class="btn btn-success">Add New Departement</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Dep-Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Dep" items="${Deps}">
						<tr>
                                                   
                                                    <td name = "idDept"><c:out value="${Dep.idDept}" /></td>
							<td name="DepName"><c:out value="${Dep.nom}" /></td>
							<td><a href="Updateb?idDept=<c:out value="${Dep.idDept}" />&DepName=<c:out value="${Dep.nom}" />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="Delete?idDept=<c:out value="${Dep.idDept}" />">Delete</a></td>
						</tr>
					</c:forEach>     
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>

