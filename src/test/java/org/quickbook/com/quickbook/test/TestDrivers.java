package org.quickbook.com.quickbook.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestDrivers {

	@DataProvider(name = "user-agents")
	public Object[][] createUserAgents() {
		Object[][] object = new Object[][] { new Object[] { "MSIE", 200 }, new Object[] { "FireFox", 200 },
				new Object[] { "Safari", 301 }, new Object[] { "WAP", -1 } };
		return object;
	}

	@Test(dataProvider = "user-agents")
	public void verifyUserAgents(String s, int code) {
		assert getReturnCode(s) == code;
	}

	private int getReturnCode(String s) {
		int code = 0;
		Object[][] object = createUserAgents();
		for (int i = 0; i < object.length; i++) {
			if (object[i][0] == s) {
				code = (Integer) object[i][1];
			}
		}

		return code;
	}

//	@Test
	public void testFirefox() {
//		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("www.google.com");

		driver.close();
	}
}
