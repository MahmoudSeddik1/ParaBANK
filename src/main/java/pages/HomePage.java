package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//h1[@class='title']")
    WebElement ErrorHeader;



    @FindBy(xpath = "//p[@class='error']")
    WebElement ErrorMessage;


    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   public MainPage login_predefined(){
        usernameField.sendKeys("john");
        passwordField.sendKeys("demo");
        loginButton.click();
        return new MainPage(driver);
   }
   public MainPage login_custom(String username, String passwrord){
        usernameField.sendKeys(username);
        passwordField.sendKeys(passwrord);
        loginButton.click();
        return new MainPage(driver);
   }
   public MainPage login_TAB(String username, String password){
        usernameField.sendKeys(username);
        usernameField.sendKeys(Keys.chord(Keys.TAB, password,Keys.TAB,Keys.ENTER));
//        loginButton.click();
        return new MainPage(driver);
   }
   public String getErrorHeader(){
        return ErrorHeader.getText();
   }
    public String getErrorMessage() {
        return ErrorMessage.getText();
    }



}
