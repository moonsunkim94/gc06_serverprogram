<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MVC2 JSP MemberList **</title>
<style type = "text/css">
	tr {
		color : "blue";
	}
	body{
		text-align:"center";
	}
</style>
</head>
<body>

<h3>** member 테이블  **</h3>
<table width = 800 border="1">
<tr align = "center" height = 30 bgcolor="skyblue">
	<td>ID</td><td>Password</td><td>Name</td>
	<td>Lev</td><td>BirthDay</td><td>Pay</td>
	<td>Weight</td>
</tr>
<c:forEach var="mm" items="${banana}">
	<tr>
		<td>${mm.id}</td><td>${mm.password}</td><td>${mm.name}</td>
		<td>${mm.lev}</td><td>${mm.birthd}</td><td>${mm.pay}</td>
		<td>${mm.weight}</td>	
	</tr>
</c:forEach>
</table>

</body>
</html>