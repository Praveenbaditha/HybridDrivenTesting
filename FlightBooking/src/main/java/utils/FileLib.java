package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLib {

	public static String readPropertyData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
	}
}
