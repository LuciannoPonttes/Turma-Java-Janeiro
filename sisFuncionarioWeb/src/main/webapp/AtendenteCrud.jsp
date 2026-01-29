<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ATENDENTE CRUD</title>
</head>
<body>

	<h2>ATENDENTE CRUD</h2>
	
	<form method="post" action="<%= request.getContextPath() %>/AtendenteController">
		<label>DIGITE O CPF:</label><br>
        <input type="text" name="cpf" required><br>
        
        <label>DIGITE O NOME:</label><br>
        <input type="text" name="nome" required><br>
        
         <label>DIGITE O SETOR:</label><br>
        <input type="text" name="setor" required><br>
        
        
        
        <br><br>
        <button type="submit">Enviar</button>
	
	
	
	</form>

</body>
</html>