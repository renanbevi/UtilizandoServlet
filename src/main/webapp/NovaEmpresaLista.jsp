<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
 
<!DOCTYPE html>
	
	<meta charset="ISO-8859-1>">
	<head>
		<title> Java Standard Taglibs</title>
	</head>
		<body>
	Lista de empresas </br>
		
		
		<ul>
			<c:forEach items="${empresas}" var="empresa">	 
				<li> ${empresa.nome} </li>
			</c:forEach>	
			
			<d:forEach items="${cnpj}" var="cnpj">
			<li> ${empresa.cnpj} </li>
			</d:forEach>
			
		</ul>
		
		 </body>
</html>