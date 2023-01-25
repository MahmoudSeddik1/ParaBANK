package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyListener implements WebDriverListener {
    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Clicking on element: "+ element.getText());
    }
}
