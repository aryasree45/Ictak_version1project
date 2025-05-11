package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginTest extends TestBase {
	String Expected_Home="Admin Dashboard";
	String  Expected_Message="Invalid username or password";
	LoginPage lobj;
	
	@BeforeClass
	public void objinit() {
		lobj=new LoginPage(driver);
	}
	@Test
	public void TC_1_1_1() {
		lobj.btnclk();
		
	}
	@Test
	public void TC_2_1_1() {
		driver.get("https://ictak-internship-portal-client.vercel.app/");
		lobj.btnclk();
		lobj.getUsername("ictak@example.com");
		lobj.getPasswd("0000");
		lobj.btnclklog();
		
	}
	@Test
	public void TC_2_1_2() {
		driver.get("https://ictak-internship-portal-client.vercel.app/");
		lobj.btnclk();
		lobj.getUsername("ictak@example.com");
		lobj.getPasswd("1111");
		lobj.btnclklog();
		String errmsg=lobj.errorMessage();
		assertEquals(errmsg, Expected_Message);		
	}
	@Test
	public void TC_2_1_3() {
		driver.get("https://ictak-internship-portal-client.vercel.app/");
		lobj.btnclk();
		lobj.getUsername("icexample.com");
		lobj.getPasswd("0000");
		lobj.btnclklog();
		String errmsg=lobj.errorMessage();
		assertEquals(errmsg, Expected_Message);
	}
}
