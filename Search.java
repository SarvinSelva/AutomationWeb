package mydemo;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Search {
public static void main(String[] args) {
Search searchTest = new Search();
searchTest.search();	
}
@Test
public void search() {
ExtentReports extent;
ExtentTest test;
extent = new ExtentReports("C:\\Users\\sarvin\\eclipse-workspace\\AutomationProject\\test_reports\\Search.html",true);
test = extent.startTest("Product Search Test ");
System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe");
DesiredCapabilities capabilities = DesiredCapabilities.firefox();
capabilities.setCapability("marionette",true);
WebDriver driver =new FirefoxDriver(capabilities);
driver.navigate().to("http://automationpractice.com/index.php");
test.log(LogStatus.PASS, "Navigates into Search TextBox");
driver.findElement(By.name("search_query")).sendKeys("T-shirt");
test.log(LogStatus.PASS, "The product to be searched is entered");
driver.findElement(By.name("submit_search")).click();
test.log(LogStatus.PASS, "Displays the T-shirt related to search item");
WebElement img = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[src='http://automationpractice.com/img/p/1/1-home_default.jpg']")));
img.click();
test.log(LogStatus.PASS, "Select the AddToCart option");
WebElement add = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
add.click();
extent.endTest(test);
extent.flush();
}
}
