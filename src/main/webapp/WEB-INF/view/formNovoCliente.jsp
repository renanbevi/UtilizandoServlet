<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletNovoCliente"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>s
<c:import url="LogoutParcial.jsp"/>
<br>
<br>

    
	<form action="${linkServletNovoCliente}" method="post"> 
		<label> Cliente:</label> 
			<input type="text" name="nome" />
		<label> Sexo:</label> 
			<input type="text" name="sexo" />
			<label> Valor cobrado:</label> 
			<input type="text" name="valor" />
			<label> Serviço:</label> 
			<input type="text" name="servico" />
			<label> Data cadastro:</label> 
			<input id="date" type="data" name="data" />
			<input type="hidden" name="acao" value="NovoCliente" />
			
										
			<input type="submit" />
	</form>

</body>
</html>