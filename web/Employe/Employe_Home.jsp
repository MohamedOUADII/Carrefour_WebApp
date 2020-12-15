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
				<li><a href="/Carref_Web/Depart/Home" class="nav-link">Departements</a></li>
                                <li><a href="Home" class="nav-link">Employes</a></li>
                                        
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employes</h3>
			<hr>
			<div class="container text-left">

				<a href="Add" class="btn btn-success">Add New Employe</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Emp-Name</th>
                                                <th>salaire</th>
						<th>Departement</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Emp" items="${Emps}">
						<tr>
                                                   
                                                    <td name = "idEmp"><c:out value="${Emp.idEmp}" /></td>
							<td name="EmpName"><c:out value="${Emp.nom}" /></td>
                                                        <td name = "salaire"><c:out value="${Emp.salaire}" /></td>
                                                        <td name = "refDept"><c:out value="${Emp.refDept.nom}" /></td>
							<td><a href="Updateb?idEmp=<c:out value="${Emp.idEmp}" />&EmpName=<c:out value="${Emp.nom}" />&salaire=<c:out value="${Emp.salaire}" />&refDept=<c:out value="${Emp.refDept}" />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="Delete?idEmp=<c:out value="${Emp.idEmp}" />">Delete</a></td>
						</tr>
					</c:forEach>     
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>

