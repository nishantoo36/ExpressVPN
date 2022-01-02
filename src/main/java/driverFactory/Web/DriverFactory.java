package driverFactory.Web;



import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class DriverFactory {
    protected WebDriver driver;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }

    protected List<String> getValuesByElementList(List<WebElement> elements) {
        List<String> values = new ArrayList<>();
        for (WebElement element:elements){
            values.add(element.getText());
        }
        return values;
    }

    public void scrollDownToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    protected boolean isElementListAvailable(List<WebElement> element, int timeoutVal) {
            for (int i=0;i<timeoutVal;i++) {
                try {
                    if (element.get(0).isDisplayed()) {
                        return true;
                    }
                } catch (TimeoutException | NoSuchElementException e) {
                    e.printStackTrace();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            return false;
        }

}


