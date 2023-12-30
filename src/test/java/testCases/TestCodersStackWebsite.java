package testCases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import base.SeleniumMain;

public class TestCodersStackWebsite {
    protected String main_page = "https://www.codersstack.com";
    public WebDriver driver;

    public SeleniumMain base_selenium = SeleniumMain.getSeleniumMainInstance();
  
    @Before
    public void before() {
        driver = base_selenium.getChromeDriver();
     }

    @After
    public void after() {
        base_selenium.quitWebDriver();
    }
	
    @Test
	public void testCodersStackTitle() {
        String expectedTitle = "Coders Stack";
        String actualTitle = "";
        driver.get(main_page);
        actualTitle = driver.getTitle();
        
        System.out.println("title " + actualTitle) ;
        assertEquals("Title is not the same",actualTitle, expectedTitle);

	}
}
