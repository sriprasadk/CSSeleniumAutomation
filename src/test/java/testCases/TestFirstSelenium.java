package testCases;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class TestFirstSelenium {

	public static void main(String[] args) {

		WebDriver driver = null ;
		try {
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chrome\\107\\chromedriver.exe");
			driver = new ChromeDriver();
			String expectedTitle = "Coders Stack";
			driver.get("https://www.codersstack.com");
			//driver.get("https://www.google.com");
			String actualTitle = driver.getTitle();

			System.out.println("title " + actualTitle) ;
			assertEquals("Title is not the same",actualTitle, expectedTitle);
			if (actualTitle.equalsIgnoreCase(expectedTitle)){
				System.out.println("Test Passed. " + actualTitle);
			} else {
				System.out.println("Test Failed. " + actualTitle);
			}
		}finally {
			driver.close() ;
		}
	}
}
