package mydemo;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Register {
		public static void main(String[] args) throws InterruptedException {
			
			Register registerTest = new Register();
			registerTest.registrationTest();
		}
		@Test
		public void registrationTest() throws InterruptedException {
		ExtentReports extent;
		ExtentTest test;
		extent = new ExtentReports("C:\\Users\\sarvin\\eclipse-workspace\\AutomationProject\\test_report\\Register.html",true);
		test = extent.startTest("New UserAccount Registration Test");
		System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette",true);
		WebDriver driver =new FirefoxDriver(capabilities);
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.name("email_create")).sendKeys("yellow222@gmail.com");
		driver.findElement(By.name("SubmitCreate")).click();
		test.log(LogStatus.PASS, "Enter the Details in the registration form");
		WebElement radio=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		radio.click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Sarvin");
		driver.findElement(By.id("customer_lastname")).sendKeys("S S");
		driver.findElement(By.id("passwd")).sendKeys("Sarvin");
		test.log(LogStatus.PASS, "UserName and Password is confirmed");
		Select dropdown = new Select(driver.findElement(By.id("days")));
		dropdown.selectByIndex(20);
		Select dropdown1 = new Select(driver.findElement(By.id("months")));
		dropdown1.selectByIndex(7);
		Select dropdown2 = new Select(driver.findElement(By.id("years")));
		dropdown2.selectByIndex(21);
		driver.findElement(By.id("company")).sendKeys("BNP Paribas");
		driver.findElement(By.id("address1")).sendKeys("43/3,Main Road");
		driver.findElement(By.id("address2")).sendKeys("Pattukkottai");
		driver.findElement(By.id("city")).sendKeys("Thanjavur");
		Select dropdown3 = new Select(driver.findElement(By.id("id_state")));
		dropdown3.selectByVisibleText("Florida");
		driver.findElement(By.id("postcode")).sendKeys("12345");
		Select dropdown4 = new Select(driver.findElement(By.id("id_country")));
		dropdown4.selectByVisibleText("United States");
		driver.findElement(By.id("phone_mobile")).sendKeys("9047318159");
		test.log(LogStatus.PASS, "check the details that have been entered is correct");
		driver.findElement(By.id("submitAccount")).click();
	}
}
