<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="model.Gerente" %>  
<%@ page import="model.Atendente" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Gerente</title>
</head>
<body>

	<% 
		Atendente usuario = (Atendente)session.getAttribute("usuarioLogado");
		if(usuario == null){
			response.sendRedirect("login.jsp");
			return;
			
		}
	
	%>
	<h2>Bem-vindo, <%= usuario.getNome() %>!</h2>

	<h2>GERENTE CRUD</h2>
	
	<form method="post" action="<%= request.getContextPath() %>/GerenteController">
		<label>DIGITE O CPF:</label><br>
        <input type="text" name="cpf" required><br>
        
        <label>DIGITE O NOME:</label><br>
        <input type="text" name="nome" required><br>
        
         <label>DIGITE A GERÊNCIA:</label><br>
        <input type="text" name="gerencia" required><br>
        
        
        
        <br><br>
        <button type="submit">Enviar</button>
	
	
	
	</form>
	
	<br>
	
	<h3>LISTA DE ATENDENTES</h3>
	
	<table border="1" cellpadding="5">
			<tr>
				<th>CPF</th>
				<th>NOME</th>
				<th>GERENCIA</th>
				<th>ACAO</th>
			</tr>

			<%
				List<Gerente> lista = (List<Gerente>) request.getAttribute("listaGerentes");// Busca a lista de Atendentes na memoria do servidor(request)
	
				if (lista != null) {
					for (Gerente gerente : lista) {
			%>
				<tr>
					<td><%= gerente.getCpf() %></td>
					<td><%= gerente.getNome() %></td>
					<td><%= gerente.getGerencia() %></td>
					<td>
						<form method="get" action="<%= request.getContextPath() %>/GerenteController"
							style="display:inline;">
							<input type="hidden" name="acao" value="deletar">
							<input type="hidden" name="cpf" value=<%= gerente.getCpf()%>>
							
							<button type="submit" onclick="return confirm('Tem certeza que deseja deletar?');">
								deletar
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