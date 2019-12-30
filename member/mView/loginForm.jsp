<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Login Form **</title>
</head>
<body>
<center>
<form action="/06_ServerProgram_portfolio/login" method="post">

<table>

<tr>
	<td>I  D : </td>
	<td><input type="text" name="id" value="banana"></td>
</tr>
<tr>
	<td>P  W : </td>
	<td><input type="password" name="password"></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" value="login"> &nbsp;
		<input type="reset" value="Reset">
	</td>
		
</tr>


</table>
</form>
</center>
</body>
</html>