
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercicio 02</title>
</head>
<body>

  <h1>Exercicio 2</h1>
  <%!
    int somaIntervaloPares(int numero){
      int soma = 0;
      for(int i = 0; i <= numero; i ++){
        if(i%2 == 0){
          soma += i;
        }
      }
      return soma;
    }
  %>

  <h3>Soma de numero pares até 500</h3>

  <p>A soma de numeros pares até 500 é : <strong><%= somaIntervaloPares(500)%></strong> </p>

</body>
</html>
