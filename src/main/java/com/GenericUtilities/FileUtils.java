package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @para
 * 
 * 
 * 
 */
public class FileUtils {

/**this method gives data from property file 
 * 	
 * @param key
 * @return 
 * @throws IOException
 */
public String readFromPropertyFile(String key) throws IOException 
{
	FileInputStream fis=new FileInputStream(IPathConstants1.Filepath);
	Properties p= new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}

}
