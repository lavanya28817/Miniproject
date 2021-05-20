package com.properties;

import java.io.File;
import java.io.FileInputStream;


import java.util.Properties;

public class Readconfig {
	Properties pro;
	public Readconfig() {
		File src=new File("./configurations/configpro");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("get error message" +e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		
		return url;
	}
	public String getUsername() {
		String user=pro.getProperty("username");
		return user;
		
	}
	public String getPassword() {
		String pass=pro.getProperty("password");
		return pass;
	}
	public String getChromepath() {
		String cpath=pro.getProperty("chromepath");
		return cpath;
	}
	public String getFirefoxpath() {
		String Fpath=pro.getProperty("firefoxpath");
		return Fpath;
	}
	public String getIepath() {
		String Ipath=pro.getProperty("iepath");
		return Ipath;
	}

}
