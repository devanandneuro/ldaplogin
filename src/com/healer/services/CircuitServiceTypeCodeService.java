package com.healer.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CircuitServiceTypeCodeService {
	/*public String cktremove(String order, String ckt) {
		String returnmsg = null;
		
		return returnmsg;
	}*/

	public String svctypecodeupdate(String orderNumber, String circuit, String svctypecode) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String returnmsg = null;
		Connection con = null;
		CallableStatement cstmt=null;
	    String dbdriver = "oracle.jdbc.driver.OracleDriver";
	        Class.forName(dbdriver);
		    String URL = "jdbc:oracle:thin:asap/asap@ex04-scan.windstream.com:1521/mts00t14";
	      	con = DriverManager.getConnection(URL);
	        try {
	        	
	        	      	String command = "{ call asapit.sp_service_type_upd(?, ?, ?, ?, ?, ?) }";
	        	      	cstmt = con.prepareCall(command);
	        	      	cstmt.registerOutParameter(5, Types.INTEGER);
	                    cstmt.registerOutParameter(6, Types.VARCHAR);
	                    cstmt.setString(1, orderNumber);
	                    cstmt.setString(2, circuit);
	                    cstmt.setString(3, svctypecode);
	                    cstmt.setString(4, "ASAP");
	                    cstmt.executeUpdate();
	                    int outcode = cstmt.getInt(5);
	                    returnmsg = cstmt.getString(6);
	                    cstmt.close();
	                    System.out.println("SvcTypeCode Outcode: " + outcode);
	                    System.out.println("SvcTypeCode Outmsg: " + returnmsg);
	        	    	 
	     	    		
	     	           
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
