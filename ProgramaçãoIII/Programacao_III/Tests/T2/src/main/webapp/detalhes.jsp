<%@ page import="java.util.Properties" %>
<%@ page import="java.awt.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalhes</title>
</head>
<body>
  <h1>Detalhes do computador (Exercico 3...)</h1>



  <p>Java Version: <%= System.getProperty("java.version")%></p>
  <p>User name: <%= System.getProperty("user.name")%></p>

    <p> <a href="exercicio3.jsp">Pagina anterior</a> </p>
</body>
</html>
