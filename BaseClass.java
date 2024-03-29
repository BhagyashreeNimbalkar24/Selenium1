package CommonUtil;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	WebDriver driver = new ChromeDriver();
	
    WebDriverUtil wutil = new WebDriverUtil();
	
	PropertyFileUtil putil = new PropertyFileUtil();
	
	@BeforeSuite
	public void BS() {
		
		System.out.println("Connect to Data Base");
		
	}
	
	@BeforeClass
	public void BC() throws IOException {
		
		//@BeforeClass is use to launch application
		String URL = putil.getDataFromPropertyFile("Url");
		
		WebDriver driver = new ChromeDriver();
		
		//To maximize the window
		wutil.maximize(driver);
		
		//To apply wait for findelement()
		wutil.implicitwait(driver);
		
		//To launch the application
		driver.get(URL);
		
	}
	
	@BeforeMethod
	public void BM() throws IOException {
		
		//@BeforeMethod is use to Login to the application
		String USERNAME =putil.getDataFromPropertyFile("Username");
		
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		// Login to application 
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterMethod
	public void AM() throws InterruptedException {
		
		Thread.sleep(2000);
		//@AfterMethod is use to Signout from the application
		//Mousehover on image
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		wutil.mousehover(driver, image);
		
		//Click on Signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
	
	@AfterClass
	public void AC() {
		//@AfterClass is use to close the browser
		
		driver.quit();
		
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("Disconnect to Data Base");
		
	}

}
