package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	

	
	@Test
	public void play() {
		
		int a = 10;
		int b = 20;
		
		Assert.assertEquals(a, b, "numbers are not equal");
		
	}

}
