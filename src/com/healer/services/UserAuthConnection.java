package com.healer.services;
 
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.NamingException;

import java.util.Properties;

public class UserAuthConnection {

    private String host = "";
    private int port = 0;
    private String dn = "";
    private String password = "";

    public UserAuthConnection() {
	try {

		this.host = PropertiesManager.getProperty("LDAPServer",null);
		this.port = Integer.parseInt(PropertiesManager.getProperty("LDAPServerPort",null));
		this.dn = PropertiesManager.getProperty("LDAPBindUser",null);
		this.password = PropertiesManager.getProperty("LDAPBindPassword",null);

		} catch(Exception e) {

		}
    }

    public UserAuthConnection(String dn, String password) throws Exception{

		try {

			this.host = PropertiesManager.getProperty("LDAPServer",null);
			this.port = Integer.parseInt(PropertiesManager.getProperty("LDAPServerPort",null));
			this.dn = dn;
			this.password = password;//HD
		}
		catch(Exception e) {
			throw e;
		}
    }

    public UserAuthConnection(String host, int port,
                          String dn, String password) {
        this.host = host;
        this.port = port;
        this.dn = dn;
        this.password = password;
    }

    public DirContext open() throws NamingException
    {
        Properties env = new Properties();
        env.put(DirContext.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); 
        env.put(DirContext.PROVIDER_URL,"ldap://" + host + ":" + port);

        if (dn != null) {
            env.put(DirContext.SECURITY_PRINCIPAL,dn);
            env.put(DirContext.SECURITY_CREDENTIALS,password);
        }

		if (port == 9001)//production users 9001 for the secure port
		{
        	env.put(DirContext.SECURITY_PROTOCOL,"ssl");
		}
 
        DirContext dirContext = new InitialDirContext(env);
        return dirContext;
    }

    public void close(DirContext dc)
    {
        try
        {
            dc.close();
        }
        catch (NamingException ne)
        {
        }
    }

    public UserAuthConnection(String userDn, String password, String identifier) {
    	
    	try {  
    		if(identifier.equals("CSOLDAPSYSUID"))
    		{	      			
    			this.host = PropertiesManager.getProperty("CSOLDAPServer",null);
    			this.port = Integer.parseInt(PropertiesManager.getProperty("CSOLDAPServerPort",null));
     			this.dn = PropertiesManager.getProperty("CSOLDAPBindUser",null);
    			this.password = PropertiesManager.getProperty("CSOLDAPBindPassword",null);
    		} 

    		else if(identifier.equals("CSOLDAPUID"))
        		{      				
        			this.host = PropertiesManager.getProperty("CSOLDAPServer",null); 
        			this.port = Integer.parseInt(PropertiesManager.getProperty("CSOLDAPServerPort",null));
        			this.dn = userDn;
        			this.password  = password; 
        		} 
    		} catch(Exception e) {

    		}
        }
    
}   
    
    
  
     
    

    
    

