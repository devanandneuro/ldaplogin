package com.healer.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BusinessServlet
 */
@WebServlet("/BusinessServlet")
public class BusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessServlet() {
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
		String order_no = request.getParameter("OrderNumber");
		Connection conn = null;
	       Statement stmt=null;
	       ResultSet vrs=null;
	        int docnum = 0;
	        String dbdriver = "oracle.jdbc.driver.OracleDriver";
	        try {
	        	 Class.forName(dbdriver);
	        	String URL = "jdbc:oracle:thin:asap/asap@ex04-scan.windstream.com:1521:mscn10";
	        	 conn = DriverManager.getConnection(URL);
	        	  		stmt = conn.createStatement(); 
	     	    		vrs = stmt.executeQuery("select document_number from serv_req WHERE order_number='"+order_no+"'") ;  
	     	    		while(vrs.next())
	     	            {
	     	            	docnum=vrs.getInt(1);
	     	            	
	     	            } 
	     	           
	        }catch(Exception e) {
	        	
	        }
	        finally
			{
				try {
					
					conn.close();
					vrs.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	        request.setAttribute("DocNum",docnum);
	          request.setAttribute("OrdNum",order_no);
	  		RequestDispatcher dispatcher = request.getRequestDispatcher("/DDFix.jsp");
	          dispatcher.forward(request, response);
	  		 return;
		
	}

}
