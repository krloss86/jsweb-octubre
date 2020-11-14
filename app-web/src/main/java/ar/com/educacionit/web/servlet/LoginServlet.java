package ar.com.educacionit.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.service.LoginService;
import ar.com.educacionit.service.LoginServiceImpl;
import ar.com.educacionit.service.exceptions.ServiceException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//obtener los parametros que se enviaron desde el cliente, por medio del formulario
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		//ACCEDER A LA DB POR MEDIO DE ????
		//TDD
		LoginService ls = new LoginServiceImpl();
		
		String target = "loginOk.jsp";
		
		try {
			User userEntity = ls.getUserByUserName(user);
			
			if(userEntity != null && userEntity.getPassword().equals(pass)) {
				//guardar en el request al usuario obtenido desde la db
				// para mostrar luego en loginOk.jsp su informacion
				request.setAttribute("usuario", userEntity);
			}else {
				target = "loginFail.jsp";
				request.setAttribute("mensajeError", "Usuario/Password Inválido");
			}
		}catch (ServiceException e) {
			target = "loginFail.jsp";
			request.setAttribute("mensajeError", e.getMessage());
		}		
		
		//redireccion por medio de RequestDispatcher
		RequestDispatcher macherano = getServletContext().getRequestDispatcher("/"+target);
		macherano.forward(request, response);		
	}

}
