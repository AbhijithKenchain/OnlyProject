package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	
	public int randomNum() {
		Random r=new Random();
		int random=r.nextInt(500);
		return random;
	}
	
	public String systemDate()
	{
		Date date=new Date();
		String systDate = date.toString();
		return systDate;
		
	}
	public String systemDateInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date=new Date();
		String systemDateInFormat=dateformat.format(date);
		return systemDateInFormat;
	}
}
