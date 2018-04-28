package org.blog.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public String getDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
	
	public String now() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date();
		return null;
	}

}
