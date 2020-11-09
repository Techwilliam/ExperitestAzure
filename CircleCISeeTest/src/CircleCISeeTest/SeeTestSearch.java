package CircleCISeeTest;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
public class SeeTestSearch {
	 private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo5MDM5MDg0LCJ4cC5wIjo5MDM5MDc3LCJ4cC5tIjoxNTk2NTQwMjc4MzIxLCJleHAiOjE5MTE5MDAyODAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.xBKwi8oQkb3AepZTQur2JKO4Ahy48IezHTZY6pLrs5s";


	    private RemoteWebDriver driver;
	    private URL url;
	    private DesiredCapabilities dc = new DesiredCapabilities();

	    @BeforeMethod
	    public void setUp() throws Exception {

	        url = new URL("https://cloud.seetest.io/wd/hub");
	        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
	        
	        dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
	        dc.setCapability("accessKey", ACCESS_KEY);
	        dc.setCapability("testName", "Quick Start Chrome Browser Demo");
	        driver = new RemoteWebDriver(url, dc);
	    }


	    @Test
	    public void browserTestGoogleSearch() {
	        driver.get("https://www.google.com");
	        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
	        WebElement searchBar = driver.findElement(By.name("q"));
	        searchBar.click();
	        searchBar.sendKeys("Experitest");
	        searchBar.sendKeys(Keys.ENTER);
	    }

	    @AfterMethod
	    public void tearDown() {
	        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
	        driver.quit();
	    }
}
