package com.healer.servlet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CircuitRemovalService {
	/*public String cktremove(String order, String ckt) {
		String returnmsg = null;
		
		return returnmsg;
	}*/

	public String cktremove(String orderNumber, String circuit) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String returnmsg = null;
		Connection con = null;
		CallableStatement cstmt=null;
	    String dbdriver = "oracle.jdbc.driver.OracleDriver";
	        Class.forName(dbdriver);
		    String URL = "jdbc:oracle:thin:asap/asap@ex05-scan.windstream.com:1521/msnn03.windstream.com";
	      	con = DriverManager.getConnection(URL);
	        try {
	        	
	        	      	String command = "{ call asapit.sp_isr_circuit_remove(?, ?, ?, ?, ?) }";
	        	      	cstmt = con.prepareCall(command);
	        	      	cstmt.registerOutParameter(4, Types.INTEGER);
	                    cstmt.registerOutParameter(5, Types.VARCHAR);
	                    cstmt.setString(1, orderNumber);
	                    cstmt.setString(2, circuit);
	                    cstmt.setString(3, "ASAP");
	                    cstmt.executeUpdate();
	                    int outcode = cstmt.getInt(4);
	                    returnmsg = cstmt.getString(5);
	                    cstmt.close();
	                    System.out.println("CktRemoval Outcode: " + outcode);
	                    System.out.println("CktRemoval Outmsg: " + returnmsg);
	        	    	 
	     	    		
	     	           
	        }catch(Exception e) {
	        	
	        }
	        finally
			{
				try {
					
					con.close();
					//vrs.close();
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
	
		return returnmsg;
	}
}
