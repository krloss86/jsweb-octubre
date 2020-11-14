<!-- marcado: presentar informacion por medio de tags -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>


<html>
	<!-- css, js -->
	<head>
		<title>Clase10 - Formulario HTML de login </title>
	</head>
	<!-- usuario ve en la patnalla -->
	<body>
		<h1>
			<%
				Date fechaHoy = new Date();
		 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 		String fecha = sdf.format(fechaHoy);
			%>
			<%=fecha%>
		</h1>
		<form 
			action="<%=request.getContextPath()%>/LoginServlet"
			method="post"
			>
			<table>		
				<tr>
					<td>
						User
					</td>
					<td>
						<input type="text" name="user">
					</td>
				</tr>
				<tr>
					<td>
						Pass
					</td>
					<td>
						<input type="password" name="pass">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Login">
					</td>
				</tr>
			</table>
		</form>		
	</body>
</html>