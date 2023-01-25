package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage {
    WebDriver driver;
    @FindBy(xpath = "//p[@class='smallText']")
    WebElement welcomeMessage;
    @FindBy(linkText = "Log Out")
    WebElement logoutButton;
    @FindBy(linkText = "Products")
    WebElement products;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement goButton;

    public By activityperiod_DDL = By.id("month");
    public By type_DDL = By.id("transactionType");



    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getWelcomeMessage(){
       return welcomeMessage.getText();
    }
    public void logout(){
        logoutButton.click();
    }

    public ProductsPage clickProducts(){
        products.click();
        return new ProductsPage(driver);
    }
    public void clickTableCell(int row, int column){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//table[@id='accountTable']/tbody/tr[" +row+"]/td["+column+"]")));
       String link =  driver.findElement(
               By.xpath("//table[@id='accountTable']/tbody/tr[" +row+"]/td["+column+"]")).getText();
        System.out.println(link);
       driver.findElement(By.linkText(link)).click();
    }

    public List getDDLelements(By DDL){
       return findDDL(DDL).getOptions().stream().map(e->e.getText()).collect(Collectors.toList());
    }
    public void selectDropDown(By DDL, String option){
        findDDL(DDL).selectByVisibleText(option);
    }

    private Select findDDL(By DDL){
        return new Select(driver.findElement(DDL));
    }







}
