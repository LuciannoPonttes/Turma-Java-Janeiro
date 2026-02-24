<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<h2>Login do Sistema de Cadastro de Funcionario</h2>
	
	<form method="post" action="<%= request.getContextPath() %>/LoginController" >
		<label>USUARIO:</label>
		<input type="text" name="cpf"><br><br>
		
		<label>SENHA:</label>
		<input type="password" name="senha"><br><br>
		
		 <button type="submit">Entrar</button> 
	
	
	
	
	</form>

</body>
</html>