package com.healer.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healer.services.BusinessService;
//import com.security.AuthenticationServices;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		boolean verifyuser = false;
		String userName = request.getParameter("username");
		String password = request.getParameter("pass");
		String msg = null;
		HttpSession session = request.getSession(false);
		BusinessService busServ = new BusinessService();
		String displayName = null;

				try {
					displayName = busServ.DisplayName(userName);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		session.setAttribute("UserName", userName);
		session.setAttribute("DisplayName", displayName);
		//AuthenticateUser au = new AuthenticateUser();
		//verifyuser = au.authentication(userName, password);
		AuthenticationServices authServ = new AuthenticationServices();
		boolean auth = false;
		try {
			auth = authServ.ldapCSOAuthentication(userName, password);
			System.out.println("auth - "+auth);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Login Controller user validation auth exc - "+e.getMessage());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (auth) {
			request.setAttribute("DN", displayName);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/HealerMainPage.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("Msg", "Invalid Credentials");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/HealerLogin.jsp");
			dispatcher.forward(request, response);
		}
		
		
		return;
	}

}
