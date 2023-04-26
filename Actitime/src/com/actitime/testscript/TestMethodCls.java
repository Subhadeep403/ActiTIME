package com.actitime.testscript;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	import com.actitime.pom.LoginPage;
	//LoginPage class
	public class TestMethodCls {
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
		@Test
		public void validLogin() {
			WebDriver driver= new ChromeDriver();
			driver.get("https://demo.actitime.com/");
			driver.manage().window().maximize();
			LoginPage l= new LoginPage(driver);
			l.setLogin("admin","manager");
		}
			
	}


