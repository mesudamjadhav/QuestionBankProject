<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<script src="resources/js/application.js" type="text/javascript"></script>

<link href="resources/jQuery/jquery-ui.css" rel="stylesheet">
<link href="resources/jQuery/jquery-ui.theme.css" rel="stylesheet">
<link href="resources/jQuery/jquery-ui.structure.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="resources/jqGrid/ui.jqgrid.css">

<script src="resources/jQuery/jquery.min.js"></script>
<script src="resources/jQuery/jquery-ui.js"></script>
<title>Question</title>
</head>
<body>
	<div class="container">
		<div class="cont-class">
			<div class="row headr-row">
				<div class="head">
					<h3>ADD NEW CALL</h3>
				</div>
				<div class="data" id="dataContainer"></div>
				
				<div class="row ">
					<div class="add-new">
						<a onclick="callForAddNewQuestion();">+ ADD NEW QUESTION</a>
					</div>
				</div>


				<div class="row ">
					<div class="save-button-row">
						<button type="button" class="btn btn-primary" onclick="getAllElementsFromDiv()">Save</button>
						<button type="button" class="btn btn-light">Cancel</button>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
</html>