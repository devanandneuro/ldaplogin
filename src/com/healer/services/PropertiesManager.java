package com.healer.services;
import java.util.*;

public class PropertiesManager
{
	public static String getProperty(String attribute, Object object)
	{
		PropertyResourceBundle props;
		props = (PropertyResourceBundle) ResourceBundle.getBundle("com.healer.resources.ldap");
		String value="";
		if(value.equalsIgnoreCase(""))
		{
			value=props.getString(attribute);
		}
		return value;
	}
}