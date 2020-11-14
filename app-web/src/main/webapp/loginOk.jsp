<%@page import="ar.com.educacionit.domain.User"%>

<%
    //objetos implicitos
    //request
    //response
    //pageContext
    //out
	User usuarioGuardadoEnElServlet = (User)request.getAttribute("usuario");
%>

<html>

	<head>
	
	</head>
	
	<body>
		<h1>Datos del Usuario Logueado</h1>
		<h2>Usuario: <%=usuarioGuardadoEnElServlet.getUsername() %> </h2>
		<h3>ID: <%=usuarioGuardadoEnElServlet.getId() %></h3>
	</body>
</html>