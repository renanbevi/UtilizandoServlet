<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    
	<form action="/gerenciador/novaEmpresa" method="post"> 
		<label> Empresa:</label> 
			<input type="text" name="empresa" />
		<label> CNPJ:</label> 
			<input type="text" name="cnpj" />
			<label> Data Abertura:</label> 
			<input type="text" name="data" />
										
			<input type="submit" />
	</form>

</body>
</html>