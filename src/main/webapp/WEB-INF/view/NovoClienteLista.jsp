<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<!DOCTYPE html>
	
	<meta charset="ISO-8859-1>">
	<head>
		<title> Java Standard Taglibs</title>
	</head>
		<body>
			<c:import url="LogoutParcial.jsp"/>
		<br>
		<br>
		<br>
		<br>
		Usuário logado: ${usuarioLogado.login}
		<br>
		<br>
		
	Lista de empresas </br>
		
		
		<ul>
			<c:forEach items="${clientes}" var="cliente">	 
				
				<li> 
					Cliente:  ${cliente.nome} - Sexo: ${cliente.sexo} - Valor: ${cliente.valor} - Serviço: ${cliente.servico} - Data de cadastro: <fmt:formatDate value="${cliente.dataMarcada}" pattern="dd/MM/YYYY"/>
				<a href="/gerenciador/entrada?acao=MostraCliente&id=${cliente.id}">Editar</a>
				<a href="/gerenciador/entrada?acao=RemoveCliente&id=${cliente.id}">Remover</a>
				</li>
			</c:forEach>	
									
		</ul>
		
		 </body>
</html>