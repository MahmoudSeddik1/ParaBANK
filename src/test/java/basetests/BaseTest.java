package basetests;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.MainPage;
import utils.MyListener;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver original;
    private WebDriver driver;
    private MyListener listener;
    protected HomePage homepage;
    protected MainPage mainpage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\12378\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        original = new ChromeDriver(options());
        listener = new MyListener();
        driver = new EventFiringDecorator(listener).decorate(original);
        homepage=new HomePage(driver);
        mainpage = new MainPage(driver);
        goHome();


    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");
    }

    @BeforeMethod
    public void beforeTestCase(Method m) {
        System.out.println("Executing: " + m.getName());
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var Camera = (TakesScreenshot) driver;
            File Screenshot = Camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(Screenshot,
                        new File("resources/screenshots/" + result.getName() + ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
//    @AfterClass
//    public void closeAll(){
//        driver.quit();
//    }
    public void clickOn(WebElement Element){
        Element.click();
    }
    public void Wait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    public void closeSession(){
        driver.close();
    }


    public ChromeOptions options() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);
//        options.setHeadless();
        return options;

    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}


