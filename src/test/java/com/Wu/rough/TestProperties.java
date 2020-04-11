package com.Wu.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException  {
		
		
		System.out.println(System.getProperty("user.dir"));
		Properties pro=new Properties();
		Properties OR=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		pro.load(fis);
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fi);
		System.out.println(pro.getProperty("Browser"));
		System.out.println(OR.getProperty("dropdown"));
	}

}
