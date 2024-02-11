<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercicio 3</title>
</head>
<body>
  <h3>Exercicio 3</h3>

  <%
    LocalDateTime dateTime = LocalDateTime.now();
    int dia = dateTime.getDayOfMonth();
    int mes = dateTime.getMonthValue();
    int ano = dateTime.getYear();
  %>

  <table style="background: yellow" cellspacing="7">
    <thead>
      <th>Dia</th>
      <th>Mes</th>
      <th>Ano</th>
    </thead>
    <tbody>
      <tr>
        <td><%=dia%></td>
        <td><%=mes%></td>
        <td><%=ano%></td>
      </tr>
    </tbody>
  </table >

  <p> <a href="detalhes.jsp" >Pagina de detalhes </a></p>
</body>
</html>
