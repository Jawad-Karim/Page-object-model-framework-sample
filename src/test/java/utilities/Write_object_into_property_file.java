package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Write_object_into_property_file {
	
	public static void main(String[] args) throws Exception {
		object_writer();
	}

	public static void object_writer() throws Exception {
		
		// store data into existed file / create new file in config_data folder
		File file = new File("config_data\\newFile.properties");
		FileOutputStream fos = new FileOutputStream(file);
		
		Properties pro = new Properties();
		pro.put("id",  "365467");
		pro.put("password", "test123");
		pro.put("phone", "21245557788");
		pro.store(fos, "this is new file");
		System.out.println("file is created");
		
		// read data
		FileInputStream fis = new FileInputStream(file);
		String id = pro.getProperty("id");
		System.out.println(id);

	}

}
