<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkServletNovoCliente"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    
	<form action="${linkServletNovoCliente}" method="post"> 
	
		<label> Cliente:</label> 
			<input type="text" name="nome" value="${cliente.nome}" />
		<label> Sexo:</label> 
			<input type="text" name="sexo" value="${cliente.sexo}"/>
			<label> Valor cobrado:</label> 
			<input type="text" name="valor" value="${cliente.valor}"/>
			<label> Serviço::</label> 
			<input type="text" name="servico" value="${cliente.servico}"/>
			<label> Data cadastro:</label>
			<input type="text" name="data" value="<fmt:formatDate value="${cliente.dataMarcada}" pattern="dd/MM/YYYY"/>" />
			<label> Id</label>
			<input type="hidden" name="id" value="${cliente.id}" />	
			<input type="hidden" name="acao" value="alteraCliente" />
				
									
			<input type="submit" />
	</form>

</body>
</html>