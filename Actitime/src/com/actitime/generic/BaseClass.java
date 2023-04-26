package com.actitime.generic;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Reporter;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;

	public class BaseClass {
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
	 public static WebDriver driver;
		public FileInputStream fis;
		public Properties p;
		@BeforeClass
		public void openBrowser()  {
			Reporter.log("openBrowser",true);
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		@AfterClass
		public void closeBrowser() {
			Reporter.log("closeBrowser",true);
			driver.close();
		}
		@BeforeMethod
		public void Login() throws IOException {
			Reporter.log("Login",true);
			fis= new FileInputStream("./data/commondata.property");
			p=new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			driver.get(url);
			String un = p.getProperty("username");
			String pw = p.getProperty("password");
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.name("pwd")).sendKeys(pw);
			driver.findElement(By.xpath("//div[text()='Login ']")).click();
		}
		@AfterMethod
		public void Logout() {
			Reporter.log("Logout",true);
			driver.findElement(By.id("logoutLink")).click();
		}
}
