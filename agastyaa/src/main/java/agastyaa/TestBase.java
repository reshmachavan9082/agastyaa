/*
 * How to execute failed test cacess:
 * We have failed.xml file in testng there we can fixed the test casess and execute that file
 */
package agastyaa;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.agastyaa.config.Configuration;

public class TestBase {
	public Configuration config;
	private static final String NULL = null;
	public static RemoteWebDriver driver;

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	// @Parameters({"browser-name"})
	@BeforeMethod

	public RemoteWebDriver setUp(@Optional String browserName) {

		config = new Configuration();// to getappUrl()
		if (browserName == NULL) {
			browserName = "Chrome";
		}
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			// System.out.println("Chrome browser cbt testing");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			// System.out.println("Edge browser cbt testing");
		} else {
			System.out.println("Invalid driver" + browserName);
			driver = new ChromeDriver();
		}
		String url = config.getAppUrl("beta");
		driver.get(url);
		System.out.println("Launching URL:" + url);
		// driver.get("beta");//we are giving env path for url from configuration class
		return driver;

	}

	@AfterMethod

	public void tearDown() {
		// driver.quit();

	}

}
