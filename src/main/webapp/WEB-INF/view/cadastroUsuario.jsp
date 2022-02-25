<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario | Cadastro de Usuario</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Reem+Kufi&display=swap" rel="stylesheet">
<style>
	*{
	margin:0px;
	padding:0px;
	box-sizing: border-box;
	
	
	}
	body{
	background-color: #f9d29d;
	background-image: linear-gradient(315deg, #f9d29d 0%, #ffd8cb 74%);
	font-family: 'Reem Kufi', sans-serif;
	}
	.principal{
	
	display:relative;
	padding:10px;
	width:600px;
	Margin:0 auto;
	margin-top:30px;
	background: rgba( 255, 255, 255, 0.25 );
	box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
	backdrop-filter: blur( 4px );
	-webkit-backdrop-filter: blur( 4px );
	border-radius: 10px;
	border: 2px solid rgba( 255, 255, 255, 0.18 );
	
	}
	h1{
	text-align: center;
	}
	form{
	display:inline-block;
	margin: 20px;
	background-color:none;
	}
	input{
	width:500px;
	height:40px;
	margin:10px;
	border-radius:6px;
	border: 2px solid #427AAA;
	background: rgba( 255, 255, 255, 0.25 );
	outline: none;
	}
	input[type=number]::-webkit-inner-spin-button { 
    -webkit-appearance: none;
    
}
   input[type=number] { 
   -moz-appearance: textfield;
   appearance: textfield;

}

	textarea{
	resize: none;
	width: 500px;
	margin:10px;
	border-radius: 8px;
	border: 4px solid #427AAA;
	outline: none;
	background: rgba( 255, 255, 255, 0.25 );
}
	
	
	button{
	position:relative;
	margin-left:150px;
	width:250px;
	height:25px;
	border-radius:16px;
	border: 2px solid #ED7A11;
	background-color: #ED7A11;
	color: white;
	cursor: pointer;
	}
	button:hover{
	transform: scale(1.3);
	}
	.radio{
	display:inline;
	height:15px;
	width:15px;
	}
	
</style>
</head>
<body>
<div class="principal">
	<h1>Cadastro de Usuario</h1>
	<form action="enviar" method="post">
	
	<label>Nome</label>
	<input type="text" name="nome" value="${usuario.nome }" required="required" title="Informe o nome completo">

	
	CEP: <input type="number" name="cep" value="${usuario.cep }" required="required">
	Rua: <input type="text" name="rua" value="${usuario.rua }" required="required">
	N°: <input type="number" name="numero" value="${usuario.numero}" required="required">
	Cidade: <input type="text" name="cidade" value="${ usuario.cidade}" required="required">
	Estado: <input type="text" name="estado" value="${usuario.estado }" required="required">
	Telefone: <input type="number" name="telefone" value="${usuario.telefone }">
	Celular: <input type="number" name="celular" value="${usuario.celular }" required="required">
	Data nascimento: <input type="date" name="dataNasc" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${usuario.dataNasc.time }"/>" required="required">
	
	<label>Genero:</label><br>
	Feminino<input type="radio" name="genero"  <c:if test="${usuario.genero.equals('feminino') }">checked</c:if> value="feminino" class="radio" /> 
	Masculino<input type="radio" name="genero" <c:if test="${usuario.genero.equals('masculino') }">checked</c:if>  value="masculino" class="radio" />
	<br>
	<label>E-mail</label>
	<input type="email" name="email" value="${ usuario.email}" required="required">
	
	
	<label>Produtos de interesse</label>
	<textarea rows="5" cols="100" name="prodInteresse" required="required">${usuario.prodInteresse }</textarea>
	
	<button type="submit" name="enviar" value="enviar">Enviar</button>

	</form>
</div>
</body>
</html>