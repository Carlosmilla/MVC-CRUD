<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h3>Personas</h3>
		<form action = "controlador" method = "POST">
		<input type="submit" name="accion" value="listar">
		<input type="submit" name="accion" value="nuevo">
		</form>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOMBRES</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="datos" items="${datos}">
				<tr>
					<td>${datos.getId()}</td>
					<td>${datos.getNombre()}</td>
					<td>
					<form action="controlador" method="POST">
					<input type="hidden" name="id" value="${datos.getId()}">
					<input type="submit" name="accion" value="editar">
					<input type="submit" name="accion" value="eliminar">
					</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>