package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
     WebDriver driver;
     private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver=driver;
        navigate = driver.navigate();
    }
    public void goBack(){
        navigate.back();
    }
    public void goForward(){
        navigate.forward();
    }
    public void Refresh(){
        navigate.refresh();
    }
    public void goToURL(String url){
        navigate.to(url);
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }



}
