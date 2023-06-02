package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class RedaObjectUtility {
	
	public File file = null;
	public FileInputStream fis = null;
	public Properties pro = null;
	
	public RedaObjectUtility() {
		
		try {
			
			file = new File("./config_data/config.properties");
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception message : "+e.getMessage());
			System.out.println("Excepton cause : "+e.getCause());
		}
		
	}
	
	public String getBankUrl() {
		
		return pro.getProperty("guruBankUrl");
	}
	
	
	public String getUserName() {
		
		return pro.getProperty("username");
	}
	
	
	public String getPassword() {
		
		return pro.getProperty("password");
	}
	

}
