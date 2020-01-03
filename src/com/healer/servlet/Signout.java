package com.healer.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signout
 */

public class Signout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signout() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession(true);
		//String UserName = (String) session.getAttribute("UserName");
		//System.out.println("UserName - " + UserName);
		//request.getSession().invalidate();
		//String UserName1 = (String) session.getAttribute("UserName");
		//System.out.println("UserName after session invalidate- " + UserName);
		//response.sendRedirect(request.getContextPath() + "/Login.jsp");
		System.out.println("Signout Servlet");
		HttpSession session = request.getSession(true);
		if(session != null)
		    session.invalidate();
		request.getRequestDispatcher("/HealerLogin.jsp").forward(request,response);
	}

}
