package driverFactory.Mobile;

import driverFactory.CommonDriverFactoryMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class DriverFactory extends CommonDriverFactoryMethod {

    protected AndroidDriver driver;
    public static String errorMessage = "";

    public DriverFactory(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    protected boolean isElementAvailable(WebElement element, int timeoutVal) {

        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        return super.isElementAvailable(element, timeoutVal, driver);
    }

    protected boolean isElementsPresent(List<AndroidElement> element, int timeoutVal) {
        try {
            for (int i = 0; i < timeoutVal; i++) {
                try {
                    fluentWait(timeoutVal - i, driver).until(ExpectedConditions.visibilityOf(element.get(0)));
                    return true;
                } catch (IndexOutOfBoundsException e) {
                    Thread.sleep(1000);
                    continue;
                } catch (TimeoutException e) {
                    Thread.sleep(1000);
                    continue;
                }
            }
        } catch (NoSuchElementException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    protected boolean isTextPresentFromList(List<AndroidElement> elements, String text, int wait) {
        if (isElementsPresent(elements, wait)) {
            for (AndroidElement ele : elements) {
                if (ele.getText().equals(text)) {
                    return true;
                }
            }
            errorMessage = text + "is not present in text view";
            return false;
        } else {
            throw new ElementNotVisibleException("Unable to find all text with text view");
        }
    }

    protected void waitForElementToDisAppear(AndroidElement element, int timeToWait) throws InterruptedException {
        for (int i = 0; i < timeToWait; i++) {
            if (isElementAvailable(element, 1)) {
                continue;
            }
            return;
        }
        Assert.fail(element + "Element is still appear after " + timeToWait + " seconds");
    }

    protected String getToastMessage() {
        return driver.findElement(By.xpath("//android.widget.Toast[1]")).getText();
    }

}


