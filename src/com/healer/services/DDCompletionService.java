package com.healer.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class DDCompletionService {
	public String ddComplete(String orderNumber) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String ddreturnmsg = null;
		Connection con = null;
		CallableStatement cstmt=null;
	    String dbdriver = "oracle.jdbc.driver.OracleDriver";
	        Class.forName(dbdriver);
		    String URL = "jdbc:oracle:thin:asap/asap@ex05-scan.windstream.com:1521/msnn03.windstream.com";
	      	con = DriverManager.getConnection(URL);
	        try {
	        	
	        	      	
	        	      	String command = "{ call asapit.pkg_mss_auto_heal.mss_auto_heal_main(?, ?, ?, ?, ?, ?) }";
	        	      	/*String plsql = "DECLARE" + 
	        	      			"  return_code NUMBER;" + 
	        	      			"  return_text VARCHAR2(200);" + 
	        	      			"BEGIN" + 
	        	      			"  asapit.sp_isr_circuit_remove ( '?', '?', '?', return_code, return_text );" + 
	        	      			"END;";*/
	        	      	cstmt = con.prepareCall(command);
	        	      	cstmt.registerOutParameter(5, Types.INTEGER);
	                    cstmt.registerOutParameter(6, Types.VARCHAR);
	                    cstmt.setString(1, "NGMSS");
	                    cstmt.setString(2, orderNumber);
	                    cstmt.setString(3, "DD");
	                    cstmt.setString(4, "ASAP");
	                    cstmt.executeUpdate();
	                    int outcode = cstmt.getInt(5);
	                    ddreturnmsg = cstmt.getString(6);
	                    cstmt.close();
	                    System.out.println("DDOutcode: " + outcode);
	                    System.out.println("DDOutmsg: " + ddreturnmsg);
	        	    	 
	     	    		
	     	           
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
		
	
		return ddreturnmsg;
	}
}
