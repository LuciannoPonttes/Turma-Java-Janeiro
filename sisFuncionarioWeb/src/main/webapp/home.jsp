<%@page import="model.Atendente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<% 
		Atendente usuario = (Atendente)session.getAttribute("usuarioLogado");
		
	
	
		if(usuario == null){
			response.sendRedirect("login.jsp");
			return;
			
		}
	
	%>
	
	
	<h2>Bem-vindo, <%= usuario.getNome() %> - <%= usuario.getCpf() %>  </h2>
	</head>
	<body>
	
	<h3>MENU</h3>
		<li>
			<a href="<%= request.getContextPath() %>/AtendenteController">
				Gerenciar Atendentes
			
			</a>
		</li>
		<li>
			
			<a href="<%= request.getContextPath() %>/GerenteController">
				Gerenciar Gerentes
			
			</a>
		
		</li>
		
		<a href="<%= request.getContextPath() %>/LoginController">Sair</a>
		
		
	
	</body>
</html>