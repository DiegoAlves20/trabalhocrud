<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
tr,td{
text-align: center;
}

tr{
background-color:#f9d29d;
width:70px;
height:40px;
}
td{
background-color:#427aaa;
color:white;
width:100px;
height:50px;
}
.a1{
	text-decoration:none;
	font-size:24px;
	color:#e67e22;
}
.a2{
	text-decoration:none;
	font-size:24px;
	color:#fc5c65;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="font-family:sans-serif;">

	<h1><span style="color:#427AAA;">Tabela </span>de Informações</h1>
	
	<table border="1">
		<tr>
		
			<th>Id</th>
			<th>Nome</th>
			<th>Cep</th>
			<th>Rua</th>
			<th>Numero</th>
			<th>Cidade</th>
			<th>Estado</th>
			<th>Telefone</th>
			<th>Celular</th>
			<th>Data Nasc</th>
			<th>Genero</th>
			<th>Email</th>
			<th>Prod. Interesse</th>
			<th>Idade</th>
			 <th>Ver +</th>
			<th>Excluir</th> 
			
		</tr>
		
		 
	<c:forEach items="${usuarios }" var="u">
		<tr>
			<td>${u.id}</td>
			<td>${u.nome}</td>
			<td>${u.cep }</td>
			<td>${u.rua }</td>
			<td>${u.numero }</td>
			<td>${u.cidade }</td>
			<td>${u.estado }</td>
			<td>${u.telefone }</td>
			<td>${u.celular }</td>
			<td><fmt:formatDate value="${u.dataNasc.time }" pattern="dd/MM/yyyy"/> </td>
			<td>${u.genero }</td>
			<td>${u.email }</td>
			<td>${u.prodInteresse }</td>
				<td>${u.idade }</td>
			 <td><a href="alterarUsuario?idUsuario=${u.id }" class="a1">ver +</a></td>
				<td><a href="excluirUsuario?idUsuario=${u.id }"
				onclick="return confirm(´confirmar exclusão do usuario? ${u.nome}?')" class="a2">Jogar Fora</a></td> 
		</tr>
	
	</c:forEach>
	
	

		
</body>
</html>