package com.healer.servlet;

import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.ServiceUnavailableException;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import com.healer.services.PropertiesManager;
import com.healer.services.UserAuthConnection;

//import org.apache.log4j.Logger;

//import db.DBConnection;

public class AuthenticationServices {

	public boolean ldapCSOAuthentication(String csoUserId, String csoPassword) throws AuthenticationException, NamingException, Exception {
        boolean isCSOUserExists = false;
  
        try
        {
            isCSOUserExists = authenticateCSOLDAP(csoUserId, csoPassword);
        }
        catch (AuthenticationException ae)
        {
            throw ae;
        }
        catch (NamingException ne)
        {
            throw ne;
        }
        catch (Exception e)
        {
            throw e;
        }
        return isCSOUserExists;
  }
public boolean authenticateCSOLDAP(String strInUserId, String strInPasswd) throws AuthenticationException, NamingException, Exception
  {          
        boolean isCSOUserExists = false;

        try
        {
              isCSOUserExists = loginCSO(strInUserId,strInPasswd);
        }
        catch (AuthenticationException ae)
        {
        	System.out.println("Inside Authentication Exception - "+ae.getMessage());
              throw ae;
        }
        catch (NamingException ne)
        {
              throw ne;
        }
        catch (Exception e)
        {
              throw e;
        }
        return isCSOUserExists;

  }//end authenticateInLDAP
  
public static boolean loginCSO(String username, String password) throws AuthenticationException, NamingException, Exception{
      DirContext dc = null;
      boolean isCSOUserExists=false;  
      
      String sFilter="uid=" + username;
      
      UserAuthConnection userAuthConn = new UserAuthConnection(username, password, "CSOLDAPSYSUID");
      
      	String sUserBase = PropertiesManager.getProperty("CSOUserBase",null);
        
      try {  
          dc = userAuthConn.open();               
          NamingEnumeration UserDNAnswer = dc.search(sUserBase, sFilter, null);
        
          String sReturnedFQDN = "";
              // Probably should not be a while loop, if we have more than one entry that is bad
              while (UserDNAnswer.hasMore()) {
                    SearchResult sr = (SearchResult) UserDNAnswer.next();                     
                    sReturnedFQDN = sr.getName()+","+ sUserBase;
              }

              if(!sReturnedFQDN.equals(""))
              {
                  UserAuthConnection userAuthConn2 = new UserAuthConnection(sReturnedFQDN, password, "CSOLDAPUID");
                  // Doing this so a login failure throws a code
                    try  {  
                        dc = userAuthConn2.open();
                        isCSOUserExists = true;

                        userAuthConn2.close(dc);
                          } catch (CommunicationException ce) {
            
                              throw ce;
                          } catch (ServiceUnavailableException sue){
            
                              throw sue;
                          }catch (NamingException ne) {
                              //debug
                              ne.printStackTrace();
                              throw ne;
                          } catch (Exception e){
            
                                    throw e;
                              }

              }
        } catch (AuthenticationException ae){
              throw ae;
      } catch (CommunicationException ce) {
  
              throw ce;
      } catch (ServiceUnavailableException sue){
          throw sue;
      } catch (NamingException ne) {
          //debug
          ne.printStackTrace();
          throw ne;
      } catch (Exception e){
              throw e;
        }
      return isCSOUserExists; 
}


}
