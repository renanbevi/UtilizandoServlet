<%

//scriptlet
String nomeEmpresa = (String)request.getAttribute("empresa");
System.out.println(nomeEmpresa);

%>

<html>
<body>
<h1> Login efetuado com sucesso ! Empresa " <%= nomeEmpresa %> " </h1> 

</body>

</html>

