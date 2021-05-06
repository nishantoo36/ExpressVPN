package driverFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class CommonDriverFactoryMethod {

    protected Wait fluentWait(int timeoutVal,Object driver) {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeoutVal))
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait;
    }

    protected boolean isElementAvailable(WebElement element, int timeoutVal,Object driver) {
        boolean ret = false;
        try {
            fluentWait(timeoutVal,driver).until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                ret = true;
                return ret;
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
        return ret;
    }


}
