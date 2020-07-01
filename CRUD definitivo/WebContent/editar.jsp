<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
${persona.getId()}
</div>
<form action="controlador" Method="POST">
id:
<input type="text" name="txtid" value="${persona.getId()}"><br>
Nombre:
<input type="text" name="txtnom" value="${persona.getNombre() }"><br>

<input type="submit" name="accion" value="actualizar">
</form>
</body>
</html>