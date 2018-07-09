package ywt.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ReadCharsetProperties {
	
	public static String charset="";
	
	static  {    
        Properties prop =  new  Properties();    
        InputStream in =    ReadCharsetProperties.class.getClassLoader().getResourceAsStream("charset.properties");
         try  {    
            prop.load(in);    
            charset = prop.getProperty( "ywtcharset" ).trim();    
            System.out.println("charset="+charset);
        }  catch  (IOException e) {    
            e.printStackTrace();    
        }    
    }    
	
}
