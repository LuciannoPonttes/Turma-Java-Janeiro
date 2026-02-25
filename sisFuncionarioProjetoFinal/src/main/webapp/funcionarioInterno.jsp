<%@page import="model.Cargo"%>
<%@page import="model.FuncionarioInterno"%>
<%@page import="model.FuncionarioTerceirizado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Funcao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funcionario INTERNO CRUD</title>
</head>
<body>

	<h2>Funcionario INTERNO CRUD</h2>

	<%
		FuncionarioInterno usuario = (FuncionarioInterno) session.getAttribute("usuarioLogado");
		if (usuario == null) {
			response.sendRedirect("login.jsp");
			return;
		}
	%>

	<%
		FuncionarioInterno funcionarioEdit =
			(FuncionarioInterno) request.getAttribute("funcionarioEdit");

		boolean editando = (funcionarioEdit != null);
		String acaoForm = editando ? "editar" : "salvar";

		String cpfValue = editando ? funcionarioEdit.getCpf() : "";
		String matriculaValue = editando ? funcionarioEdit.getMatricula() : "";
		String nomeValue = editando ? funcionarioEdit.getNome() : "";
		String nascimentoValue = editando ? funcionarioEdit.getDatadataNascimento() : "";

		// Continua sendo String no objeto (back-end)
		String cargoValue = editando ? funcionarioEdit.getCargo() : "";

		String salarioValue = editando ? funcionarioEdit.getSalario().toString() : "";
		
	%>

	<h2>Bem-vindo, <%= usuario.getNome() %>!</h2>

	<form method="post" action="<%= request.getContextPath() %>/FuncionarioInternoController">
		<input type="hidden" name="acao" value="<%= acaoForm %>">

		<label>DIGITE O CPF:</label><br>
		<input type="text" name="cpf" <%= editando ? "readonly" : "" %> value="<%= cpfValue %>" required>
		<br><br>

		<label>DIGITE A MATRÍCULA:</label><br>
		<input type="text" name="matricula" value="<%= matriculaValue %>" required>
		<br><br>

		<label>DIGITE O NOME:</label><br>
		<input type="text" name="nome" value="<%= nomeValue %>" required>
		<br><br>

		<label>DATA DE NASCIMENTO:</label><br>
		<input type="text" name="nascimento" value="<%= nascimentoValue %>" required>
		<br><br>

		<label>DIGITE A FUNÇÃO:</label><br>
		<!-- Aqui usa o enum SÓ no front; o value enviado continua sendo String (descricao) -->
		
		<select name="cargo" required>
			<option value="">Selecione...</option>
			<%
				for (Cargo c : Cargo.values()) {
					String descricao = c.getDescricao(); // String
					String selected = descricao.equals(cargoValue) ? "selected" : "";
			%>
				<option value="<%= descricao %>" <%= selected %>><%= descricao %></option>
			<%
				}
			%>
		</select>
		
		
		<br><br>

		<label>DIGITE O SALARIO:</label><br>
		<input type="text" name="salario" value="<%= salarioValue %>" required>
		<br><br>

		

		<button type="submit"><%= editando ? "Alterar" : "Salvar" %></button>
	</form>

	<h3>LISTA DE FUNCIONÁRIOS TERCEIRIZADOS</h3>

	<table border="1" cellpadding="5">
		<tr>
			<th>CPF</th>
			<th>MATRÍCULA</th>
			<th>NOME</th>
			<th>DATA NASC.</th>
			<th>FUNÇÃO</th>
			<th>CARGO</th>
			<th>SALARIO</th>
			<th>ACAO</th>
		</tr>

		<%
			List<FuncionarioInterno> lista =
				(List<FuncionarioInterno>) request.getAttribute("listaFuncionarios");

			if (lista != null) {
				for (FuncionarioInterno funcionario : lista) {
		%>
		<tr>
			<td><%= funcionario.getCpf() %></td>
			<td><%= funcionario.getMatricula() %></td>
			<td><%= funcionario.getNome() %></td>
			<td><%= funcionario.getDatadataNascimento() %></td>
			<td><%= funcionario.getCargo() %></td>
			<td><%= funcionario.getSalario() %></td>
			<td><%= funcionario.getPlr() %></td>

			<td>
				<form method="get" action="<%= request.getContextPath() %>/FuncionarioInternoController"
					  style="display:inline;">
					<input type="hidden" name="acao" value="deletar">
					<input type="hidden" name="cpf" value="<%= funcionario.getCpf() %>">
					<button type="submit" onclick="return confirm('Tem certeza que deseja deletar?');">
						Deletar
					</button>
				</form>

				<form method="get" action="<%= request.getContextPath() %>/FuncionarioInternoController"
					  style="display:inline;">
					<input type="hidden" name="acao" value="editar">
					<input type="hidden" name="cpf" value="<%= funcionario.getCpf() %>">
					<button type="submit">
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