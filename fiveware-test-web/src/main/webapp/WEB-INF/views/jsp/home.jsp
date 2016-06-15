<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>fiveware test</title>

<c:url var="home" value="/" scope="request" />

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

<spring:url value="/resources/core/js/jquery.1.10.2.min.js"	var="jqueryJs" />
<script src="${jqueryJs}"></script>
</head>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">FIVEWARE TEST</a>
		</div>
	</div>
</nav>

<div class="container" style="min-height: 500px">

	<div class="starter-template">
		<h1 align="center">Formulário de Cadastro</h1>
		<br>

		<div id="feedback"></div>

		<form class="form-horizontal" id="cad-form">
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Nome</label>
				<div class="col-sm-10">
					<input type=text class="form-control" id="nome" placeholder="Digite o seu nome">
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Escolaridade</label>
				<div class="col-sm-10">
					<select class="form-control" id="escolaridade" name="escolaridade">
					  <option value="Primeiro Grau" selected="selected">Primeiro Grau</option>
					  <option value="Segundo Grau">Segundo Grau</option>
					  <option value="Curso Superior">Curso Superior</option>
					  <option value="Pós Graduação">Pós Graduação</option>
					</select>					
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Sexo</label>
				<div class="col-sm-10">
					<label class="radio-inline input-lg"><input type="radio" name="sexo" id="sexo" value="M" checked><strong>Masculino</strong></label>
					&nbsp;&nbsp;
					<label class="radio-inline input-lg"><input type="radio" name="sexo" id="sexo" value="F"><strong>Feminino</strong></label>					
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<label class="radio-inline input-lg"><input type="checkbox" name="optin" id="optin" value="S">&nbsp;&nbsp;<strong>Desejo receber mensagens</strong></label>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="btn-cad" class="btn btn-primary btn-lg">Cadastrar Usuário</button>
				</div>
			</div>
		</form>

	</div>

</div>

<script>
	jQuery(document).ready(function($) {

		$("#cad-form").submit(function(event) {

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			cadViaAjax();

		});
		
		$("#btn-cad").click(function(){
			// Disble the search button
			disableCadButton(true);	
		});

	});

	function cadViaAjax() {

		var cad = {}
		cad["nome"] = $("#nome").val();
		cad["sexo"] = $("#sexo").val();
		cad["escolaridade"] = $("#escolaridade").val();
		
		if ($('optin').prop('checked')) {
			cad["optin"] = "S";
		} else {
			cad["optin"] = "N";
		}

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}newPerson",
			data : JSON.stringify(cad),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
				$("#cad-form").get(0).reset();
				disableCadButton(false);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				disableCadButton(false);
			}
		});

	}

	function disableCadButton(flag) {
		$("#btn-cad").prop("disabled", flag);
	}

	function display(data) {
		var json = "<pre>" + JSON.stringify(data, null, 4) + "</pre>";
		$('#feedback').html(json);
	}
</script>

</body>
</html>