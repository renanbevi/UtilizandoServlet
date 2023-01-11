<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<!DOCTYPE html>
	
	<meta charset="ISO-8859-1>">
	<head>
		<title> Java Standard Taglibs</title>
	</head>
		<body>
	Lista de empresas </br>
		
		
		<ul>
			<c:forEach items="${empresas}" var="empresa">	 
				
				<li> 
					Empresa:  ${empresa.nome} - CNPJ: ${empresa.cnpj} - Data de Abertura: <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/YYYY"/>
				<a href="/gerenciador/removeEmpresa?id=${empresa.id}">Remove</a>
				</li>
			</c:forEach>	
									
		</ul>
		
		 </body>
</html>