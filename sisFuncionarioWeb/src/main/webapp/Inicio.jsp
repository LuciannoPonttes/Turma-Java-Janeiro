<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Teste GET/POST</title>
</head>
<body style="font-family: Arial; padding: 20px;">

    <h2>Teste GET → POST</h2>

    <form method="post" action="<%= request.getContextPath() %>/Inicio">
        <label>Digite algo:</label><br>
        <input type="text" name="texto" required>
        <br><br>
        <button type="submit">Enviar</button>
    </form>

    <%
        String texto = (String) request.getAttribute("texto");
        if (texto != null) {
    %>
        <p><strong>O texto digitado foi:</strong> <%= texto %></p>
    <%
        }
    %>

</body>
</html>
