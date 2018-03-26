package com.cdc.mitrais.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		Properties prop = new Properties();
    	InputStream input = null;
    	
    	try {
        
    		String filename = "db.properties";
    		input = Test.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
    		    return;
    		}

    		//load a properties file from class path, inside static method
    		prop.load(input);
 
                //get the property value and print it out
                System.out.println(prop.getProperty("db_driver"));
    	        System.out.println(prop.getProperty("db_user"));
    	        System.out.println(prop.getProperty("db_url"));
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }
	}

}
