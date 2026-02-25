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
<title>Funcionario Terceirizado CRUD</title>
</head>
<body>

	<h2>Funcionario Terceirizado CRUD</h2>

	<%
		FuncionarioInterno usuario = (FuncionarioInterno) session.getAttribute("usuarioLogado");
		if (usuario == null) {
			response.sendRedirect("login.jsp");
			return;
		}
	%>

	<%
		FuncionarioTerceirizado funcionarioEdit =
			(FuncionarioTerceirizado) request.getAttribute("funcionarioEdit");

		boolean editando = (funcionarioEdit != null);
		String acaoForm = editando ? "editar" : "salvar";

		String cpfValue = editando ? funcionarioEdit.getCpf() : "";
		String matriculaValue = editando ? funcionarioEdit.getMatricula() : "";
		String nomeValue = editando ? funcionarioEdit.getNome() : "";
		String nascimentoValue = editando ? funcionarioEdit.getDatadataNascimento() : "";

		// Continua sendo String no objeto (back-end)
		String funcaoValue = editando ? funcionarioEdit.getFuncao() : "";

		String custoValue = editando ? funcionarioEdit.getCusto().toString() : "";
		String empresaValue = editando ? funcionarioEdit.getEmpresa().toString() : "";
	%>

	<h2>Bem-vindo, <%= usuario.getNome() %>!</h2>

	<form method="post" action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController">
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
		<select name="funcao" required>
			<option value="">Selecione...</option>
			<%
				for (Funcao f : Funcao.values()) {
					String descricao = f.getDescricao(); // String
					String selected = descricao.equals(funcaoValue) ? "selected" : "";
			%>
				<option value="<%= descricao %>" <%= selected %>><%= descricao %></option>
			<%
				}
			%>
		</select>
		<br><br>

		<label>DIGITE O CUSTO:</label><br>
		<input type="text" name="custo" value="<%= custoValue %>" required>
		<br><br>

		<label>DIGITE A EMPRESA:</label><br>
		<input type="text" name="empresa" value="<%= empresaValue %>" required>
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
			<th>CUSTO</th>
			<th>EMPRESA</th>
			<th>AÇÕES</th>
		</tr>

		<%
			List<FuncionarioTerceirizado> lista =
				(List<FuncionarioTerceirizado>) request.getAttribute("listaFuncionarios");

			if (lista != null) {
				for (FuncionarioTerceirizado funcionarioTerceirizado : lista) {
		%>
		<tr>
			<td><%= funcionarioTerceirizado.getCpf() %></td>
			<td><%= funcionarioTerceirizado.getMatricula() %></td>
			<td><%= funcionarioTerceirizado.getNome() %></td>
			<td><%= funcionarioTerceirizado.getDatadataNascimento() %></td>
			<td><%= funcionarioTerceirizado.getFuncao() %></td>
			<td><%= funcionarioTerceirizado.getCusto() %></td>
			<td><%= funcionarioTerceirizado.getEmpresa() %></td>

			<td>
				<form method="get" action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController"
					  style="display:inline;">
					<input type="hidden" name="acao" value="deletar">
					<input type="hidden" name="cpf" value="<%= funcionarioTerceirizado.getCpf() %>">
					<button type="submit" onclick="return confirm('Tem certeza que deseja deletar?');">
						Deletar
					</button>
				</form>

				<form method="get" action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController"
					  style="display:inline;">
					<input type="hidden" name="acao" value="editar">
					<input type="hidden" name="cpf" value="<%= funcionarioTerceirizado.getCpf() %>">
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