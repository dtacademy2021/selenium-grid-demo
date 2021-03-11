package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * A utility class to read from a properties file
 * with a wrapper method getProperty() to obtain property on a given key
 */

public class ConfigReader {
	
	private static Properties prop; 
	
	static { 
		prop = new Properties();
		FileInputStream fi;
		try {
			fi = new FileInputStream("config.properties");
			prop.load(fi);
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	
	public static String getProperty(String key) {
		
		return prop.getProperty(key);
		
	}

}
