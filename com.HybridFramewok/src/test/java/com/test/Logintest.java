package com.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.LoginPage;
import com.Utility.PropertiesUtils;

//@Listeners(com.listerner.MyListener.class)
public class Logintest extends BaseClass {

	public LoginPage lp = null;

	@BeforeSuite
	public void setup() throws Exception {
		initialization();
		reportInit();
		lp = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void logintest() throws Exception {
		String uname = PropertiesUtils.readProperties("username");
		String pass = PropertiesUtils.readProperties("password");
		lp.loginToApplication(uname, pass);

		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test(priority = 2)
	public void failTest() throws Exception {
		Assert.assertEquals(driver.getTitle(), "test");
	}

	@Test(priority = 3)
	public void skipTest() {
		throw new SkipException("skipping a testcase");
	}
}
