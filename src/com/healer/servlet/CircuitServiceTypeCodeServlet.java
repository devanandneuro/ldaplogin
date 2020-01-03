package com.healer.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healer.services.CircuitServiceTypeCodeService;

/**
 * Servlet implementation class CircuitServiceTypeCodeServlet
 */
@WebServlet("/CircuitServiceTypeCodeServlet")
public class CircuitServiceTypeCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CircuitServiceTypeCodeServlet() {
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
		System.out.println("Inside svctype servlet");
		String OrderNumber = request.getParameter("orderid");
		System.out.println("OrderNumber - "+OrderNumber);
		String Circuit = request.getParameter("circuitid");
		System.out.println("Circuit - "+Circuit);
		String Svctypecode = request.getParameter("svcTypeCode");
		System.out.println("Svctypecode - "+Svctypecode);
		CircuitServiceTypeCodeService cktservicetypecode = new CircuitServiceTypeCodeService();
		String outmsg = null;
		try {
			outmsg = cktservicetypecode.svctypecodeupdate(OrderNumber,Circuit,Svctypecode);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Servicetype outmsg - "+outmsg);
		request.setAttribute("ReturnMsg", outmsg);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/CircuitServiceTypeCode.jsp");
		dispatcher.forward(request, response);
	}

}
