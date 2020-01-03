package com.healer.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusinessService {

	public String DisplayName(String username) throws ClassNotFoundException, SQLException {
		String desc = null;
		Connection conn = null;
	       Statement stmt=null;
	       ResultSet vrs=null;
	        String dbdriver = "oracle.jdbc.driver.OracleDriver";
	        Class.forName(dbdriver);
	        
	        String URL = "jdbc:oracle:thin:asap/asap@ex05-scan.windstream.com:1521/msnn03.windstream.com";
	        
	      	conn = DriverManager.getConnection(URL);
	        try {
	        	     	
	        		    
	        		  
	        	      	
	        	    	stmt = conn.createStatement(); 
	     	    		vrs = stmt.executeQuery("select description from security_users where name ='"+username+"'") ;  
	     	    		while(vrs.next())
	     	            {
	     	    			desc=vrs.getString(1);
	     	            	System.out.println("desc - "+desc);
	     	            } 
	     	    		if(desc==null) {
	     	    			vrs = stmt.executeQuery("select description from security_users where upper(name) ='"+username+"'") ;
	     	    			while(vrs.next())
		     	            {
		     	    			desc=vrs.getString(1);
		     	            	System.out.println("desc - "+desc);
		     	            } 
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
		return desc;
	}
}
