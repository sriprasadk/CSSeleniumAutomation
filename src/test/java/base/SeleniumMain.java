package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import java.util.*;
import java.util.concurrent.TimeUnit;


public class SeleniumMain {
    private static final int TIMEOUT_SMALL = 20;
    private static final int TIMEOUT = 30;

    private WebDriver webdriver;
    WebDriverWait webdriverwait;
    public WebElements webelements = new WebElements();

    private static SeleniumMain INSTANCE;
    private SeleniumMain(){}

    public static SeleniumMain getSeleniumMainInstance() {
        if (INSTANCE == null){
            INSTANCE = new SeleniumMain();
        }
        return INSTANCE;
    }

    public WebDriver getChromeDriver(){
    	System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chrome\\107\\chromedriver.exe") ;
    			
        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();
        webdriverwait = new WebDriverWait(webdriver, TIMEOUT_SMALL);
        return webdriver;
    }

    public void quitWebDriver(){
       // webdriver.manage().deleteAllCookies();
        webdriver.close();
    }

    private HashMap<String, String > getLocatorInfo(String element){
        HashMap<String, String> locator_info;
        locator_info = webelements.elements.get(element);
        return locator_info;
    }

    private By getLocator(String element){
        HashMap<String, String> locator_info = getLocatorInfo(element);
        By locator = null;

        if (locator_info.get("method").equals("name")) {
            locator = By.name(locator_info.get("value"));
        } else if(locator_info.get("method").equals("class_name")){
            locator = By.className(locator_info.get("value"));
        }
        return locator;
    }

    public List<WebElement> findElement(String element){
        By locator = getLocator(element);
        HashMap<String, String> locator_info = getLocatorInfo(element);

        List<WebElement> items = webdriver.findElements(locator);
        if (locator_info.get("order").equals("-1")) {
            return items;
        } else {
            List<WebElement> item = new ArrayList<WebElement>();
            item.add(items.get(Integer.parseInt(locator_info.get("order"))));
            return item;
        }
    }

    public WebElement waitUntilElementVisible(String element){
        By locator = getLocator(element);
        return webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getValue(String element){
        waitUntilElementVisible(element);
        WebElement web_element = findElement(element).get(0);
        return web_element.getAttribute("value");
    }

    public void setText(String element, String text){
        waitUntilElementVisible(element);
        WebElement web_element = findElement(element).get(0);
        web_element.sendKeys(text);
    }

    public String getText(String element){
        waitUntilElementVisible(element);
        WebElement web_element = findElement(element).get(0);
        return web_element.getText();
    }

    public void click(String element){
        WebElement web_element = findElement(element).get(0);
        web_element.click();
    }

}
