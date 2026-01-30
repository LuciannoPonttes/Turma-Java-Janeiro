<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    
<%@ page import="java.util.List" %>
<%@ page import="model.Atendente" %>    
    
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
	
	

	<h3>LISTA DE ATENDENTES</h3>
	
	<table border="1" cellpadding="5">
			<tr>
				<th>CPF</th>
				<th>NOME</th>
				<th>SETOR</th>
				<th>ACOES</th>
			</tr>

			<%
				List<Atendente> lista = (List<Atendente>) request.getAttribute("listaAtendentes");// Busca a lista de Atendentes na memoria do servidor(request)
	
				if (lista != null) {
					for (Atendente atendente : lista) {
			%>
				<tr>
					<td><%= atendente.getCpf() %></td>
					<td><%= atendente.getNome() %></td>
					<td><%= atendente.getSetor() %></td>
					<td>
						<form method="get" action="<%= request.getContextPath() %>/AtendenteController"
							style="display:inline;">
							<input type="hidden" name="acao" value="deletar" >
							<input type="hidden" name="cpf" value="<%= atendente.getCpf()%>">
							<button type="submit" onclick="return confirm('Tem certeza que deseja deletar?');">
								Deletar
							</button>
						
						
						
						
						</form>
						
					</td>
				</tr>
			<%
				}
			}
		%>
	</table>
	

</body>
</html>