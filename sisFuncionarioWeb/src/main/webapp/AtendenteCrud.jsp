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
	
	
	<% 
		Atendente usuario = (Atendente)session.getAttribute("usuarioLogado");
		if(usuario == null){
			response.sendRedirect("login.jsp");
			return;
			
		}
	
	%>
	
	<%
		Atendente atendenteEdit = (Atendente) request.getAttribute("atendentEdit");
		boolean editando = (atendenteEdit != null);
		String acaoForm = editando ? "editar" : "salvar"; // Ternario
		
		
		String cpfValue = editando ? atendenteEdit.getCpf() : "";
		String nomeValue = editando ? atendenteEdit.getNome() : "";
		String setorValue = editando ? atendenteEdit.getSetor(): "";
		
	
	%>
	
	<h2>Bem-vindo, <%= usuario.getNome() %>!</h2>
	
	<form method="post" action="<%= request.getContextPath() %>/AtendenteController" >
		<input type="hidden" name="acao" value="<%= acaoForm %>">
		
		<label>DIGITE O CPF:</label><br>
        <input type="text" name="cpf"  <%= editando ? "readonly" : "" %>   value="<%= cpfValue %>" required><br>
        
        <label>DIGITE O NOME:</label><br>
        <input type="text" name="nome" value="<%= nomeValue %>" required><br>
        
         <label>DIGITE O SETOR:</label><br>
        <input type="text" name="setor" value="<%= setorValue %>" required><br>
        
        
        
        
        <br><br>
        <button type="submit"><%= editando ? "Alterar" : "Salvar" %></button>
	
	
	
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
						
						<form method="get" action="<%= request.getContextPath() %>/AtendenteController"
							style="display:inline;">
							<input type="hidden" name="acao" value="editar" >
							<input type="hidden" name="cpf" value="<%= atendente.getCpf()%>">
							<button type="submit" >
								Editar
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