package br.mendonca.testemaven.controller;

import java.io.IOException;

import br.mendonca.testemaven.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		String resp = userDAO.teste();
		
		
		
		response.getWriter().append(resp);
		response.getWriter().append(name);
		response.getWriter().append(email);
		response.getWriter().append(pass);
	}

}
